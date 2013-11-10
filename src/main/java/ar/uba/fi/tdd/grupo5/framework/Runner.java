package ar.uba.fi.tdd.grupo5.framework;

import ar.uba.fi.tdd.grupo5.framework.tagmanager.*;

public class Runner {

	private TestSuite suite;
	
	public Runner(TestSuite suite) {
		this.suite = suite;
	}
	
	public Report runWithAnyTags(String tags) {
		Criteria criteria = new AnyTag(tags);
		return suite.run(criteria);
	}
	
	public Report runWithAllTags(String tags) {
		Criteria criteria = new AllTags(tags);
		return suite.run(criteria);
	}
	
	public Report runWithAllTagsAndRegexp(String tags, String regexp) {
		MixedCriteria criteria = new MixedCriteria();
		criteria.add(new AllTags(tags));
		criteria.add(new Regexp(regexp));
		return suite.run(criteria);
	}
	
	public Report runWithAnyTagsAndRegexp(String tags, String regexp) {
		MixedCriteria criteria = new MixedCriteria();
		criteria.add(new AnyTag(tags));
		criteria.add(new Regexp(regexp));
		return suite.run(criteria);
	}
}
