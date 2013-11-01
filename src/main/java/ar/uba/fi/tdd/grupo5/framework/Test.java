package ar.uba.fi.tdd.grupo5.framework;

public abstract class Test {

	protected String name;

	/**
	 * Sets up the fixture, for example, open a network connection. This method
	 * is called before a test is executed.
	 */
	protected void setUp() throws Exception {
	}

	/**
	 * Tears down the fixture, for example, close a network connection. This
	 * method is called after a test is executed.
	 */
	protected void tearDown() throws Exception {
	}

	/**
	 * Returns the {@code Test}'s name.
	 */
	public String getName() {
		return name;
	}
}
