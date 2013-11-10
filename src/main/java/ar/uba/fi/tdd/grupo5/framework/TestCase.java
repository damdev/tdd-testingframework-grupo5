package ar.uba.fi.tdd.grupo5.framework;

import ar.uba.fi.tdd.grupo5.framework.exception.AssertException;
import ar.uba.fi.tdd.grupo5.framework.tagmanager.TagManager;

public abstract class TestCase extends Test {

	private TagManager tagManager;
	private boolean skipped;
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
	 * 			the fixture of the parent test
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
	 * Verify if the {@TestCase}'s name matches the given regex
	 * 
	 * @param pattern
	 * 			tells whether or not {@code TestCase} matches the given regex.
	 * @return String
	 * 			true if name matches the regex, else return false
	 */			
	public final boolean patternMatches(String pattern) {
		return name.matches(pattern);
	}

	/**
	 * The user-client implements the method including the code under test.
	 */
	public abstract void testCode() throws AssertException;

	/**
	 * The test that is skipped is not going to be executed
	 */
	public void skip(){
		skipped = true;
	}
	
	/**
	 * Turn the state of the test in not skipped, so its going to be executed
	 */
	public void unSkip(){
		skipped = false;
	}
	
	private void setName(String name) {
		this.name = name;
	}

	public TagManager getTagManager() {
		return tagManager;
	}
	
	/**
	 * A TestCase is runnable if it must not be skipped
	 * @return 
	 */
	public boolean isRunnable(){
		return (!skipped);
	}
}
