package ar.uba.fi.tdd.grupo5.framework;

import ar.uba.fi.tdd.grupo5.framework.exception.AssertException;

public abstract class TestCase extends Test {

	/**
	 * Constructs a <code>TestCase</code> specifying a name.
	 * 
	 * @param name   
	 * 			the name of the <code>TestCase</code>
	 */
	public TestCase(String name) {
		this.setName(name);
		
	}
	
	/**
	 * Constructs a <code>TestCase</code> without specifying a name.
	 * The name used is the return value of getSimpleName()
	 */
	public TestCase() {
		setName(getClass().getSimpleName());
	}
	
	/**
	 * Run the <code>TestCase</code> and return a 
	 * {@link TestResult}
	 * 
	 * @return the result of the <code>TestCase</code>
	 * @throws Exception 
	 * @see TestResult
	 */
	public TestResult run(Fixture fixture) {
		this.fixture = fixture;
		setUp(fixture);
		TestResult result = new TestResult();
		result.run(this);
		tearDown(fixture);
		return result;
	}
	
	public boolean patternMatches(String pattern){
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
