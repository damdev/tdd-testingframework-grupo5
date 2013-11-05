package ar.uba.fi.tdd.grupo5.framework;

import java.util.ArrayList;
import java.util.List;

import ar.uba.fi.tdd.grupo5.framework.exception.TestException;

public class TestSuite extends Test {

	private static final String ALL_MATCHES_PATTERN = ".*";
	public static final String SEPARATOR = "\n­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­--------------------------\n";
	private List<TestCase> testCases;
	private List<TestSuite> testSuites;
	private List<TestResult> results;
	private int totalTestCaseCount;
	private int failTestCaseCount;
	private int errorTestCaseCount;
	private long time;

	/**
	 * Constructs a {@code TestSuite}.
	 * 
	 * @param name
	 *            the name that will represent the suite in the final output
	 */
	public TestSuite(String name) {
		this.name = name;
		testCases = new ArrayList<>();
		testSuites = new ArrayList<>();
		results = new ArrayList<>();
		totalTestCaseCount = 0;
		failTestCaseCount = 0;
		errorTestCaseCount = 0;
		time = 0;
	}
	
	private void resetResults(){
		results = new ArrayList<>();
	}

	public int countTestCases(String pattern) {
		totalTestCaseCount = 0;
		for (TestCase testCase : testCases) {
			if (testCase.patternMatches(pattern)) {
				totalTestCaseCount += 1;
			}
		}
		for (TestSuite testSuite : testSuites) {
			totalTestCaseCount += testSuite.countTestCases(pattern);
		}
		return totalTestCaseCount;
	}

	public int countTestCases() {
		return countTestCases(ALL_MATCHES_PATTERN);
	}

	public int countFailTestCases() {
		return failTestCaseCount;
	}

	public int countErrorTestCases() {
		return errorTestCaseCount;
	}

	public long getRunTime() {
		return time;
	}

	/**
	 * Add a {@code TestCase} to the {@code TestSuite}.
	 * 
	 * @param test
	 *            the {@code TestCase} that is added
	 * @throws TestException
	 */
	public void add(TestCase test) throws TestException {
		if (existsTestCase(test.getName())) {
			throwsExistsTestCaseException(test.getName());
		}
		testCases.add(test);
	}

	/**
	 * Add a {@code TestSuite} to the {@code TestSuite}.
	 * 
	 * @param test
	 *            the {@code TestSuite} that is added
	 * @throws TestException
	 */
	public void add(TestSuite test) throws TestException {
		String testName = name + "." + test.getName();
		if (existsTestSuite(testName)) {
			throwsExistsTestSuiteException(test.getName());
		}
		test.setName(testName);
		testSuites.add(test);
	}

	/**
	 * Run the cases that are in the suite and matches the pattern
	 * 
	 * @param the
	 *            regex that must match the test before
	 * 
	 * @return the output string of the tests executed plus statistical data
	 */
	public Output run(String pattern) {
		if (isNoTestsThatSatisfyPattern(pattern)) {
			return getNoTestsThatSatisfyPatternMessage(pattern);
		}
		runTests(pattern);
		return new Output(generateReport());
	}

	/**
	 * Run all the cases that are in the suite
	 * 
	 * @return the output string of the tests executed plus statistical data
	 */
	public Output run() {
		if (isEmptyTestSuite()) {
			return getEmptyTestSuiteMessage();
		}
		return run(ALL_MATCHES_PATTERN);
	}

	private boolean existsTestCase(String testName) {
		for (TestCase testCase : testCases) {
			if (testCase.getName().equals(testName)) {
				return true;
			}
		}
		return false;
	}

	private void throwsExistsTestCaseException(String testCaseName)
			throws TestException {
		String message = "Already exists TestCase with that name "
				+ testCaseName;
		throw new TestException(message);
	}

	private boolean existsTestSuite(String testName) {
		for (TestSuite testSuite : testSuites) {
			if (testSuite.getName().equals(testName)) {
				return true;
			}
		}
		return false;
	}

