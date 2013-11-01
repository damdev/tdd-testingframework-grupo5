package ar.uba.fi.tdd.grupo5.framework;

public class TestResult {

	private TestCase test;
	private Throwable throwable;
	private boolean error;
	private boolean fail;
	private long testTime;

	public TestResult() {
	}

	/**
	 * Runs a {@code TestCase}.
	 * 
	 * @see TestCase
	 */
	public void run(TestCase test) {
		this.test = test;
		setUp();
		Timer timer = new Timer();
		timer.setStart();
		try {
			test.testCode();
		} catch (AssertionFailedException assertException) {
			setFailTest(assertException);
		} catch (Throwable exception) {
			setErrorTest(exception);
		} finally {
			setTestTime(timer.getRegisteredTime());
		}
	}

	/**
	 * Returns a string representation of the {@code TestResult}.
	 */
	public String toString() {
		String sResult = "";
		if (isOK()) {
			sResult = "[ok] ";
		}
		if (isFail()) {
			sResult = "[fail]";
		}
		if (isError()) {
			sResult = "[error]";
		}
		sResult = addTestName(sResult);
		sResult = addTime(sResult);
		/*
		 * FIXME El reporte de esta entrega no requiere mostrar el mensaje de la
		 * excepción. Preguntar si se puede agregar el mensaje.
		 */
		// sResult = addAvailableMessage(sResult);
		sResult = addEndLine(sResult);
		return sResult;
	}

	/**
	 * Determines whether the test failed.
	 */
	public boolean isFail() {
		return fail;
	}

	/**
	 * Sets the private fail boolean.
	 * 
	 * @param fail
	 *            the new value of fail
	 */
	private void setFail(boolean fail) {
		this.fail = fail;
	}

	private void setFailTest(Throwable throwable) {
		fail = true;
		this.throwable = throwable;
	}

	/**
	 * Determines whether the test gave error
	 */
	public boolean isError() {
		return error;
	}

	/**
	 * Sets the private error boolean.
	 * 
	 * @param error
	 *            the new value of error
	 */
	private void setError(boolean error) {
		this.error = error;
	}

	private void setErrorTest(Throwable throwable) {
		error = true;
		this.throwable = throwable;
	}

	/**
	 * Determines whether the test was successful or not.
	 */
	public boolean isOK() {
		return !error && !fail;
	}

	/**
	 * Returns the error message of the test, if it's failed.
	 */
	public String getMessage() {
		return throwable.getLocalizedMessage();
	}

	/**
	 * Returns the time of the test.
	 */
	public long getTestTime() {
		return testTime;
	}

	/**
	 * Sets the private long testTime.
	 * 
	 * @param time
	 *            the new value of testTime
	 */
	private void setTestTime(long time) {
		testTime = time;
	}

	/**
	 * Initial setUp of the private booleans.
	 */
	private void setUp() {
		setError(false);
		setFail(false);
		throwable = null;
	}

	private String addTestName(String result) {
		return result + " " + test.getName();
	}

	private String addTime(String result) {
		return result + " (" + testTime + "ns)";
	}

	private boolean isAvailableMessage() {
		return !getMessage().isEmpty();
	}

	private String addAvailableMessage(String result) {
		if (isAvailableMessage()) {
			return result + "\n" + getMessage();
		}
		return result;
	}

	private String addEndLine(String result) {
		return result + "\n";
	}
}
