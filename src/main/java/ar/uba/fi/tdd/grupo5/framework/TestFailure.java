package ar.uba.fi.tdd.grupo5.framework;

public class TestFailure {
	Test test;
	Exception exception;
	
	public TestFailure(Test test, Exception exception) {
		this.test = test;
		this.exception = exception;
	}
	
	public Test getTest() {
		return test;
	}
	
	public Exception getException() {
		return exception;
	}
}
