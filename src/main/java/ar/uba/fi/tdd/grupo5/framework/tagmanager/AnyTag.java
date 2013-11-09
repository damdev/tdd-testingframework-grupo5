package ar.uba.fi.tdd.grupo5.framework.tagmanager;

public class AnyTag extends TagManager implements Criteria {

	public AnyTag(String testName) {
		super(testName);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param anotherCriteria
	 * @return true if at least one of the tags contained in the criteria is in my tags
	 */
	@Override
	public boolean match(TagManager tagManager) {
		if (this.bothEmpty(tagManager)) return true;
		if (!this.hasTags()) return true;
		
		for (String tagSearched : tagManager.getHashSet()){
			if (tags.contains(tagSearched)) return true;
		}
		
		return false;
	}


}
