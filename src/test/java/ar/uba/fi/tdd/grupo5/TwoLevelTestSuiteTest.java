package ar.uba.fi.tdd.grupo5;

import static org.junit.Assert.*;
import org.junit.Test;
import ar.uba.fi.tdd.grupo5.framework.TestSuite;

public class TwoLevelTestSuiteTest {

	private String firstLevelTestSuiteName = "MyTestSuite1";
	private String secondLevelTestSuiteName = "MyTestSuite2";
	
	@Test
	public void SecondLevelTestSuiteName() {
		TestSuite firstLevelTestSuite = new TestSuite(firstLevelTestSuiteName);
		TestSuite secondLevelTestSuite = new TestSuite(secondLevelTestSuiteName);
		firstLevelTestSuite.add(secondLevelTestSuite);
		String secondLevelTSName = "MyTestSuite1.MyTestSuite2";
		assertEquals(secondLevelTSName, secondLevelTestSuite.getName());
	}

}
