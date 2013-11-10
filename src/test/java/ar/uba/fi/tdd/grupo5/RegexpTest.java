package ar.uba.fi.tdd.grupo5;

import static org.junit.Assert.*;

import org.junit.Test;
import ar.uba.fi.tdd.grupo5.framework.TestCase;
import ar.uba.fi.tdd.grupo5.framework.TestSuite;
import ar.uba.fi.tdd.grupo5.framework.exception.AssertException;
import ar.uba.fi.tdd.grupo5.framework.exception.TestException;
import ar.uba.fi.tdd.grupo5.framework.tagmanager.Regexp;

public class RegexpTest {

	@Test
	public void patternMatch() throws TestException {
		TestSuite suite = new TestSuite("Suite");
		MyTest specialTest = new MyTest("Special Test");
		MyTest anotherSpecialTest = new MyTest("Another Special Test");
		MyTest commonTest = new MyTest("Common Test");
		suite.add(specialTest);
		suite.add(anotherSpecialTest);
		Regexp special = new Regexp(".*Special.*");
		assertEquals(2, suite.countTestCases(special));

		suite.add(commonTest);
		assertEquals(2, suite.countTestCases(special));
	}

	@Test
	public void patternPartiallyMatch() throws TestException {
		TestSuite suite = new TestSuite("Suite");
		MyTest specialTest = new MyTest("Special Test");
		MyTest anotherSpecialTest = new MyTest("Another Special Test");
		MyTest commonTest = new MyTest("Common Test");
		suite.add(specialTest);
		suite.add(anotherSpecialTest);
		suite.add(commonTest);
		Regexp test = new Regexp(".*Test$");
		Regexp common = new Regexp("^Common.*");
		assertEquals(3, suite.countTestCases(test));
		assertEquals(1, suite.countTestCases(common));
		assertEquals(3, suite.countTestCases());
	}

	@Test
	public void patternNotMatch() throws TestException {
		TestSuite suite = new TestSuite("Suite");
		MyTest specialTest = new MyTest("Special Test");
		MyTest anotherSpecialTest = new MyTest("Another Special Test");
		MyTest commonTest = new MyTest("Common Test");
		suite.add(specialTest);
		suite.add(anotherSpecialTest);
		suite.add(commonTest);
		Regexp something = new Regexp(".*Something.*");
		assertEquals(0, suite.countTestCases(something));
	}

	@Test
	public void noTestsWithPatternMatch() throws TestException {
		TestSuite suite = new TestSuite("Suite");
		MyTest specialTest = new MyTest("Special Test");
		MyTest anotherSpecialTest = new MyTest("Another Special Test");
		MyTest commonTest = new MyTest("Common Test");
		suite.add(specialTest);
		suite.add(anotherSpecialTest);
		suite.add(commonTest);
		assertEquals(0, suite.countErrorTestCases());
	}

	private class MyTest extends TestCase {

		public MyTest(String name) {
			super(name);
		}

		@Override
		public void testCode() throws AssertException {
		}
	}

}
