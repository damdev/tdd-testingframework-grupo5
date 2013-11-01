package ar.uba.fi.tdd.grupo5.framework;

import java.util.ArrayList;
import java.util.List;

public class TestSuite extends Test {

	private List<TestCase> testCases;
	private List<TestSuite> testSuites;
	private List<TestResult> results;
	private int totalTestCaseCount;
	private int failTestCaseCount;
	private int errorTestCaseCount;
	private long time;

	/**
	 * Constructs a <code>TestSuite</code>.
	 * 
	 * @param name
	 *            the name that will represent the suite in the final output
	 */
	public TestSuite(String name) {
		this.name = name;
		testCases = new ArrayList<>();
		testSuites = new ArrayList<>();
		results = new ArrayList<>();
	}

	public int countTestCases() {
		int count = testCases.size();
		for (TestSuite testSuite : testSuites) {
			count += testSuite.countTestCases();
		}
		return count;
	}
	
	public int countFailTestCases() {
		return failTestCaseCount;
	}

	public int countErrorTestCases() {
		return errorTestCaseCount;
	}
	
	/**
	 * Add a {@code TestCase} to the {@code TestSuite}.
	 * 
	 * @param test
	 *            the {@code TestCase} that is added
	 */
	public void add(TestCase test) {
		testCases.add(test);
	}
	
	/**
	 * Add a {@code TestSuite} to the {@code TestSuite}.
	 * 
	 * @param test
	 *            the {@code TestSuite} that is added
	 */
	public void add(TestSuite test) {
		String testName = name + "." + test.getName();
		test.setName(testName);
		testSuites.add(test);
	}

	/**
	 * Run the cases that are in the suite.
	 * 
	 * @return the output string of the tests executed plus statistical data
	 */
	public String run() {
		if (isEmptyTestSuite()) {
			return getEmptyTestSuiteMessage();
		}
		this.runTests();
		return generateReport();
	}
	
	/*
	 * Corre los test sin generar un reporte.
	 */
	private void runTests() {
		resetCounters();
		for (TestCase testCase : testCases) {
			processResult(testCase.run());
		}
		for (TestSuite testSuite : testSuites) {
			runTestSuite(testSuite);
		}
	}

	private void runTestSuite(TestSuite testSuite) {
		testSuite.run();
		failTestCaseCount += testSuite.countFailTestCases();
		errorTestCaseCount += testSuite.countErrorTestCases();
	}

	private void setName(String name) {
		this.name = name;
	}

	private boolean isEmptyTestSuite() {
		return countTestCases() == 0;
	}

	private String getEmptyTestSuiteMessage() {
		String report = getName() + "\n­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­--------------------------\n"
				+ "The TestSuite is empty. There are no tests to run.";
		return report;
	}

	/**
	 * Reset the counters of the suite
	 */
	private void resetCounters() {
		totalTestCaseCount = countTestCases();
		failTestCaseCount = 0;
		errorTestCaseCount = 0;
		time = 0;
	}

	/**
	 * Update the statistics of the suite.
	 * 
	 * @param result
	 *            the testResult that brings new data to the results
	 */
	private String processResult(TestResult result) {
		results.add(result);
		if (result.isError()) {
			increaseErrorCount();
		}
		if (result.isFail()) {
			increaseFailCount();
		}
		time += increaseTimeCount(result);
		return result.toString();
	}

	/**
	 * Generate the output of the executed tests.
	 * 
	 * @return a String the output of the tets, with their results and
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

	private void increaseErrorCount() {
		errorTestCaseCount++;
	}

	private void increaseFailCount() {
		failTestCaseCount++;
	}

	private long increaseTimeCount(TestResult result) {
		return result.getTestTime();
	}

	private String addTestSuiteName() {
		return name + "­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­--------------------------\n";
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
	 *            a string that has the previous results of the tests runned.
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
		report = report + " Summary\n=================="
				+ "\nRun: " + totalTestCaseCount
				+ "\nErrors: " + errorTestCaseCount
				+ "\nFailures: " + failTestCaseCount + "\n";
		return report;
	}
	
	private boolean isFailureTestSuite() {
		return !((totalTestCaseCount - failTestCaseCount - errorTestCaseCount) == totalTestCaseCount);
	}
}
