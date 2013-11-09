package ar.uba.fi.tdd.grupo5.framework;

import java.util.ArrayList;
import java.util.List;
import ar.uba.fi.tdd.grupo5.framework.exception.TestException;

public class TestSuite extends Test {

	private static final String ALL_MATCHES_PATTERN = ".*";
	private static final String SEPARATOR = "\n­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­--------------------------\n";
	private List<TestCase> testCases;
	private List<TestSuite> testSuites;
	private List<TestResult> results;
	private Printer printer;
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
		fixture = new Fixture();
		testCases = new ArrayList<>();
		testSuites = new ArrayList<>();
		results = new ArrayList<>();
		printer = new Printer();
		totalTestCaseCount = 0;
		failTestCaseCount = 0;
		errorTestCaseCount = 0;
		time = 0;
	}

	/**
	 * Counts the number of {@code TestCase} in the {@code TestSuite} that match
	 * with the regex
	 * 
	 * @param pattern
	 *            the regex that must match with the test name
	 * 
	 * @return the final count of {@code TestCase}
	 */
	public final int countTestCases(String pattern) {
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

	/**
	 * Counts the total number of {@code TestCase} in the {@code TestSuite}
	 * 
	 * @return the final count of {@code TestCase}
	 */
	public final int countTestCases() {
		return countTestCases(ALL_MATCHES_PATTERN);
	}

	/**
	 * Counts the number of failed {@code TestCase} after run the
	 * {@code TestSuite}
	 * 
	 * @return the number of failed {@code TestCase}
	 */
	public final int countFailTestCases() {
		return failTestCaseCount;
	}

	/**
	 * Counts the number of {@code TestCase} thats return an error after run the
	 * {@code TestSuite}
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
		return run(ALL_MATCHES_PATTERN);
	}

	/**
	 * Run the cases that are in the suite and matches the pattern
	 * 
	 * @param pattern
	 *            the regex that must match with the test name
	 * 
	 * @return the report of the tests executed plus statistical data
	 */
	public final Report run(String pattern) {
		if (isNoTestsThatSatisfyPattern(pattern)) {
			return getNoTestsThatSatisfyPatternMessage(pattern);
		}
		printer.clearPrintText();
		runTests(pattern);
		printer.printSummary(totalTestCaseCount, errorTestCaseCount,
				failTestCaseCount, getRunTime());
		return new Report(printer.getPrintText());
	}

	private void run(String pattern, Fixture fixture, Printer printer) {
		this.fixture = fixture;
		this.printer = printer;
		runTests(pattern);
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

	private Report getNoTestsThatSatisfyPatternMessage(String pattern) {
		String report = getName() + SEPARATOR
				+ "Not available tests that satisfy the pattern " + pattern;
		return new Report(report);
	}

	private boolean isEmptyTestSuite() {
		return countTestCases(ALL_MATCHES_PATTERN) == 0;
	}

	private Report getEmptyTestSuiteMessage() {
		String report = getName() + SEPARATOR
				+ "The TestSuite is empty. There are no tests to run.";
		return new Report(report);
	}

	/**
	 * Run the tests but do not generate a report
	 */
	private void runTests(String pattern) {
		initRunEnviroment();
		Timer timer = new Timer();
		timer.setStart();
		setUp();
		printer.printTestSuiteName(getName());
		for (TestCase testCase : testCases) {
			if (testCase.patternMatches(pattern)) {
				runTestCase(testCase, printer);
			}
		}
		for (TestSuite testSuite : testSuites) {
			runTestSuite(testSuite, pattern);
		}
		tearDown();
		time = timer.getRegisteredTime();
	}

	private void runTestCase(TestCase test, Printer printer) {
		Fixture clonedFixture = fixture.cloneFixture();
		TestResult result = test.run(clonedFixture);
		results.add(result);
		if (result.isOK()) {
			printer.printOkTestCaseResult(test.getName(), result.getTestTime());
		}
		if (result.isError()) {
			increaseErrorCount();
			printer.printErrorTestCaseResult(test.getName(),
					result.getTestTime());
		}
		if (result.isFail()) {
			increaseFailCount();
			printer.printFailTestCaseResult(test.getName(),
					result.getTestTime());
		}
	}

	private void runTestSuite(TestSuite testSuite, String pattern) {
		Fixture clonedFixture = fixture.cloneFixture();
		printer.printEndLine();
		testSuite.run(pattern, clonedFixture, printer);
		failTestCaseCount += testSuite.countFailTestCases();
		errorTestCaseCount += testSuite.countErrorTestCases();
	}

	/**
	 * Reset the counters of the suite and the previous results (if they
	 * exists).
	 */
	private void initRunEnviroment() {
		results.clear();
		totalTestCaseCount = countTestCases();
		failTestCaseCount = 0;
		errorTestCaseCount = 0;
		time = 0;
	}

	private void increaseErrorCount() {
		errorTestCaseCount++;
	}

	private void increaseFailCount() {
		failTestCaseCount++;
	}
}
