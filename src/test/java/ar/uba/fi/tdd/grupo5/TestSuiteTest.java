package ar.uba.fi.tdd.grupo5;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.uba.fi.tdd.grupo5.framework.TestCase;
import ar.uba.fi.tdd.grupo5.framework.TestSuite;
import ar.uba.fi.tdd.grupo5.framework.exception.AssertException;
import ar.uba.fi.tdd.grupo5.framework.exception.TestException;

public class TestSuiteTest {

	private final String testSuiteName = "My Test Suite";
	private final String emptySuite = testSuiteName
			+ "\n­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­--------------------------\n"
			+ "The TestSuite is empty. There are no tests to run.";

	@Test
	public void runAnEmptyTestSuite() {
		TestSuite suite = new TestSuite(testSuiteName);
		assertEquals(
				"tester.run() returns a different default message than the expected",
				emptySuite, suite.run().writeOnString());
	}

	@Test(expected=TestException.class)
	public void addTwoTestCaseWithSameName() throws TestException {
		TestSuite suite = new TestSuite(testSuiteName);
		String testName = "SameName";
		MyTest test1 = new MyTest(testName);
		MyTest test2 = new MyTest(testName);
		suite.add(test1);
		suite.add(test2);
	}
	
	@Test
	public void twoTestCaseCount() throws TestException {
		TestSuite suite = new TestSuite(testSuiteName);
		MyTest test1 = new MyTest("test1");
		MyTest test2 = new MyTest("test2");
		suite.add(test1);
		suite.add(test2);
		assertEquals(2, suite.countTestCases());
	}

	private class MyTest extends TestCase {

		public MyTest(String name) {
			this.name = name;
		}

		@Override
		public void testCode() throws AssertException {
			// Auto-generated method stub
		}
	}
}
