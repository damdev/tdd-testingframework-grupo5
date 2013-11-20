package ar.uba.fi.tdd.grupo5.xml;

import java.util.ArrayList;
import java.util.List;

public class TestResultsXml {
	
	private List<TestResultXml> testResults;
	
	public TestResultsXml() {
		testResults = new ArrayList<TestResultXml>();
	}
	
	public List<TestResultXml> getTestResults() {
		return testResults;
	}

	public void addTestResultXml(TestResultXml result) {
		testResults.add(result);
	}
	
}
