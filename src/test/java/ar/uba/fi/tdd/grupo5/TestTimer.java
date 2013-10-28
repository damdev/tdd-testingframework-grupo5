package ar.uba.fi.tdd.grupo5;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ar.uba.fi.tdd.grupo5.framework.Timer;

public class TestTimer {
	
	private Timer tester;
	
	@Before
	public void initObjects(){
		tester = new Timer();
	}
	
	@Test
	public void testTimer() {
		assertTrue("new Timer() returns null pointer", tester != null);
		assertTrue("startTime doesn't initialize in zero", tester.getStartTime() == 0);
	}

	@Test
	public void testSetStart() {
		tester.setStart();
		assertTrue("setStart() doesn't modify the startTime value", tester.getStartTime() != 0);
	}

	@Test
	public void testGetRegisteredTime() {
		tester.setStart();
		long time = tester.getRegisteredTime();
		assertTrue("getRegisteredTime() returns zero", time != 0);
		assertTrue("The getRegisteredTime() return value is equal to startTime", time != tester.getStartTime());
	}

}
