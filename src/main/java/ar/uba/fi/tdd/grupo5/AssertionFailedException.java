package ar.uba.fi.tdd.grupo5;

public class AssertionFailedException extends Exception {

	private static final long serialVersionUID = -847889422986201396L;

	public AssertionFailedException(String msg) {
		super(msg);
	}

	public AssertionFailedException() {
		super("Message was not provided");
	}
}