	private void throwsExistsTestSuiteException(String testSuiteName)
			throws TestException {
		String message = "Already exists TestSuite with that name "
				+ testSuiteName;
		throw new TestException(message);
	}

	private void setName(String name) {
		this.name = name;
	}

	private boolean isNoTestsThatSatisfyPattern(String pattern) {
		return countTestCases(pattern) == 0;
	}

	private Output getNoTestsThatSatisfyPatternMessage(String pattern) {
		String report = getName()
				+ SEPARATOR
				+ "Not available tests that satisfy the pattern " + pattern;
		return new Output(report);
	}

	private boolean isEmptyTestSuite() {
		return countTestCases(ALL_MATCHES_PATTERN) == 0;
	}

	private Output getEmptyTestSuiteMessage() {
		String report = getName()
				+ SEPARATOR
				+ "The TestSuite is empty. There are no tests to run.";
		return new Output(report);
	}

	/**
	 * Run the tests but do not generate a report
	 */
	private void runTests(String pattern) {
		resetCounters();
		Timer timer = new Timer();
		timer.setStart();
		for (TestCase testCase : testCases) {
			if (testCase.patternMatches(pattern))
				runTestCase(testCase);
		}
		for (TestSuite testSuite : testSuites) {
			runTestSuite(testSuite, pattern);
		}
		time = timer.getRegisteredTime();
	}

	private void runTestCase(TestCase test) {
		TestResult result = test.run();
		results.add(result);
		if (result.isError()) {
			increaseErrorCount();
		}
		if (result.isFail()) {
			increaseFailCount();
		}
	}

	private void runTestSuite(TestSuite testSuite, String pattern) {
		testSuite.run(pattern);
		failTestCaseCount += testSuite.countFailTestCases();
		errorTestCaseCount += testSuite.countErrorTestCases();
	}

	/**
	 * Reset the counters of the suite and the previous results (if they exists).
	 */
	private void resetCounters() {
		totalTestCaseCount = countTestCases();
		failTestCaseCount = 0;
		errorTestCaseCount = 0;
		time = 0;
		resetResults();
	}

	private void increaseErrorCount() {
		errorTestCaseCount++;
	}

	private void increaseFailCount() {
		failTestCaseCount++;
	}

	/**
	 * Generate the output of the executed tests.
	 * 
	 * @return a String the output of the tests, with their results and
	 *         statistical data about them.
	 */
	private String generateReport() {
		String report = generateReducedReport();
		report = addSummary(report);
		return report;
	}

	private String generateReducedReport() {
		String report = addTestSuiteName();
		for (TestResult result : results) {
			report = addTestCaseReport(report, result);
		}
		for (TestSuite testSuite : testSuites) {
			report = addTestSuiteReport(report, testSuite);
		}
		return report;
	}

	private String addTestSuiteName() {
		return name
				+ " ("
				+ time
				+ "ns)"
				+ SEPARATOR;
	}

	private String addTestCaseReport(String report, TestResult result) {
		return report + result.toString();
	}

	private String addTestSuiteReport(String report, TestSuite testSuite) {
		return report + "\n" + testSuite.generateReducedReport();
	}

	/**
	 * Generate statistical data of the suite.
	 * 
	 * @param report
	 *            a string that contain the results of the tests.
	 * 
	 * @return a string having the previous results, plus the statistical data
	 *         provided by the counters (fails, errors, OK, execution time).
	 */
	private String addSummary(String report) {
		report = report + "\n";
		if (isFailureTestSuite()) {
			report = report + "[failure]";
		} else {
			report = report + "[success]";
		}
		report = report + " Summary\n==================" + "\nRun: "
				+ totalTestCaseCount + "\nErrors: " + errorTestCaseCount
				+ "\nFailures: " + failTestCaseCount + "\n";
		return report;
	}

	private boolean isFailureTestSuite() {
		int totalsuccessTestCaseCount = totalTestCaseCount - failTestCaseCount
				- errorTestCaseCount;
		return totalsuccessTestCaseCount < totalTestCaseCount;
	}
}
