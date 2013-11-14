package ar.uba.fi.tdd.grupo5.framework;

import ar.uba.fi.tdd.grupo5.framework.exception.AssertException;
import ar.uba.fi.tdd.grupo5.framework.tagmanager.Criteria;
import ar.uba.fi.tdd.grupo5.framework.tagmanager.TagManager;

public abstract class TestCase extends Test {

	private TagManager tagManager;

	/**
	 * Constructs a @ TestCase} specifying a name.
	 * 
	 * @param name
	 *            the name of the @ TestCase}
	 */
	public TestCase(String name) {
		this.setName(name);
		tagManager = new TagManager(name);
		skipped = false;
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
	 * @param fixture
	 *            the fixture of the parent test
	 * @return the result of the {@code TestCase}
	 * 
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

	/**
	 * Verify if the {@TestCase}'s is runnable
	 * 
	 * @param criteria
	 * @return String true if name matches the regex, else return false
	 */
	public final boolean isRunnable(Criteria criteria) {
		return criteria.match(tagManager) && (!skipped);
	}

	/**
	 * The user-client implements the method including the code under test.
	 */
	public abstract void testCode() throws AssertException;


	private void setName(String name) {
		this.name = name;
	}
}
