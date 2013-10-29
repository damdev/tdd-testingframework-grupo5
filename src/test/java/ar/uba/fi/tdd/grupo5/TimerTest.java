package ar.uba.fi.tdd.grupo5;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import ar.uba.fi.tdd.grupo5.framework.Timer;

public class TimerTest {

	private Timer tester;

	@Before
	public void initObjects() {
		tester = new Timer();
	}

	@Test
	public void initialTimeValueEqualZero() {
		assertNotNull("new Timer() returns null pointer", tester);
		assertEquals("startTime doesnAssert't initialize in zero", 0,
				tester.getStartTime());
	}

	@Test
	public void timeValueAfterStartTimerNotEqualZero() {
		tester.setStart();
		assertTrue("setStart() doesn't modify the startTime value",
				tester.getStartTime() != 0);
	}

	@Test
	public void registeredTimeValueAfterStartTimerNotEqualZero() {
		tester.setStart();
		long time = tester.getRegisteredTime();
		assertTrue("getRegisteredTime() returns zero", time != 0);
	}

	@Test
	public void registeredTimeValueAfterStartTimerNotEqualStartTime() {
		tester.setStart();
		long time = tester.getRegisteredTime();
		assertTrue(
				"The getRegisteredTime() return value is equal to startTime",
				time != tester.getStartTime());
	}
}
