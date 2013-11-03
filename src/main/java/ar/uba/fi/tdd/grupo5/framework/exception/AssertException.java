package ar.uba.fi.tdd.grupo5.framework.exception;

/**
 * Thrown to indicate that an assertion has failed.
 */
public class AssertException extends Exception {

	private static final long serialVersionUID = -847889422986201396L;
	private static final String defaultMessage = "Message was not provided";

	/**
	 * Constructs an <code>AssertionFailedException</code> with a personalized
	 * exception message.
	 * 
	 * @param message
	 *            the detail message
	 */
	public AssertException(String message) {
		super(message);
	}

	/**
	 * Constructs an <code>AssertionFailedException</code> with the default
	 * message.
	 */
	public AssertException() {
		super(defaultMessage);
	}
}
