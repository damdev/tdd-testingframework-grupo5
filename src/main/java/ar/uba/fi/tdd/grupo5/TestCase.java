package ar.uba.fi.tdd.grupo5;

public abstract class TestCase {

	private String name;
	
	public TestCase(String name) {
		this.setName(name);
	}
	
	public TestCase() {
		setName(getClass().getSimpleName());
	}
	
	public TestResult run() {
		TestResult result = new TestResult();
		result.run(this);
		return result;
	}
	
	/**
	 * The user-client implements the method including the code under test.
	 */
	public abstract void testCode() throws AssertionFailedException;

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}
}
