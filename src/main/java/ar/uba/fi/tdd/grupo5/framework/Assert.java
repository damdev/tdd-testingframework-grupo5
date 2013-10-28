package ar.uba.fi.tdd.grupo5.framework;

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
    
    /*OBJECT*/
    static public void assertEquals(String message, Object expected, Object actual) throws AssertionFailedException {
        if (equalsConsideringNull(expected, actual)) {
            return;
        }
        throwException(message);
    }
	
	static public void assertEquals(Object expected, Object actual) throws AssertionFailedException {
		assertEquals(null, expected, actual);
    }
	
	/*LONG*/
    static public void assertEquals(String message, long expected, long actual) throws AssertionFailedException {
    	assertEquals(message, (Long) expected, (Long) actual);
    }
	
	static public void assertEquals(long expected, long actual) throws AssertionFailedException {
		assertEquals(null, expected, actual);
    }	
	
	/*FLOAT*/
    static public void assertEquals(String message, float expected, float actual, float delta) throws AssertionFailedException {
    	if(Float.compare(expected, actual) == 0){
    		return;
    	}
    	if(Math.abs(expected - actual) <= delta){
    		return;
    	}
    	throwException(message);
    }
	
	static public void assertEquals(float expected, float actual, float delta) throws AssertionFailedException {
		assertEquals(null, expected, actual, delta);
    }	
	
	/*DOUBLE*/
    static public void assertEquals(String message, double expected, double actual, double delta) throws AssertionFailedException {
    	if(Double.compare(expected, actual) == 0){
    		return;
    	}
    	if(Math.abs(expected - actual) <= delta){
    		return;
    	}
    	throwException(message);
    }
	
	static public void assertEquals(double expected, double actual, double delta) throws AssertionFailedException {
		assertEquals(null, expected, actual, delta);
    }
	
    /*
     * The method that actually throw the exception if the assertion failed.
     * Can have  (or not) a message with a description.
     * */
    static public void throwException(String msg) throws AssertionFailedException {
        if (msg == null) throw new AssertionFailedException();
        throw new AssertionFailedException(msg);
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
