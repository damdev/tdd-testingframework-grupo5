package ar.uba.fi.tdd.grupo5.framework.tagmanager;

import java.util.HashSet;

public class TagManager {
	protected String name;
	protected HashSet<String> tags;
	protected static String TAG_SEPARATOR = ":";
	
	/**
	 * 
	 * @param testName the name of the test that uses this tagManager
	 */
	public TagManager(String testName){
		tags = new HashSet<String>();
		name = testName;
	}
	
	public void setName(String newName){
		name = newName;
	}
	
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @param inputTags is a string simple tag, or a concatenated string with the character ":" as a separator
	 */
	
	public void add(String inputTags){
		if (!inputTags.contains(TAG_SEPARATOR)){
			tags.add(inputTags);
			return;
		}
		
		String[] splitArray = inputTags.split(TAG_SEPARATOR);
		for (String s : splitArray){
			tags.add(s);
		}
	}
	
	/**
	 * 
	 * @param inputTag the tag wanted to be removed
	 * @return true if it was possible to remove the tag, false if it was not.
	 */
	public boolean remove(String inputTag){
		return tags.remove(inputTag);
	}
	
	/**
	 * 
	 * @return true if the criteria have any tag
	 */
	public boolean hasTags(){
		return (!tags.isEmpty());
	}
	
	/**
	 * 
	 * @param tag that is going to be inspected
	 * @return true if the tag is contained in the tagManager
	 */
	public boolean matchTag(String tag){
		return (tags.contains(tag));
	}
	
	public String toString(){
		return name + " " + tags.toString();
	}
	
	protected HashSet<String> getHashSet(){
		return tags;
	}
	
	/**
	 * 
	 * @param tagManager
	 * @return true if both any tag manager has tags inside
	 */
	protected boolean bothEmpty(TagManager tagManager){
		return (!this.hasTags() && !tagManager.hasTags());
	}
}
