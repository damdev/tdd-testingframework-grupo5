package ar.uba.fi.tdd.grupo5;

public abstract class TestCase extends Test {

	@Override
	void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	TestResult getResult() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * The user-client implements the method including the code under test.
	 */
	public abstract void testCode();
}
