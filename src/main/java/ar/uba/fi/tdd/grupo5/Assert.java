package ar.uba.fi.tdd.grupo5;

public class Assert {
	
	/* 
	 * If condition result to be false, and exception is raised and
	 * the test will fail.
	 */
	
	static public void assertTrue(String message, boolean condition) throws AssertionFailedException {
        if (!condition) throwException(message);
    }

    static public void assertTrue(boolean condition) throws AssertionFailedException {
        assertTrue(null, condition);
    }

    static public void assertFalse(String message, boolean condition) throws AssertionFailedException {
        assertTrue(message, !condition);
    }

    static public void assertFalse(boolean condition) throws AssertionFailedException {
        assertFalse(null, condition);
    }

    /*
     * The method that actually throw the exception if the assertion failed.
     * Can have  (or not) a message with a description.
     * */
    static public void throwException(String msg) throws AssertionFailedException {
        if (msg == null) throw new AssertionFailedException();
        throw new AssertionFailedException(msg);
    }
}
