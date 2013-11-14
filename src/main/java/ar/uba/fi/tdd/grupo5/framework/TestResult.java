package ar.uba.fi.tdd.grupo5.framework;

import ar.uba.fi.tdd.grupo5.framework.exception.AssertException;
import ar.uba.fi.tdd.grupo5.xml.ErrorElement;
import ar.uba.fi.tdd.grupo5.xml.FailureElement;
import ar.uba.fi.tdd.grupo5.xml.SkippedElement;
import ar.uba.fi.tdd.grupo5.xml.TestCaseElement;

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
		initAttributes();
		Timer timer = startTimer();
		try {
			test.testCode();
		} catch (AssertException assertException) {
			setFailTest(assertException);
		} catch (Throwable exception) {
			setErrorTest(exception);
		} finally {
			setTestTime(timer.getRegisteredTime());
		}
	}

	/**
	 * Determines whether the test failed.
	 */
	public boolean isFail() {
		return fail;
	}

	/**
	 * Determines whether the test gave error
	 */
	public boolean isError() {
		return error;
	}

	/**
	 * Determines whether the test was successful or not.
	 */
	public boolean isOK() {
		return !error && !fail;
	}

	/**
	 * Returns the name of the test.
	 */
	public String getTestName() {
		return test.getName();
	}

	/**
	 * Returns the error message of the test, if it's failed.
	 */
	public String getMessage() {
		if (throwable != null) {
			return throwable.getLocalizedMessage();
		}
		return "";
	}

	/**
	 * Returns the time of the test.
	 */
	public long getTestTime() {
		return testTime;
	}

	public TestCaseElement getXmlElement() {
		TestCaseElement testCaseElement = new TestCaseElement(test.getName());
		testCaseElement.setClassNameAttributeValue(test.getClass().getName());
		testCaseElement.setTimeAttributeValue(Long.toString(testTime) + "[nS]");
		if (fail) {
			testCaseElement.addFailureElement(getXmlFailure());
		}
		if (error) {
			testCaseElement.addErrorElement(getXmlError());
		}
		testCaseElement.addSkippedElement(new SkippedElement(test.isSkipped()));
		return testCaseElement;
	}

	private FailureElement getXmlFailure() {
		FailureElement failureElement = new FailureElement();
		failureElement.setTypeAttributeValue(throwable.getClass().getName());
		failureElement
				.setMessageAttributeValue(throwable.getLocalizedMessage());
		return failureElement;
	}

	private ErrorElement getXmlError() {
		ErrorElement errorElement = new ErrorElement();
		errorElement.setTypeAttributeValue(throwable.getClass().getName());
		errorElement.setMessageAttributeValue(throwable.getLocalizedMessage());
		return errorElement;
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
		setFail(true);
		this.throwable = throwable;
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
		setError(true);
		this.throwable = throwable;
	}

	/**
	 * Initial setUp of the private booleans.
	 */
	private void initAttributes() {
		setError(false);
		setFail(false);
		throwable = null;
	}

	private Timer startTimer() {
		Timer timer = new Timer();
		timer.setStart();
		return timer;
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
}
