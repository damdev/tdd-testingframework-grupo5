package ar.uba.fi.tdd.grupo5.framework;

/**
 * A set of assert methods, used in this Test Framework. The failed assertions
 * throws an {@link AssertionFailedException} with a personalized identifying  
 * message, if the user give one.
 */
public class Assert {
	
	/**
	 * Protect constructor because it is a static class
	 */
	protected Assert() {
	}

	/**
	 * Asserts that a condition is true. If it isn't it throws an
	 * {@link AssertionFailedException} with the given message.
	 * 
	 * @param message
	 *            the personalized identifying message for the {@link AssertionFailedException}
	 * @param condition
	 *            condition to be checked
	 */
	static public void assertTrue(String message, boolean condition)
			throws AssertionFailedException {
		if (!condition) {
			throwException(message);
		}
	}
	
	/**
	 * Asserts that a condition is true. If it isn't it throws an
	 * {@link AssertionFailedException} with no message.
	 * 
	 * @param condition
	 *            condition to be checked
	 */
	static public void assertTrue(boolean condition)
			throws AssertionFailedException {
		assertTrue(null, condition);
	}
	
	/**
	 * Asserts that a condition is false. If it isn't it throws an
	 * {@link AssertionFailedException} with the given message.
	 * 
	 * @param message
	 *            the personalized identifying message for the {@link AssertionFailedException}
	 * @param condition
	 *            condition to be checked
	 */
	static public void assertFalse(String message, boolean condition)
			throws AssertionFailedException {
		assertTrue(message, !condition);
	}
	
	/**
	 * Asserts that a condition is false. If it isn't it throws an
	 * {@link AssertionFailedException} with no message.
	 * 
	 * @param condition
	 *            condition to be checked
	 */
	static public void assertFalse(boolean condition)
			throws AssertionFailedException {
		assertFalse(null, condition);
	}

	/**
	 * Asserts that two objects are equal. If they aren't it throws an
	 * {@link AssertionFailedException} with the given message.
	 * Null's objects are considered equals
	 * 
	 * @param message
	 *            the personalized identifying message for the {@link AssertionFailedException}
	 * @param expected
	 *            expected object
	 * @param actual
	 *            actual object
	 */
	static public void assertEquals(String message, Object expected,
			Object actual) throws AssertionFailedException {
		if (equalsConsideringNull(expected, actual)) {
			return;
		}
		throwException(message);
	}

	/**
	 * Asserts that two objects are equal. If they aren't it throws an
	 * {@link AssertionFailedException} with no message.
	 * Null's objects are considered equals
	 * 
	 * @param expected
	 *            expected object
	 * @param actual
	 *            actual object
	 */
	static public void assertEquals(Object expected, Object actual)
			throws AssertionFailedException {
		assertEquals(null, expected, actual);
	}

	/**
	 * Asserts that two long values are equal. If they aren't it throws an
	 * {@link AssertionFailedException} with the given message.
	 * 
	 * @param message
	 *            the personalized identifying message for the {@link AssertionFailedException}
	 * @param expected
	 *            expected long value
	 * @param actual
	 *            actual long value
	 */
	static public void assertEquals(String message, long expected, long actual)
			throws AssertionFailedException {
		assertEquals(message, (Long) expected, (Long) actual);
	}

	/**
	 * Asserts that two long values are equal. If they aren't it throws an
	 * {@link AssertionFailedException} with no message.
	 * 
	 * @param expected
	 *            expected long value
	 * @param actual
	 *            actual long value
	 */
	static public void assertEquals(long expected, long actual)
			throws AssertionFailedException {
		assertEquals(null, expected, actual);
	}

	/**
	 * Asserts that two float values are equal, considering a delta. 
	 * If they aren't it throws an {@link AssertionFailedException} with
	 * the given message.
	 * 
	 * @param message
	 *            the personalized identifying message for the {@link AssertionFailedException}
	 * @param expected
	 *            expected float value
	 * @param actual
	 *            actual float value
	 */
	static public void assertEquals(String message, float expected,
			float actual, float delta) throws AssertionFailedException {
		if (Float.compare(expected, actual) == 0) {
			return;
		}
		if (Math.abs(expected - actual) <= delta) {
			return;
		}
		throwException(message);
	}
	
