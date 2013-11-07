package ar.uba.fi.tdd.grupo5.framework;

import ar.uba.fi.tdd.grupo5.framework.exception.AssertException;

public abstract class TestCase extends Test {

	/**
	 * Constructs a @ TestCase} specifying a name.
	 * 
	 * @param name
	 *            the name of the @ TestCase}
	 */
	public TestCase(String name) {
		this.setName(name);
	}

	/**
	 * Constructs a @ TestCase} without specifying a name. The name used is the
	 * return value of getSimpleName().
	 */
	public TestCase() {
		setName(getClass().getSimpleName());
	}

	/**
	 * Run the @ TestCase} and return a {@link TestResult}.
	 * 
	 * @return the result of the @ TestCase}
	 * @see TestResult
	 */
	public final TestResult run(Fixture fixture) {
		this.fixture = fixture;
		setUp();
		TestResult result = new TestResult();
		result.run(this);
		tearDown();
		return result;
	}

	public final boolean patternMatches(String pattern) {
		return name.matches(pattern);
	}

	/**
	 * The user-client implements the method including the code under test.
	 */
	public abstract void testCode() throws AssertException;

	private void setName(String name) {
		this.name = name;
	}
}
