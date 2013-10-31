package ar.uba.fi.tdd.grupo5.framework;

public class Timer {

	private long startTime;

	/**
	 * Constructs a <code>Timer</code> and sets startTime in zero
	 * 
	 */
	public Timer() {
		startTime = 0;
	}

	/**
	 * Sets startTime with the return value of getSystemTime()
	 * 
	 */
	public void setStart() {
		startTime = getSystemTime();
	}

	/**
	 * Return the startTime value
	 * 
	 * @return a long
	 * 
	 */
	public long getStartTime() {
		return startTime;
	}

	/**
	 * Return the difference between the return value of getSystemTime() and
	 * startTime
	 * 
	 * @return a long
	 * 
	 */
	public long getRegisteredTime() {
		return getSystemTime() - startTime;
	}

	private long getSystemTime() {
		return System.nanoTime();
	}
}
