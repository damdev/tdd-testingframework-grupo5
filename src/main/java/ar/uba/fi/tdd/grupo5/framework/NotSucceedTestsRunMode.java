package ar.uba.fi.tdd.grupo5.framework;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sebastian
 * Date: 18/11/13
 * Time: 17:53
 * To change this template use File | Settings | File Templates.
 */
public class NotSucceedTestsRunMode extends TestRunMode {
    public NotSucceedTestsRunMode(Collection<TestResult> results) {
        ArrayList<TestResult> previousResults = new ArrayList<TestResult>();
        previousResults.addAll(results);
        this.setLastResults(previousResults);
    }

    @Override
    public void setTestsToBeRunned(TestSuite testSuite) {
        List<TestResult> lastResults = getLastResults();
        for(TestResult result : lastResults ) {
            if(result.isOK()) {
               testSuite.removeByName(result.getTestName());
            }
        }
    }

    private boolean testDidntSucceed(Test test) {
        return !getTestResultByName(test.getName()).isOK();
    }

    @Override
    public boolean shouldRunTest(Test test) {
        if(testExists(test) && testDidntSucceed(test)) {
            return true;
        }
    return false;
    }
}
