package ar.uba.fi.tdd.grupo5.framework;

public abstract class Test {

	protected String name;
	protected Fixture fixture;
	protected boolean skipped;
    protected long timeLimit = Long.MAX_VALUE;

    public boolean performanceFailed(long time) {
    	if(timeLimit < time) { 
    		return true; 
    	}
    	return false;
    }
    
    public void setTimeLimit(long limit) {
        timeLimit = limit;
    }

    public long getTimeLimit() {
        return timeLimit;
    }

	/**
	 * Sets up the fixture, for example, open a network connection. This method
	 * is called before a test is executed.
	 */
	protected void setUp() {
	}

	/**
	 * Tears down the fixture, for example, close a network connection. This
	 * method is called after a test is executed.
	 */
	protected void tearDown() {
	}

	/**
	 * Returns the {@code Test}'s name.
	 */
	public final String getName() {
		return name;
	}

	/**
	 * The test that is skipped is not going to be executed.
	 */
	public final void skip() {
		skipped = true;
	}

	/**
	 * Turn the state of the test in not skipped, so its going to be executed.
	 */
	public final void unSkip() {
		skipped = false;
	}

	/**
	 * Return true if skipped test.
	 */
	public final boolean isSkipped() {
		return this.skipped;
	}
}
