package ar.uba.fi.tdd.grupo5;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.uba.fi.tdd.grupo5.framework.Assert;
import ar.uba.fi.tdd.grupo5.framework.Runner;
import ar.uba.fi.tdd.grupo5.framework.TestCase;
import ar.uba.fi.tdd.grupo5.framework.TestSuite;
import ar.uba.fi.tdd.grupo5.framework.exception.AssertException;
import ar.uba.fi.tdd.grupo5.framework.exception.TestException;

public class TestSuiteTest {

	private final String testSuiteName = "My Test Suite";

	@Test(expected = TestException.class)
	public void addTwoTestCaseWithSameName() throws TestException {
		TestSuite suite = new TestSuite(testSuiteName);
		String testName = "SameName";
		TestCase test1 = new MyComplexTest(testName);
		TestCase test2 = new MyComplexTest(testName);
		suite.add(test1);
		suite.add(test2);
		
	}

	@Test
	public void twoTestCaseCount() throws TestException {
		TestSuite suite = new TestSuite(testSuiteName);
		TestCase test1 = new MyComplexTest("test1");
		TestCase test2 = new MyComplexTest("test2");
		suite.add(test1);
		suite.add(test2);
		assertEquals(2, suite.countTestCases());
	}

	@Test
	public void twoTestCaseCountPattern() throws TestException {
		TestSuite suite = new TestSuite(testSuiteName);
		TestCase test1 = new MyComplexTest("hola");
		TestCase test2 = new MyComplexTest("chau");
		suite.add(test1);
		suite.add(test2);

		assertEquals(2, suite.countTestCases());
	}

	@Test
	public void oneSuccessAndOneFailTestCaseCount() throws TestException {
		TestSuite suite = new TestSuite(testSuiteName);
		TestCase test1 = new MySimpleTest("test1");
		TestCase test2 = new MyFailTest("test2");
		suite.add(test1);
		suite.add(test2);
		suite.run();
		assertEquals(2, suite.countTestCases());
		assertEquals(1, suite.countFailTestCases());
	}

	@Test
	public void oneSuccessAndOneFailTestCaseCountWithComplexTest()
			throws TestException {
		TestSuite suite = new MySuite();
		TestCase test1 = new MyComplexTest("test1");
		TestCase test2 = new MyFailTest("test2");
		suite.add(test1);
		suite.add(test2);
		suite.run();
		assertEquals(2, suite.countTestCases());
		assertEquals(1, suite.countFailTestCases());
		assertEquals(0, suite.countErrorTestCases());
	}

	@Test
	public void oneSuccessAndOneErrorTestCaseCount() throws TestException {
		TestSuite suite = new TestSuite("mySuite2");
		TestCase test1 = new MySimpleTest("test1");
		TestCase test2 = new MyErrorTest("test2");
		suite.add(test1);
		suite.add(test2);
		suite.run();
		assertEquals(2, suite.countTestCases());
		assertEquals(0, suite.countFailTestCases());
		assertEquals(1, suite.countErrorTestCases());

			
		Runner runner = new Runner(suite,"xmlReport");
		runner.runAllWithStoreModeOn();	
	}

	@Test
	public void successFixtureChanges() throws TestException {
		TestSuite suite = new MySuite();
		MyComplexTest test1 = new MyComplexTest("test1");
		suite.add(test1);
		suite.run();
	}

	private class MySuite extends TestSuite {
		public MySuite() {
			super("MySuite");
		}

		@Override
		public void setUp() {
			fixture.add("myNumber", 3);
			fixture.add("myString", "Hello World!");
		}
	}

	private class MySimpleTest extends TestCase {
		public MySimpleTest(String name) {
			this.name = name;
		}

		@Override
		public void testCode() throws AssertException {
		}
	}

	private class MyComplexTest extends TestCase {

		public MyComplexTest(String name) {
			this.name = name;
		}

		@Override
		public void testCode() throws AssertException {
			int number = (int) fixture.get("myNumber");
			number++;
			fixture.add("myNumber", number);
			String string = (String) fixture.get("myString");
			string = string.substring(0, 5);
			fixture.add("myString", string);
			int number1 = (int) fixture.get("myNumber2");
			number1 += 2;
			fixture.add("myNumber2", number1);
			String string1 = (String) fixture.get("myString2");
			string1 = string1.substring(0, 8);
			fixture.add("myString2", string1);
		}

		@Override
		public void setUp() {
			fixture.add("myNumber2", 4);
			fixture.add("myString2", "Good bye cruel world");
		}

		@Override
		public void tearDown() {
			int number = (int) fixture.get("myNumber");
			assertEquals(4, number);
			String string = (String) fixture.get("myString");
			assertEquals("Hello", string);
			int number1 = (int) fixture.get("myNumber2");
			assertEquals(6, number1);
			String string1 = (String) fixture.get("myString2");
			assertEquals("Good bye", string1);
		}
	}

	private class MyFailTest extends TestCase {

		public MyFailTest(String name) {
			this.name = name;
		}

		@Override
		public void testCode() throws AssertException {
			Assert.assertTrue(false);
		}
	}
	
	private class MyErrorTest extends TestCase {

		public MyErrorTest(String name) {
			this.name = name;
		}

		@Override
		public void testCode() throws AssertException {
			int number = 1;
			number = number / 0;
			Assert.assertTrue(false);
		}
	}
}
