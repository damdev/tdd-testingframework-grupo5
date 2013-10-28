package ar.uba.fi.tdd.grupo5;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.uba.fi.tdd.grupo5.framework.TestCase;
import ar.uba.fi.tdd.grupo5.test.AddTest;

public class TestCaseTest {
	
	private TestCase tester;
	private final String testName = "I'm a testAdd test";
	private final String className = "TestAdd";
	
	@Test
	public void testTestCaseString() {
		tester = new AddTest(testName);
		assertEquals("tester.getName() returns a different test name than the constructor name parameter", tester.getName(), testName);
	}

	@Test
	public void testTestCase() {
		tester = new AddTest();
		assertEquals("tester.getName() returns a different test name than the constructor default", tester.getName(), className);
	}

	@Test
	public void testRun() {
		fail("Not yet implemented");
	}
}
