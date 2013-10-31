package ar.uba.fi.tdd.grupo5.framework;

import java.util.ArrayList;
import java.util.List;

public class TestSuite {

	private String name;
	private List<TestCase> tests;
	private List<TestResult> results;
	private int errorCount;
	private int failCount;
	private int okCount;
	private long time;

	/**
	 * Constructs a <code>TestSuite</code>.
	 * 
	 * @param name
	 *            the name that will represent the suite in the final output
	 */
	public TestSuite(String name) {
		this.name = name;
		tests = new ArrayList<>();
		results = new ArrayList<>();
	}

	/**
	 * Add a testCase to the collection.
	 * 
	 * @param test
	 *            the testCase that is added to the collection
	 */
	public void add(TestCase test) {
		tests.add(test);
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
		setUp();
		for (TestCase test : tests) {
			processResult(test.run());
		}
		return generateResult();
	}

	private boolean isEmptyTestSuite() {
		return this.tests.isEmpty();
	}

	private String getEmptyTestSuiteMessage() {
		return "The TestSuite is empty. There are no tests to run.";
	}

	/**
	 * Initiate the counters of the suite
	 */
	private void setUp() {
		errorCount = 0;
		failCount = 0;
		okCount = 0;
		time = 0;
	}

	/**
	 * Update the statistics of the suite.
	 * 
	 * @param result
	 *            the testResult that brings new data to the results
	 */
	private void processResult(TestResult result) {
		results.add(result);
		if (result.isError()) {
			increaseErrorCount();
		}
		if (result.isFail()) {
			increaseFailCount();
		}
		if (result.isOK()) {
			increaseOKCount();
		}
		time += increaseTimeCount(result);
	}

	/**
	 * Generate the output of the executed tests.
	 * 
	 * @return a String the output of the tets, with their results and
	 *         statistical data about them.
	 */
	private String generateResult() {
		String sResult = addTestSuiteName();
		for (TestResult result : results) {
			sResult = addTestResult(sResult, result);
		}
		sResult = addResultStatistics(sResult);
		return sResult;
	}

	private void increaseErrorCount() {
		errorCount++;
	}

	private void increaseFailCount() {
		failCount++;
	}

	private void increaseOKCount() {
		okCount++;
	}

	private long increaseTimeCount(TestResult result) {
		return result.getTestTime();
	}

	private String addTestSuiteName() {
		return "\tTest Suite: " + name + "\n";
	}

	private String addTestResult(String sResult, TestResult result) {
		return sResult + result.toString();
	}

	/**
	 * Generate statistical data of the suite.
	 * 
	 * @param result
	 *            a string that has the previous results of the tests runned.
	 * 
	 * @return a string having the previous results, plus the statistical data
	 *         provided by the counters (fails, errors, OK, execution time).
	 */
	private String addResultStatistics(String result) {
		return result + "Total: " + results.size() + "\tTime:" + time + "ns\n"
				+ "Error: " + errorCount + "\tFailure: " + failCount + "\tOK: "
				+ okCount + "\n";
	}
}
