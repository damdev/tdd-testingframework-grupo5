package ar.uba.fi.tdd.grupo5.framework;

import java.util.List;
import java.util.ArrayList;
import ar.uba.fi.tdd.grupo5.framework.exception.TestException;
import ar.uba.fi.tdd.grupo5.framework.tagmanager.AllMatch;
import ar.uba.fi.tdd.grupo5.framework.tagmanager.Criteria;

public class TestSuite extends Test {

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
	 * with the criteria recibed
	 * 
	 * @param criteria
	 *            the criteria that must be true to not ignore the test
	 * 
	 * @return the final count of {@code TestCase}
	 */
	public final int countTestCases(Criteria criteria) {
		totalTestCaseCount = 0;
		for (TestCase testCase : testCases) {
			if (testCase.isRunnable(criteria)) {
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

	public final void printOnScreen() {
		printer.printOnScreen();
	}

	public final void notPrintOnScreen() {
		printer.notPrintOnScreen();
	}

	/**
	 * Run all the cases that are in the suite
	 * 
	 * @return the report of the tests executed plus statistical data
	 */
	public final Report run() {
		return run(new AllMatch());
	}

	/**
	 * Run the cases that are in the suite and matches the pattern
	 * 
	 * @param criteria
	 *            the criteria that must be true to not ignore the test
	 * 
	 * @return the report of the tests executed plus statistical data
	 */
	public final Report run(Criteria criteria) {
		if (isEmptyTestSuite()) {
			return printer.printAndReportEmptyTestSuiteMessage(getName());
		}
		if (isNoTestsThatSatisfyPattern(criteria)) {
			return printer.printAndReportNoTestsThatSatisfyPatternMessage(
					getName(), criteria.toString());
		}
		printer.clearPrintText();
		setUp();
		runTests(criteria);
		tearDown();
		printer.printSummary(totalTestCaseCount, errorTestCaseCount,
				failTestCaseCount, getRunTime());
		return printer.getReport();
	}

	private void run(Criteria criteria, Fixture fixture, Printer printer) {
		this.fixture = fixture;
		this.printer = printer;
		runTests(criteria);
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

	private boolean isEmptyTestSuite() {
		return countTestCases(new AllMatch()) == 0;
	}

	/**
	 * Run the tests but do not generate a report
	 * 
	 * @param criteria
	 *            the criteria that must be true to not ignore the test
	 */
	private void runTests(Criteria criteria) {
		initRunEnviroment();
		Timer timer = new Timer();
		timer.setStart();
		setUp();
		printer.printTestSuiteName(getName());
		for (TestCase testCase : testCases) {
			if (testCase.isRunnable(criteria)) {
				runTestCase(testCase, printer);
			}
		}
		for (TestSuite testSuite : testSuites) {
			runTestSuite(testSuite, criteria);
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

	private void runTestSuite(TestSuite testSuite, Criteria criteria) {
		Fixture clonedFixture = fixture.cloneFixture();
		testSuite.run(criteria, clonedFixture, printer);
		printer.printEndLine();
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
