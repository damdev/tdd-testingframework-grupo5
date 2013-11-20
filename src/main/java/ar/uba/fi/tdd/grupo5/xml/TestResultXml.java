package ar.uba.fi.tdd.grupo5.xml;

import ar.uba.fi.tdd.grupo5.framework.TestResult;

public class TestResultXml {
	
	private String testName;
	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public boolean isFail() {
		return fail;
	}

	public void setFail(boolean fail) {
		this.fail = fail;
	}

	public long getTestTime() {
		return testTime;
	}

	public void setTestTime(long testTime) {
		this.testTime = testTime;
	}

	private boolean error;
	private boolean fail;
	private long testTime;

	public TestResultXml(TestResult testResult) {
		testName = testResult.getTestName();
		testTime = testResult.getTestTime();
		error = testResult.isError();
		fail = testResult.isFail();
	}
	
}
