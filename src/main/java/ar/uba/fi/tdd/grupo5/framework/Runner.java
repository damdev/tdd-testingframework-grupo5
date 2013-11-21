package ar.uba.fi.tdd.grupo5.framework;

import java.io.IOException;

import ar.uba.fi.tdd.grupo5.framework.tagmanager.*;
import ar.uba.fi.tdd.grupo5.xml.XmlManager;

public class Runner {

	private TestSuite suite;
	private XmlManager xmlManager;
	private TestRunStore previousRunsManager;
    private TestRunMode previousTestsRunMode;

	
	public Runner(TestSuite suite, String xmlPath) {
		this.suite = suite;
		xmlManager = new XmlManager(xmlPath);
		previousRunsManager = new TextFileRunStore();
		previousRunsManager.setPath("previousRun-" + suite.getName());
		previousTestsRunMode = new NotSucceedTestsRunMode(previousRunsManager.getAllTestResults());
	}

	public Report runAll() {
		Criteria criteria = new AllMatch();
		return runSuite(criteria);
	}

	public Report runWithAnyTags(String tags) {
		Criteria criteria = new AnyTag(tags);
		return runSuite(criteria);
	}

	public Report runWithAllTags(String tags) {
		Criteria criteria = new AllTags(tags);
		return runSuite(criteria);
	}

	public Report runWithRegexp(String regexp) {
		Criteria criteria = new Regexp(regexp);
		return runSuite(criteria);
	}

	public Report runWithAnyTagsAndRegexp(String tags, String regexp) {
		MixedCriteria criteria = new MixedCriteria();
		criteria.add(new AnyTag(tags));
		criteria.add(new Regexp(regexp));
		return runSuite(criteria);
	}

	public Report runWithAllTagsAndRegexp(String tags, String regexp) {
		MixedCriteria criteria = new MixedCriteria();
		criteria.add(new AllTags(tags));
		criteria.add(new Regexp(regexp));
		return runSuite(criteria);
	}

	public void writeXML() {
		try {
			xmlManager.writeXML();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Report runSuite(Criteria criteria) {
		Report runReport = suite.run(criteria);
		xmlManager.addTestSuiteElement(suite.getXmlElement());
		previousRunsManager.addAllTestResults(suite.getAllChildTestResults());
		previousRunsManager.save();
		return runReport;
	}

    private Report runSuiteWithStoreModeOn(Criteria criteria) {
    	if(!previousRunsManager.load()) {
    		return runSuite(criteria);
    	} else {
    		Report runReport = suite.runWithStoreModeOn(criteria, previousTestsRunMode);
    		xmlManager.addTestSuiteElement(suite.getXmlElement());
    		previousRunsManager.addAllTestResults(suite.getAllChildTestResults());
    		return runReport;
    	}
    }

    public Report runAllWithStoreModeOn() {
        Criteria criteria = new AllMatch();
        return runSuiteWithStoreModeOn(criteria);
    }
}
