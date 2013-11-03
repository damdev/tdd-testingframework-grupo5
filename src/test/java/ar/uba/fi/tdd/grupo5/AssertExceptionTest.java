package ar.uba.fi.tdd.grupo5;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.uba.fi.tdd.grupo5.framework.exception.AssertException;

public class AssertExceptionTest {

	private final String message = "Exception message";
	private final String defaultMessage = "Message was not provided";

	@Test
	public void personalizedExceptionMessage() {
		AssertException tester = new AssertException(message);
		assertEquals("AssertionFailedException.getMessage() returns a "
				+ "different message than the constructor parameter", message,
				tester.getMessage());
	}

	@Test
	public void defaultExceptionMessage() {
		AssertException tester = new AssertException();
		assertEquals("AssertionFailedException.getMessage() returns a "
				+ "different default message than the constructor defaults",
				defaultMessage, tester.getMessage());
	}
}
