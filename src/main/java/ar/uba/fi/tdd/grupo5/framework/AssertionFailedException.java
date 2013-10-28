package ar.uba.fi.tdd.grupo5.framework;

public class AssertionFailedException extends Exception {

	private static final long serialVersionUID = -847889422986201396L;
	private static final String defaultMessage = "Message was not provided";

	public AssertionFailedException(String msg) {
		super(msg);
	}

	public AssertionFailedException() {
		super(defaultMessage);
	}
}
