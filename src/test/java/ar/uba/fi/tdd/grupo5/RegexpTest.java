package ar.uba.fi.tdd.grupo5;

import static org.junit.Assert.*;

import org.junit.Test;
import ar.uba.fi.tdd.grupo5.framework.TestCase;
import ar.uba.fi.tdd.grupo5.framework.TestSuite;
import ar.uba.fi.tdd.grupo5.framework.exception.AssertException;
import ar.uba.fi.tdd.grupo5.framework.exception.TestException;

public class RegexpTest {

	@Test
	public void patternMatch() throws TestException {
		TestSuite suite = new TestSuite("Suite");
		MyTest specialTest = new MyTest("Special Test");
		MyTest anotherSpecialTest = new MyTest("Another Special Test");
		MyTest commonTest = new MyTest("Common Test");
		suite.add(specialTest);
		suite.add(anotherSpecialTest);
		
		assertEquals(2, suite.countTestCases(".*Special.*"));
		
		suite.add(commonTest);
		assertEquals(2, suite.countTestCases(".*Special.*"));
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
		assertEquals(1, suite.countTestCases("^Common.*"));
		assertEquals(3, suite.countTestCases(".*Test$"));
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
		assertEquals(0, suite.countTestCases(".*Something.*"));
	}
	
	private class MyTest extends TestCase {

		public MyTest(String name) {
			this.name = name;
		}

		@Override
		public void testCode() throws AssertException {
		}
	}

}
