package ar.uba.fi.tdd.grupo5.framework;

/**
 * Thrown to indicate that an assertion has failed.
 */
public class AssertionFailedException extends Exception {

	private static final long serialVersionUID = -847889422986201396L;
	private static final String defaultMessage = "Message was not provided";

	/**
	 * Constructs an AssertionFailedException with a personalized exception
	 * message
	 */
	public AssertionFailedException(String message) {
		super(message);
	}

	/**
	 * Constructs an AssertionFailedException with the default message.
	 */
	public AssertionFailedException() {
		super(defaultMessage);
	}
}
