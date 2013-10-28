package ar.uba.fi.tdd.grupo5;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.uba.fi.tdd.grupo5.framework.Assert;
import ar.uba.fi.tdd.grupo5.framework.AssertionFailedException;
import ar.uba.fi.tdd.grupo5.framework.TestCase;
import ar.uba.fi.tdd.grupo5.framework.TestResult;

public class TestResultTest {
	
	private TestResult testerResult;
	private TestCase testerCase;
	private String defaultMessage = "Message was not provided";
	
	@Test
	public void testRun() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsError() {
		testerCase = new myErrorTest("I'm a error test");
		testerResult = testerCase.run();
		assertTrue("testerResult.isError() return false in a error test", testerResult.isError() );
	}

	@Test
	public void testIsFail() {
		testerCase = new myFailTest("I'm a fail test");
		testerResult = testerCase.run();
		assertTrue("testerResult.isFail() return false in a fail test", testerResult.isFail() );
	}

	@Test
	public void testIsOK() {
		testerCase = new myOKTest("I'm a OK test");
		testerResult = testerCase.run();
		assertTrue("testerResult.isOK() return false in a OK test", testerResult.isOK() );
	}

	@Test
	public void testGetMessage() {
		testerCase = new myFailTest("I'm a fail test");
		testerResult = testerCase.run();
		assertEquals("testerResult.getMessage() return a different message than the default message", testerResult.getMessage(), defaultMessage);
	}

	@Test
	public void testGetTime() {
		long timeInNanoSec = 500000000;
		long deltaTime = 1000000;
		testerCase = new mySleepTest("0.5 sec sleep");
		testerResult = testerCase.run();
		assertEquals("testerResult.getTime() return a different value than the expected (Considering delta)", testerResult.getTime(), timeInNanoSec, deltaTime );
	}
	
}

final class mySleepTest extends TestCase {
	
	public mySleepTest(String name) {
		super(name);
	}
	
	public mySleepTest() {
		super();
	}
	
	public void testCode() throws AssertionFailedException{
		Assert.assertTrue(true);
		try {
			Thread.sleep(500);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		Assert.assertTrue(true);
	}
}

final class myOKTest extends TestCase {
	
	public myOKTest(String name) {
		super(name);
	}
	
	public myOKTest() {
		super();
	}
	
	public void testCode() throws AssertionFailedException{
		Assert.assertTrue(true);
	}
}

final class myFailTest extends TestCase {
	
	public myFailTest(String name) {
		super(name);
	}
	
	public myFailTest() {
		super();
	}
	
	public void testCode() throws AssertionFailedException{
		Assert.assertTrue(false);
	}
}

final class myErrorTest extends TestCase {
	
	public myErrorTest(String name) {
		super(name);
	}
	
	public myErrorTest() {
		super();
	}
	
	public void testCode() throws AssertionFailedException{
		Calculator c = new Calculator();
		Assert.assertTrue( c.divide(1, 0) == 1);
	}
}