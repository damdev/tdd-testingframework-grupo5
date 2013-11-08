package ar.uba.fi.tdd.grupo5.framework;

import java.util.HashSet;

public class Criteria {
	private String regexp;
	private String name;
	private HashSet<String> tags;
	private static String TAG_SEPARATOR = ":";
	
	public Criteria(String testName){
		tags = new HashSet<String>();
		name = testName;
	}
	
	public void setName(String newName){
		name = newName;
	}
	
	public void setRegexp(String newRegexp){
		regexp = newRegexp;
	}
	
	public String getRegexp(){
		return regexp;
	}
	
	private HashSet<String> getHashSet(){
		return tags;
	}
	
	/**
	 * 
	 * @param inputTag is a string simple tag, or a concatenated string with the character ":" as a separator
	 */
	
	public void addTag(String inputTag){
		if (!inputTag.contains(TAG_SEPARATOR)){
			tags.add(inputTag);
			return;
		}
		
		String[] splitArray = inputTag.split(TAG_SEPARATOR);
		for (String s : splitArray){
			tags.add(s);
		}
	}
	
	public void addRegularExpression(String pattern){
		regexp = pattern;
	}
	
	/**
	 * 
	 * @return true if the regexp is setted
	 */
	private boolean hasRegexp(){
		return (regexp != null);
	}
	
	/**
	 * 
	 * @return true if the criteria have any tag
	 */
	private boolean hasTags(){
		return (!tags.isEmpty());
	}
	
	/**
	 * 
	 * @param anotherCriteria criteria wanted to compare
	 * @return true if there is not a regexp wanted, true if the pattern matches, and false if it dont.
	 */
	public boolean matchRegexp(Criteria anotherCriteria){
		if (! anotherCriteria.hasRegexp()) return true;
		
		if (! this.matchPattern (anotherCriteria.getRegexp() ) ) return false;
		else return true;
	}
	
	/**
	 * 
	 * @param pattern that im looking for
	 * @return true if the name of the Criteria matches the pattern
	 */
	private boolean matchPattern(String pattern){
		return (name.matches(pattern));
	}
	
	/**
	 * 
	 * @param tag that is going to be inspected
	 * @return true if the tag is contained in the criteria
	 */
	public boolean matchTag(String tag){
		return (tags.contains(tag));
	}
	
	/**
	 * 
	 * @param anotherCriteria
	 * @return true if both criteria does not have tags inside
	 */
	private boolean bothEmpty(Criteria anotherCriteria){
		return (!this.hasTags() && !anotherCriteria.hasTags());
	}
	
	/**
	 * 
	 * @param anotherCriteria
	 * @return true if the tags contained in the criteria are in my tags
	 */
	
	public boolean matchAllTags(Criteria anotherCriteria){
		
		if (this.bothEmpty(anotherCriteria)) return true;
		if (!anotherCriteria.hasTags()) return true;
		
		for (String tagSearched : anotherCriteria.getHashSet()){
			if (!tags.contains(tagSearched)) return false;
		}
		
		return true;
	}
	
	/**
	 * 
	 * @param anotherCriteria
	 * @return true if at least one of the tags contained in the criteria is in my tags
	 */
	
	public boolean matchAnyTag(Criteria anotherCriteria){
		
		if (this.bothEmpty(anotherCriteria)) return true;
		if (!anotherCriteria.hasTags()) return true;
		
		for (String tagSearched : anotherCriteria.getHashSet()){
			if (tags.contains(tagSearched)) return true;
		}
		
		return false;
	}
	
	/**
	 * 
	 * @param anotherCriteria
	 * @return true if both conditions described are true (match all the tags plus match regexp)
	 */
	
	public boolean matchAllTagsAndRegexp(Criteria anotherCriteria){
		if (!this.matchRegexp(anotherCriteria)) return false;
		return (this.matchAllTags(anotherCriteria));
	}
	
	/**
	 * 
	 * @param anotherCriteria
	 * @return true if both conditions described are true (match any tag plus match regexp)
	 */
	
	public boolean matchAnyTagAndRegexp(Criteria anotherCriteria){
		if (!this.matchRegexp(anotherCriteria)) return false;
		return (this.matchAnyTag(anotherCriteria));
	}
}