	/**
	 * Asserts that two float values are equal, considering a delta. 
	 * If they aren't it throws an {@link AssertionFailedException} with no message
	 * 
	 * @param expected
	 *            expected float value
	 * @param actual
	 *            actual float value
	 */
	static public void assertEquals(float expected, float actual, float delta)
			throws AssertionFailedException {
		assertEquals(null, expected, actual, delta);
	}

	/**
	 * Asserts that two double values are equal, considering a delta. 
	 * If they aren't it throws an {@link AssertionFailedException} with
	 * the given message.
	 * 
	 * @param message
	 *            the personalized identifying message for the {@link AssertionFailedException}
	 * @param expected
	 *            expected double value
	 * @param actual
	 *            actual double value
	 */
	static public void assertEquals(String message, double expected,
			double actual, double delta) throws AssertionFailedException {
		if (Double.compare(expected, actual) == 0) {
			return;
		}
		if (Math.abs(expected - actual) <= delta) {
			return;
		}
		throwException(message);
	}

	/**
	 * Asserts that two double values are equal, considering a delta. 
	 * If they aren't it throws an {@link AssertionFailedException} with no message.
	 * 
	 * @param expected
	 *            expected double value
	 * @param actual
	 *            actual double value
	 */
	static public void assertEquals(double expected, double actual, double delta)
			throws AssertionFailedException {
		assertEquals(null, expected, actual, delta);
	}

	/**
	 * Asserts that two objects aren't equal. If they are it throws an
	 * {@link AssertionFailedException} with the given message.
	 * Null's objects are considered equals
	 * 
	 * @param message
	 *            the personalized identifying message for the {@link AssertionFailedException}
	 * @param object1
	 *            unexpected object
	 * @param object2
	 *            actual object
	 */
	static public void assertNotEquals(String message, Object object1,
			Object object2) throws AssertionFailedException {
		if (equalsConsideringNull(object1, object2)) {
			throwException(message);
		}
	}

	/**
	 * Asserts that two objects aren't equal. If they are it throws an
	 * {@link AssertionFailedException} with no message.
	 * Null's objects are considered equals
	 * 
	 * @param object1
	 *            unexpected object
	 * @param object2
	 *            actual object
	 */
	static public void assertNotEquals(Object object1, Object object2)
			throws AssertionFailedException {
		assertNotEquals(null, object1, object2);
	}

	/**
	 * Asserts that two long values aren't equal. If they are it throws an
	 * {@link AssertionFailedException} with the given message.
	 * 
	 * @param message
	 *            the personalized identifying message for the {@link AssertionFailedException}
	 * @param long1
	 *            unexpected long value
	 * @param long2
	 *            actual long value
	 */
	static public void assertNotEquals(String message, long long1,
			long long2) throws AssertionFailedException {
		assertNotEquals(message, (Long) long1, (Long) long2);
	}

	/**
	 * Asserts that two long values aren't equal. If they are it throws an
	 * {@link AssertionFailedException} with no message.
	 * 
	 * @param long1
	 *            unexpected long value
	 * @param long2
	 *            actual long value
	 */
	static public void assertNotEquals(long long1, long long2)
			throws AssertionFailedException {
		assertNotEquals(null, long1, long2);
	}

	/**
	 * Asserts that two float values aren't equal, considering a delta. 
	 * If they are it throws an {@link AssertionFailedException} with
	 * the given message.
	 * 
	 * @param message
	 *            the personalized identifying message for the {@link AssertionFailedException}
	 * @param float1
	 *            unexpected float value
	 * @param float2
	 *            actual float value
	 */
	static public void assertNotEquals(String message, float float1,
			float float2, float delta) throws AssertionFailedException {
		if (Float.compare(float1, float2) == 0) {
			throwException(message);
		}
		if (Math.abs(float1 - float2) <= delta) {
			throwException(message);
		}
	}

