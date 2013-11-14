package ar.uba.fi.tdd.grupo5;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ar.uba.fi.tdd.grupo5.framework.tagmanager.*;

public class CriteriaTest {
	private TagManager criteria;
	private TagManager criteriaNameNotContainTest;
	
	private Regexp regexpMatchTest;
	private Regexp regexpMatchAll;
	private Regexp regexpNotMatch;
	
	private AllTags allTags;
	private AnyTag anyTag;
	private MixedCriteria  mixedCriteria;
	
	@Before
	public void setUp() {
		criteria = new TagManager("Test1");
		criteriaNameNotContainTest = new TagManager("Rare Name");
		regexpMatchTest = new Regexp("^Test.*");
		regexpMatchAll = new Regexp(".*");
		regexpNotMatch = new Regexp("This regexp doesnt match");
		
		allTags = new AllTags("All Tags Criteria");
		anyTag = new AnyTag ("Any Tag Criteria");
		mixedCriteria = new MixedCriteria();
	}

	@Test
	public void EmptyTag() {
		assertTrue(allTags.match(criteria));
		assertTrue(anyTag.match(criteria));
	}
	
	@Test
	public void AnyTag() {
		criteria.add("DB");
		anyTag.add("DB:SLOW");
		assertTrue(anyTag.match(criteria));
	}
	
	@Test
	public void AnyTagNotContained() {
		criteria.add("FAST:NOTDB");
		anyTag.add("DB:SLOW");
		assertFalse(anyTag.match(criteria));
	}
	
	@Test
	public void DontMatchAnyTagWithEmptySet() {
		anyTag.add("DB:SLOW:P0");
		assertFalse(anyTag.match(criteria));
	}
	
	@Test
	public void MatchAnyTagWithEmptyAnyTag() {
		criteria.add("DB:SLOW:P0");
		assertTrue(anyTag.match(criteria));
	}
	
	@Test
	public void AllTagsContained() {
		criteria.add("DB:SLOW:P0");
		allTags.add("DB:SLOW");
		assertTrue(allTags.match(criteria));
	}
	
	@Test
	public void AllTagsNotContained() {
		criteria.add("DB:SLOW");
		allTags.add("DB:SLOW:P0");
		assertFalse(allTags.match(criteria));
	}
	
	@Test
	public void MatchAllTagsExactly() {
		criteria.add("DB:SLOW:P0");
		allTags.add("DB:SLOW:P0");
		assertTrue(allTags.match(criteria));
	}
	
	@Test
	public void MatchAllTagsAndMore() {
		criteria.add("DB:SLOW:P0:P1");
		allTags.add("DB:SLOW:P0");
		assertTrue(allTags.match(criteria));
	}
	
	@Test
	public void DontMatchAllTagsWithEmptySet() {
		allTags.add("DB:SLOW:P0");
		assertFalse(allTags.match(criteria));
	}
	
	@Test
	public void MatchRegexp() {
		assertTrue(regexpMatchTest.match(criteria));
		assertTrue(regexpMatchAll.match(criteria));
		assertFalse(regexpNotMatch.match(criteria));
	}
	
	@Test
	public void NoMatchRegexp() {
		assertFalse(regexpMatchTest.match(criteriaNameNotContainTest));
		assertTrue(regexpMatchAll.match(criteriaNameNotContainTest));
		assertFalse(regexpNotMatch.match(criteriaNameNotContainTest));
	}
	
	@Test
	public void MatchOneRegexpAndOneNot() {
		mixedCriteria.add(regexpNotMatch);
		mixedCriteria.add(regexpMatchAll);
		assertFalse(mixedCriteria.match(criteria));
	}
	
	@Test
	public void MatchAnyTagAndRegexp() {
		anyTag.add("DB");
		mixedCriteria.add(anyTag);
		mixedCriteria.add(regexpMatchTest);
		criteria.add("DB:SLOW");
		assertTrue(mixedCriteria.match(criteria));
	}
	
	@Test
	public void MatchAnyTagAndDontMatchRegexp() {
		anyTag.add("DB");
		mixedCriteria.add(anyTag);
		mixedCriteria.add(regexpNotMatch);
		criteria.add("DB:SLOW");
		assertFalse(mixedCriteria.match(criteria));
	}
	
	@Test
	public void MatchAnyTagAndTwoRegexp() {
		anyTag.add("DB");
		criteria.add("DB:SLOW");
		mixedCriteria.add(anyTag);
		mixedCriteria.add(regexpMatchTest);
		mixedCriteria.add(regexpMatchAll);
		assertTrue(mixedCriteria.match(criteria));
	}
	

	public void MatchAllTagsAndRegexp() {
		allTags.add("DB:SLOW");
		mixedCriteria.add(anyTag);
		mixedCriteria.add(regexpMatchTest);
		criteria.add("DB:SLOW:P0");
		assertTrue(mixedCriteria.match(criteria));
	}
	
	@Test
	public void MatchAllTagsAndDontMatchRegexp() {
		allTags.add("DB:SLOW");
		mixedCriteria.add(anyTag);
		mixedCriteria.add(regexpNotMatch);
		criteria.add("DB:SLOW:P0");
		assertFalse(mixedCriteria.match(criteria));
	}

}
