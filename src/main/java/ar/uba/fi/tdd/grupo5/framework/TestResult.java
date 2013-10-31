package ar.uba.fi.tdd.grupo5.framework;

public class TestResult {

	private String testName;
	private boolean error;
	private boolean fail;
	private String message;
	private long testTime;

	/**
	 * Runs a <code>TestCase</code>.
	 * 
	 * @see TestCase
	 */
	public void run(TestCase test) {
		setTestName(test.getName());
		setUp();
		Timer timer = new Timer();
		timer.setStart();
		try {
			test.testCode();
		} catch (AssertionFailedException assertionException) {
			setFail(true);
			setMessage(assertionException.getLocalizedMessage());
		} catch (Exception exception) {
			setError(true);
			setMessage(exception.getLocalizedMessage());
		} finally {
			setTestTime(timer.getRegisteredTime());
		}
	}

	/**
	 * Returns a string representation of the {@code TestResult}.
	 */
	public String toString() {
		String sResult = getTestName();
		sResult = addTime(sResult);
		if (isError()) {
			sResult = addStatusResult(sResult, "ERROR");
		}
		if (isFail()) {
			sResult = addStatusResult(sResult, "FAIL");
		}
		if (isOK()) {
			sResult = addStatusResult(sResult, "OK");
		}
		sResult = addAvailableMessage(sResult);
		sResult = addEndLine(sResult);
		return sResult;
	}

	/**
	 * Returns the name of the test.
	 */
	private String getTestName() {
		return testName;
	}

	private void setTestName(String testName) {
		this.testName = testName;
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
		return message;
	}

	/**
	 * Sets the private String message.
	 * 
	 * @param message
	 *            the new value of message
	 */
	private void setMessage(String message) {
		this.message = message;
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
	 * 
	 */
	private void setTestTime(long time) {
		this.testTime = time;
	}

	/**
	 * Initial setUp of the private booleans.
	 */
	private void setUp() {
		setError(false);
		setFail(false);
		setMessage("");
	}

	private boolean isAvailableMessage() {
		return !message.isEmpty();
	}

	private String addTime(String result) {
		return result + "[" + testTime + "ns]:";
	}

	private String addStatusResult(String result, String status) {
		return result + "\t" + status;
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
