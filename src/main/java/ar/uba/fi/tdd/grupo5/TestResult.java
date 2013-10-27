package ar.uba.fi.tdd.grupo5;

public class TestResult {

	private String testName;
	private boolean error;
	private boolean fail;
	private String message;
	private long time;

	void run(TestCase test) {
		setTestName(test.getName());
		setUp();
		Timer timer = new Timer();
		timer.setStart();
		try {
			test.testCode();
		} catch (AssertionFailedException assertionException) {
			setFail(true);
			this.setMessage(assertionException.getLocalizedMessage());
		} catch (Exception exception) {
			setError(true);
			setMessage(exception.getLocalizedMessage());
		} finally {
			setTime(timer.getRegisteredTime());
		}
	}

	@Override
	public String toString() {
		String sResult = testName;
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
		if (isAvailableMessage()) {
			sResult = addAvailableMessage(sResult);
		}
		sResult = addEndLine(sResult);
		return sResult;
	}

	public String getTestName() {
		return testName;
	}

	private void setTestName(String testName) {
		this.testName = testName;
	}

	public boolean isError() {
		return error;
	}

	private void setError(boolean error) {
		this.error = error;
	}

	public boolean isFail() {
		return fail;
	}

	private void setFail(boolean fail) {
		this.fail = fail;
	}

	public boolean isOK() {
		return !error && !fail;
	}

	public String getMessage() {
		return message;
	}

	private void setMessage(String message) {
		this.message = message;
	}

	public long getTime() {
		return time;
	}

	private void setTime(long time) {
		this.time = time;
	}

	private void setUp() {
		setError(false);
		setFail(false);
		setMessage("");
	}

	private boolean isAvailableMessage() {
		return !message.isEmpty();
	}

	private String addTime(String result) {
		return result + "[" + time + "ms]:";
	}

	private String addStatusResult(String result, String status) {
		return result + "\t" + status;
	}

	private String addAvailableMessage(String result) {
		return result + "\n" + message;
	}

	private String addEndLine(String result) {
		return result + "\n";
	}
}
