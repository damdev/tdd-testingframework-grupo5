package ar.uba.fi.tdd.grupo5;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.uba.fi.tdd.grupo5.framework.AssertionFailedException;

public class AssertionFailedExceptionTest {
	
	private final String message = "Exception message";
	private final String defaultMessage = "Message was not provided";
	
	@Test
	public void testAssertionFailedExceptionString() {
		AssertionFailedException tester = new AssertionFailedException(message);
		assertEquals("AssertionFailedException.getMessage() returns a different message than the constructor parameter", tester.getMessage(), message);
	}

	@Test
	public void testAssertionFailedException() {
		AssertionFailedException tester = new AssertionFailedException();
		assertEquals("AssertionFailedException.getMessage() returns a different default message than the constructor defaults", tester.getMessage(), defaultMessage);
	}
}