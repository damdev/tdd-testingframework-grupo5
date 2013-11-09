package ar.uba.fi.tdd.grupo5.framework.tagmanager;

public class Regexp implements Criteria {
	private String pattern;
	
	public Regexp(String desiredPattern) {
		pattern = desiredPattern;
	}

	/**
	 * 
	 * @param tagManager wanted to analyze
	 * @return true if the name of the tagManager matches the pattern
	 */
	@Override
	public boolean match(TagManager tagManager) {
		return tagManager.getName().matches(pattern);
	}

}
