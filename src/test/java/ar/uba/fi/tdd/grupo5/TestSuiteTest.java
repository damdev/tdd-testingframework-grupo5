package ar.uba.fi.tdd.grupo5;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.uba.fi.tdd.grupo5.framework.TestSuite;

public class TestSuiteTest {

	private TestSuite tester;
	private final String emptySuite = "The TestSuite is empty. There are no tests to run.";

	@Test
	public void testTestSuite() {
		fail("Not yet implemented");
	}

	@Test
	public void testAdd() {
		fail("Not yet implemented");
	}

	@Test
	public void runAnEmptyTestSuite() {
		tester = new TestSuite("My Test Suite");
		assertEquals(
				"tester.run() returns a different default message than the expected",
				emptySuite, tester.run());
	}

}
