package ar.uba.fi.tdd.grupo5;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AssertExceptionTest.class, AssertTest.class, TimerTest.class,
		ReportTest.class, TestResultTest.class, TestCaseTest.class,
		TestSuiteTest.class, FixtureTest.class, RegexpTest.class,
		TwoLevelTestSuiteTest.class, CriteriaTest.class })
public class AllTests {

}
