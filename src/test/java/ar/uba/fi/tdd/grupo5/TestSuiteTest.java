package ar.uba.fi.tdd.grupo5;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.uba.fi.tdd.grupo5.framework.TestSuite;

public class TestSuiteTest {

	private TestSuite tester;
	private final String testSuiteName = "My Test Suite";
	private final String emptySuite = testSuiteName
			+ "\n­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­--------------------------\n"
			+ "The TestSuite is empty. There are no tests to run.";

	@Test
	public void runAnEmptyTestSuite() {
		tester = new TestSuite(testSuiteName);
		assertEquals(
				"tester.run() returns a different default message than the expected",
				emptySuite, tester.run());
	}

}
