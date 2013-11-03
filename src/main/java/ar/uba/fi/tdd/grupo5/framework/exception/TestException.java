package ar.uba.fi.tdd.grupo5.framework.exception;

public class TestException extends Exception {

	private static final long serialVersionUID = -1140979565525562876L;
	private static final String defaultMessage = "Message was not provided";
	
	public TestException(String message) {
		super(message);
	}
	
	public TestException() {
		super(defaultMessage);
	}
}
