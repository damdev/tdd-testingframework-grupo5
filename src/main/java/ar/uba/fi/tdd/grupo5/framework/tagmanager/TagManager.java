package ar.uba.fi.tdd.grupo5.framework.tagmanager;

import java.util.HashSet;

public class TagManager {
	protected String name;
	protected HashSet<String> tags;
	protected static String TAG_SEPARATOR = ":";
	
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

	
	protected HashSet<String> getHashSet(){
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
	
	/**
	 * 
	 * @return true if the criteria have any tag
	 */
	protected boolean hasTags(){
		return (!tags.isEmpty());
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
	protected boolean bothEmpty(TagManager tagManager){
		return (!this.hasTags() && !tagManager.hasTags());
	}
}
