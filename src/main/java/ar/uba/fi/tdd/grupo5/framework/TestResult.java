package ar.uba.fi.tdd.grupo5.framework;

public class TestResult {

	private String testName;
	private boolean error;
	private boolean fail;
	private String message;
	private long testTime;
	
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

	@Override
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

	private String getTestName() {
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

	public long getTestTime() {
		return testTime;
	}

	private void setTestTime(long time) {
		this.testTime = time;
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
