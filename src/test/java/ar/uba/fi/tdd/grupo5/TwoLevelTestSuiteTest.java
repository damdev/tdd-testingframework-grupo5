package ar.uba.fi.tdd.grupo5;

import static org.junit.Assert.*;
import org.junit.Test;
import ar.uba.fi.tdd.grupo5.framework.TestCase;
import ar.uba.fi.tdd.grupo5.framework.TestSuite;
import ar.uba.fi.tdd.grupo5.framework.exception.AssertException;
import ar.uba.fi.tdd.grupo5.framework.exception.TestException;

public class TwoLevelTestSuiteTest {

	private String firstLevelTestSuiteName = "MyTestSuite1";
	private String secondLevelTestSuiteName = "MyTestSuite2";

	@Test
	public void successSecondLevelTestSuiteName() throws TestException {
		TestSuite firstLevelTestSuite = new TestSuite(firstLevelTestSuiteName);
		TestSuite secondLevelTestSuite = new TestSuite(secondLevelTestSuiteName);
		firstLevelTestSuite.add(secondLevelTestSuite);
		String secondLevelTSName = "MyTestSuite1.MyTestSuite2";
		assertEquals(secondLevelTSName, secondLevelTestSuite.getName());
	}

	@Test(expected = TestException.class)
	public void addSecondLevelTestSuiteSameName() throws TestException {
		TestSuite firstLevelTestSuite = new TestSuite(firstLevelTestSuiteName);
		TestSuite secondLevelTestSuite1 = new TestSuite(secondLevelTestSuiteName);
		TestSuite secondLevelTestSuite2 = new TestSuite(secondLevelTestSuiteName);
		firstLevelTestSuite.add(secondLevelTestSuite1);
		firstLevelTestSuite.add(secondLevelTestSuite2);
	}
	
	@Test
	public void countFourTestCases() throws TestException {
		TestSuite suite1 = new TestSuite(firstLevelTestSuiteName);
		TestSuite suite2 = new TestSuite(secondLevelTestSuiteName);
		MyTest secondSuiteTest1 = new MyTest("firstTestOfSuite2");
		MyTest secondSuiteTest2 = new MyTest("secondTestOfSuite2");
		suite2.add(secondSuiteTest1);
		suite2.add(secondSuiteTest2);
		suite1.add(suite2);
		MyTest firstSuiteTest1 = new MyTest("firstTestOfSuite1");
		MyTest firstSuiteTest2 = new MyTest("secondTestOfSuite1");
		suite1.add(firstSuiteTest1);
		suite1.add(firstSuiteTest2);
		assertEquals(4, suite1.countTestCases());
	}
	
	@Test
	public void countSixTestCases() throws TestException {
		TestSuite suite1 = new TestSuite("suite1");
		TestSuite suite2 = new TestSuite("suite2");
		TestSuite suite3 = new TestSuite("suite3");
		MyTest thirdSuiteTest1 = new MyTest("firstTestOfSuite3");
		MyTest thirdSuiteTest2 = new MyTest("secondTestOfSuite3");
		suite3.add(thirdSuiteTest1);
		suite3.add(thirdSuiteTest2);
		suite1.add(suite3);
		MyTest secondSuiteTest1 = new MyTest("firstTestOfSuite2");
		MyTest secondSuiteTest2 = new MyTest("secondTestOfSuite2");
		suite2.add(secondSuiteTest1);
		suite2.add(secondSuiteTest2);
		suite1.add(suite2);
		MyTest firstSuiteTest1 = new MyTest("firstTestOfSuite1");
		MyTest firstSuiteTest2 = new MyTest("secondTestOfSuite1");
		suite1.add(firstSuiteTest1);
		suite1.add(firstSuiteTest2);
		assertEquals(6, suite1.countTestCases());
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
