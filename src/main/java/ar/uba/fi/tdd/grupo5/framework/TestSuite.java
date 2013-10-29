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

	public TestSuite(String name) {
		this.name = name;
		tests = new ArrayList<>();
		results = new ArrayList<>();
	}

	public void add(TestCase test){
		tests.add(test);
	}

	public String run() {
		setUp();
		for (TestCase test : tests){
			processResult(test.run());
		}
		return generateResult();
	}

	private void setUp() {
		errorCount = 0;
		failCount = 0;
		okCount = 0;
		time=0;
	}
	
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

	private String generateResult() {
		String sResult = addTestSuiteName();
		for (TestResult result : results){
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
		return result.getTime();
	}

	private String addTestSuiteName() {
		return "\tTest Suite: " + name + "\n";
	}

	private String addTestResult(String sResult, TestResult result) {
		return sResult + result.toString();
	}

	private String addResultStatistics(String result) {
		return result + "Total: " + results.size() + "\tTime:" + time + "ns\n" 
				+ "Error: " + errorCount + "\tFailure: " + failCount 
				+ "\tOK: " + okCount + "\n";
	}
}
