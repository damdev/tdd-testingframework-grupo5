package ar.uba.fi.tdd.grupo5;

public class TestResult {

	private String testName;
	private boolean error;
	private boolean fail;
	private String message;
	private Time time;

	public TestResult() {
		error = false;
		fail = false;
	}

	void run(TestCase test) {
		testName = test.getName();
		try {
			test.testCode();
		} catch (Error error) {
			setError(true);
			message = error.getLocalizedMessage();
		} catch (AssertionFailedException exception) {
			setFail(true);
			message = exception.getLocalizedMessage();
		}
	}

	@Override
	public String toString() {
		String sResult = testName;
		/**
		 * TODO Hay que agregar el tiempo que se demoro en correr el test.
		 */
		if (isError()) {
			sResult = sResult + "\t ERROR";
		}
		if (isFail()) {
			sResult = sResult + "\t FAIL";
		}	sResult = sResult + "\n" + message + "\n";
		if (isOK()) {
			sResult = sResult + "\t OK";
		}
		if (isAvailableMessage()) {
			sResult = sResult + "\n" + message + "\n";
		}
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
}
