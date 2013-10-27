package ar.uba.fi.tdd.grupo5;

import java.util.ArrayList;
import java.util.List;

public class TestSuite {

	private String name;
	private List<TestCase> tests;
	private List<TestResult> results;
	private int errorCount;
	private int failCount;
	private int okCount;

	public TestSuite(String name) {
		this.name = name;
		tests = new ArrayList<>();
		results = new ArrayList<>();
		errorCount = 0;
		failCount = 0;
		okCount = 0;
	}

	public void add(TestCase test){
		tests.add(test);
	}

	public String run() {
		for (TestCase test : tests){
			processResult(test.run());
		}
		return generateResult();
	}

	private void processResult(TestResult result) {
		results.add(result);
		if (result.isError()) {
			increaseErrorCount();
		}
	}

	private String generateResult() {
		String sResult = "\tRun Test Suite " + name + "\n";
		for (TestResult result : results){
			sResult = sResult + result.toString();
		}
		sResult = "Error: " + errorCount + "\tFailure: " + failCount + 
				"\tOK: " + okCount + "\n";
		return sResult;
	}
	
	private void increaseErrorCount() {
		errorCount++;
	}
}
