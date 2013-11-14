package ar.uba.fi.tdd.grupo5.framework;

import java.util.Iterator;
import java.util.List;
import ar.uba.fi.tdd.grupo5.framework.tagmanager.*;

public class Runner {

	private TestSuite suite;

	public Runner(TestSuite suite) {
		this.suite = suite;
	}

	public Report runAll() {
		Criteria criteria = new AllMatch();
		return suite.run(criteria);
	}
	
	public Report runWithAnyTags(String tags) {
		AnyTag criteria = new AnyTag(tags);
		return suite.run(criteria);
	}

	public Report runWithAllTags(String tags) {
		AllTags criteria = new AllTags(tags);
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

	public Report runWithAnyTagsAndRegexp(String tags, List<String> regexpList) {
		MixedCriteria criteria = new MixedCriteria();
		criteria.add(new AnyTag(tags));
		Iterator<String> it = regexpList.iterator();
		while (it.hasNext()) {
			String regexp = it.next();
			criteria.add(new Regexp(regexp));
		}
		return suite.run(criteria);
	}
}