	/**
	 * Asserts that two float values aren't equal, considering a delta. 
	 * If they are it throws an {@link AssertionFailedException} with no message.
	 * 
	 * @param float1
	 *            unexpected float value
	 * @param float2
	 *            actual float value
	 */
	static public void assertNotEquals(float float1, float float2, float delta)
			throws AssertionFailedException {
		assertNotEquals(null, float1, float2, delta);
	}

	/**
	 * Asserts that two double values aren't equal, considering a delta. 
	 * If they are it throws an {@link AssertionFailedException} with
	 * the given message.
	 * 
	 * @param message
	 *            the personalized identifying message for the {@link AssertionFailedException}
	 * @param double1
	 *            unexpected double value
	 * @param double2
	 *            actual double value
	 */
	static public void assertNotEquals(String message, double double1,
			double double2, double delta) throws AssertionFailedException {
		if (Double.compare(double1, double2) == 0) {
			throwException(message);
		}
		if (Math.abs(double1 - double2) <= delta) {
			throwException(message);
		}
	}

	/**
	 * Asserts that two double values aren't equal, considering a delta. 
	 * If they are it throws an {@link AssertionFailedException} with no message.
	 * 
	 * @param double1
	 *            unexpected double value
	 * @param double2
	 *            actual double value
	 */
	static public void assertNotEquals(double double1, double double2,
			double delta) throws AssertionFailedException {
		assertNotEquals(null, double1, double2, delta);
	}

	/**
	 * Asserts that two objects are referencing the same object. If they aren't 
	 * it throws an {@link AssertionFailedException} with the given message.
	 * 
	 * @param message
	 *            the personalized identifying message for the {@link AssertionFailedException}
	 * @param expected
	 *            expected object
	 * @param actual
	 *            actual object
	 */	
	static public void assertSame(String message, Object expected, Object actual)
			throws AssertionFailedException {
		if (expected != actual) {
			throwException(message);
		}
	}

	/**
	 * Asserts that two objects are referencing the same object. If they aren't 
	 * it throws an {@link AssertionFailedException} with no message.
	 * 
	 * @param expected
	 *            expected object
	 * @param actual
	 *            actual object
	 */	
	static public void assertSame(Object expected, Object actual)
			throws AssertionFailedException {
		assertSame(null, expected, actual);
	}

	/**
	 * Asserts that two objects aren't referencing the same object. If they are 
	 * it throws an {@link AssertionFailedException} with the given message.
	 * 
	 * @param message
	 *            the personalized identifying message for the {@link AssertionFailedException}
	 * @param object1
	 *            unexpected object
	 * @param object2
	 *            actual object
	 */	
	static public void assertNotSame(String message, Object object1,
			Object object2) throws AssertionFailedException {
		if (object1 == object2) {
			throwException(message);
		}
	}

	/**
	 * Asserts that two objects aren't referencing the same object. If they are 
	 * it throws an {@link AssertionFailedException} with no message.
	 * 
	 * @param object1
	 *            unexpected object
	 * @param object2
	 *            actual object
	 */	
	static public void assertNotSame(Object object1, Object object2)
			throws AssertionFailedException {
		assertNotSame(null, object1, object2);
	}

	/**
	 * The method that actually throw the exception if the assertion failed. Can
	 * have (or not) a message with a description.
	 * 
	 * @param message
	 *        the personalized identifying message for the {@link AssertionFailedException} 
	 * 
	 */
	static public void throwException(String message)
			throws AssertionFailedException {
		if (message == null) {
			throw new AssertionFailedException();
		}
		throw new AssertionFailedException(message);
	}

	private static boolean equalsConsideringNull(Object expected, Object actual) {
		if (expected == null) {
			return actual == null;
		}
		return isEquals(expected, actual);
	}

	private static boolean isEquals(Object expected, Object actual) {
		return expected.equals(actual);
	}
}
