package ar.uba.fi.tdd.grupo5;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ar.uba.fi.tdd.grupo5.framework.Criteria;

public class CriteriaTest {
	private Criteria criteria;
	private Criteria anotherCriteria;
	
	@Before
	public void setUp() {
		criteria = new Criteria("Test1");
		anotherCriteria = new Criteria("Test Matcher Criteria");
		anotherCriteria.setRegexp(".*");
	}

	@Test
	public void EmptyTagAndRegexp() {
		anotherCriteria.setRegexp(null);
		assertTrue(criteria.matchAnyTagAndRegexp(anotherCriteria));
		assertTrue(criteria.matchAllTagsAndRegexp(anotherCriteria));
	}
	
	@Test
	public void AnyTagAndNoRegexp() {
		anotherCriteria.setRegexp(null);
		criteria.addTag("DB");
		anotherCriteria.addTag("DB:SLOW");
		assertTrue(criteria.matchAnyTagAndRegexp(anotherCriteria));
	}
	
	@Test
	public void AllTagsAndNoRegexp() {
		anotherCriteria.setRegexp(null);
		criteria.addTag("DB:SLOW:P0");
		anotherCriteria.addTag("DB:SLOW");
		assertTrue(criteria.matchAllTagsAndRegexp(anotherCriteria));
	}
	
	@Test
	public void MatchOnlyRegexp() {
		assertTrue(criteria.matchAnyTagAndRegexp(anotherCriteria));
	}
	
	@Test
	public void MatchRegexpWhenIsNotSetted() {
		assertTrue(anotherCriteria.matchRegexp(criteria));
	}
	
	@Test
	public void MatchRegexpWhenPatternMatches() {
		assertTrue(criteria.matchRegexp(anotherCriteria));
	}
	
	@Test
	public void MatchOnlyRegexpNoTags() {
		assertTrue(criteria.matchAllTagsAndRegexp(anotherCriteria));
		
	}
	
	@Test
	public void MatchAnyTag() {
		criteria.addTag("DB");
		anotherCriteria.addTag("DB:SLOW");
		assertTrue(criteria.matchAnyTag(anotherCriteria));
	}
	
	@Test
	public void DontMatchAnyTag() {
		criteria.addTag("FAST");
		anotherCriteria.addTag("DB:SLOW:P0");
		assertFalse(criteria.matchAnyTag(anotherCriteria));
	}

	@Test
	public void DontMatchAnyTagWithEmptySet() {
		anotherCriteria.addTag("DB:SLOW:P0");
		assertFalse(criteria.matchAnyTag(anotherCriteria));
	}
	
	@Test
	public void DontMatchAnyTagWithEmptyTagWanted() {
		criteria.addTag("DB:SLOW:P0");
		assertTrue(criteria.matchAnyTag(anotherCriteria));
	}
	
	@Test
	public void MatchAllTagsExactly() {
		criteria.addTag("DB:SLOW:P0");
		anotherCriteria.addTag("DB:SLOW:P0");
		assertTrue(criteria.matchAllTags(anotherCriteria));
	}
	
	@Test
	public void MatchAllTagsAndMore() {
		criteria.addTag("DB:SLOW:P0:P1");
		anotherCriteria.addTag("DB:SLOW:P0");
		assertTrue(criteria.matchAllTags(anotherCriteria));
	}
	
	@Test
	public void DontMatchAllTags() {
		criteria.addTag("DB:SLOW");
		anotherCriteria.addTag("DB:SLOW:P0");
		assertTrue(! criteria.matchAllTags(anotherCriteria));
	}
	
	@Test
	public void MatchAnyTagAndRegexp() {
		criteria.addTag("DB");
		anotherCriteria.addTag("DB:SLOW");
		assertTrue(criteria.matchAnyTagAndRegexp(anotherCriteria));
	}
	
	@Test
	public void MatchAnyTagAndDontMatchRegexp() {
		criteria.addTag("DB");
		anotherCriteria.addTag("DB:SLOW");
		anotherCriteria.setRegexp("Regexp that does not match");
		assertFalse(criteria.matchAnyTagAndRegexp(anotherCriteria));
	}
	
	@Test
	public void MatchAllTagsAndRegexp() {
		criteria.addTag("DB:SLOW");
		anotherCriteria.addTag("DB:SLOW");
		assertTrue(criteria.matchAnyTagAndRegexp(anotherCriteria));
	}
	
	@Test
	public void MatchAllTagsAndDontMatchRegexp() {
		criteria.addTag("DB:SLOW");
		anotherCriteria.addTag("DB:SLOW");
		anotherCriteria.setRegexp("Regexp that does not match");
		assertFalse(criteria.matchAllTagsAndRegexp(anotherCriteria));
	}

}
