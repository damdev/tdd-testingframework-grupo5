package ar.uba.fi.tdd.grupo5.framework;

public class TestFailure {
	Test test;
	Throwable throwable;
	
	public TestFailure(Test test, Throwable throwable) {
		this.test = test;
		this.throwable = throwable;
	}
	
	public Test getTest() {
		return test;
	}
	
	public Throwable getThowable() {
		return throwable;
	}
}
