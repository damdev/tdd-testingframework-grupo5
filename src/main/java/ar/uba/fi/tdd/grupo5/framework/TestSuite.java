package ar.uba.fi.tdd.grupo5.framework;

import java.util.ArrayList;
import java.util.List;

import ar.uba.fi.tdd.grupo5.framework.exception.TestException;
import ar.uba.fi.tdd.grupo5.framework.tagmanager.AllMatch;
import ar.uba.fi.tdd.grupo5.framework.tagmanager.Criteria;

public class TestSuite extends Test {

	private static final String ALL_MATCHES_PATTERN = ".*";
	private static final String SEPARATOR = "\n­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­--------------------------\n";
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
	 *            the name that will represent the suite in the final report
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
		fixture = new Fixture();
	}

	/**
	 * Counts the number of {@code TestCase} in the {@code TestSuite}
	 * that match with the regex
	 * 
	 * @param pattern
	 * 			the regex that must match with the test name
	 * 
	 * @return the final count of {@code TestCase}
	 */
	public final int countTestCases(Criteria criteria) {
		totalTestCaseCount = 0;
		for (TestCase testCase : testCases) {
			if (isRunnable(testCase, criteria)) {
				totalTestCaseCount += 1;
			}
		}
		for (TestSuite testSuite : testSuites) {
			totalTestCaseCount += testSuite.countTestCases(criteria);
		}
		return totalTestCaseCount;
	}

	/**
	 * Counts the total number of {@code TestCase} in the {@code TestSuite}
	 * 
	 * @return the final count of {@code TestCase}
	 */
	public final int countTestCases() {
		return countTestCases(new AllMatch());
	}

	/**
	 * Counts the number of failed {@code TestCase} after run the {@code TestSuite}
	 * 
	 * @return the number of failed {@code TestCase}
	 */
	public final int countFailTestCases() {
		return failTestCaseCount;
	}

	/**
	 * Counts the number of {@code TestCase} thats return an error 
	 * after run the {@code TestSuite}
	 * 
	 * @return the number of erroneous {@code TestCase}
	 */
	public final int countErrorTestCases() {
		return errorTestCaseCount;
	}

	public final long getRunTime() {
		return time;
	}

	/**
	 * Add a {@code TestCase} to the {@code TestSuite}.
	 * 
	 * @param test
	 *            the {@code TestCase} that is added
	 * @throws TestException
	 */
	public final void add(TestCase test) throws TestException {
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
	public final void add(TestSuite test) throws TestException {
		String testName = name + "." + test.getName();
		if (existsTestSuite(testName)) {
			throwsExistsTestSuiteException(test.getName());
		}
		test.setName(testName);
		testSuites.add(test);
	}

	/**
	 * Run all the cases that are in the suite
	 * 
	 * @return the report of the tests executed plus statistical data
	 */
	public final Report run() {
		if (isEmptyTestSuite()) {
			return getEmptyTestSuiteMessage();
		}
		return run(new AllMatch());
	}

	/**
	 * Run the cases that are in the suite and matches the pattern
	 * 
	 * @param pattern
	 *            the regex that must match with the test name
	 * 
	 * @return the report of the tests executed plus statistical data
	 */
	public final Report run(Criteria criteria) {
		if (isNoTestsThatSatisfyPattern(criteria)) {
			return getNoTestsThatSatisfyPatternMessage(criteria);
		}
		setUp();
		runTests(criteria);
		tearDown();
		return new Report(generateReport());
	}

	private Report run(Criteria criteria, Fixture fixture) {
		this.fixture = fixture;
		return run(criteria);
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

	private boolean isNoTestsThatSatisfyPattern(Criteria criteria) {
		return countTestCases(criteria) == 0;
	}

	private Report getNoTestsThatSatisfyPatternMessage(Criteria criteria) {
		String report = getName() + SEPARATOR
				+ "Not available tests that satisfy the pattern " + criteria.toString();
		return new Report(report);
	}

	private boolean isEmptyTestSuite() {
		return countTestCases(new AllMatch()) == 0;
	}

	private Report getEmptyTestSuiteMessage() {
		String report = getName() + SEPARATOR
				+ "The TestSuite is empty. There are no tests to run.";
		return new Report(report);
	}

	private boolean isRunnable(TestCase test, Criteria criteria){
		return (criteria.match(test.getTagManager()) && test.isRunnable());
	}
	
	/**
	 * Run the tests but do not generate a report
	 */
	private void runTests(Criteria criteria) {
		resetCounters();
		Timer timer = new Timer();
		timer.setStart();
		for (TestCase testCase : testCases) {
			if (isRunnable(testCase, criteria)) {
				runTestCase(testCase);
			}
		}
		for (TestSuite testSuite : testSuites) {
			runTestSuite(testSuite, criteria);
		}
		time = timer.getRegisteredTime();
	}

	private void runTestCase(TestCase test) {
		Fixture clonedFixture = fixture.cloneFixture();
		TestResult result = test.run(clonedFixture);
		results.add(result);
		if (result.isError()) {
			increaseErrorCount();
		}
		if (result.isFail()) {
			increaseFailCount();
		}
	}

	private void runTestSuite(TestSuite testSuite, Criteria criteria) {
		Fixture clonedFixture = fixture.cloneFixture();
		testSuite.run(criteria, clonedFixture);
		failTestCaseCount += testSuite.countFailTestCases();
		errorTestCaseCount += testSuite.countErrorTestCases();
	}

	/**
	 * Reset the counters of the suite and the previous results (if they
	 * exists).
	 */
	private void resetCounters() {
		totalTestCaseCount = countTestCases();
		failTestCaseCount = 0;
		errorTestCaseCount = 0;
		time = 0;
		resetResults();
	}

	private void resetResults() {
		results = new ArrayList<>();
	}

	private void increaseErrorCount() {
		errorTestCaseCount++;
	}

	private void increaseFailCount() {
		failTestCaseCount++;
	}

	/**
	 * Generate the report of the executed tests.
	 * 
	 * @return a String the report of the tests, with their results and
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
		return name + " (" + time + "ns)" + SEPARATOR;
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
