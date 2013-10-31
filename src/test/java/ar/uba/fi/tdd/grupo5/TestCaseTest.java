package ar.uba.fi.tdd.grupo5;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.uba.fi.tdd.grupo5.framework.TestCase;
import ar.uba.fi.tdd.grupo5.test.AddTest;

public class TestCaseTest {

	private TestCase tester;
	private final String testName = "I'm a AddTest test";
	private final String className = "AddTest";

	@Test
	public void personalizedTestCaseName() {
		tester = new AddTest(testName);
		assertEquals(
				"tester.getName() returns a different test name than the constructor name parameter",
				tester.getName(), testName);
	}

	@Test
	public void defaultTestCaseName() {
		tester = new AddTest();
		assertEquals(
				"tester.getName() returns a different test name than the constructor default",
				tester.getName(), className);
	}
}
