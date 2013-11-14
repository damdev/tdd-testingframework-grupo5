package ar.uba.fi.tdd.grupo5.framework;

import java.io.IOException;
import ar.uba.fi.tdd.grupo5.framework.tagmanager.*;
import ar.uba.fi.tdd.grupo5.xml.XmlManager;

public class Runner {

	private TestSuite suite;
	private XmlManager xmlManager;

	public Runner(TestSuite suite, String xmlPath) {
		this.suite = suite;
		xmlManager = new XmlManager(xmlPath);
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
		xmlManager.setTestSuiteChild(suite.getXmlElement());
		return runReport;
	}
}
