package ar.uba.fi.tdd.grupo5;

public class TestResult {

	private String testName;
	private boolean error;
	private boolean fail;
	private String message;
	private long time;

	void run(TestCase test) {
		testName = test.getName();
		error = false;
		fail = false;
		Timer timer = new Timer();
		timer.setStart();
		try {
			test.testCode();
		} catch (Error error) {
			setError(true);
			message = error.getLocalizedMessage();
		} catch (AssertionFailedException exception) {
			setFail(true);
			message = exception.getLocalizedMessage();
		} finally {
			time = timer.getRegisteredTime();
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

	private boolean isOK() {
		return !error && !fail;
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
