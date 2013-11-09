package ar.uba.fi.tdd.grupo5.framework.tagmanager;

public class AllTags extends TagManager implements Criteria {

	public AllTags(String testName) {
		super(testName);
		// TODO Auto-generated constructor stub
	}
	

	/**
	 * 
	 * @param tagManager wanted to analyze
	 * @return true if all of the tags contained in my tagSet are contained in the tagManager recibed
	 */
	@Override
	public boolean match(TagManager tagManager) {
		if (this.bothEmpty(tagManager)) return true;
		if (!this.hasTags()) return true;
		
		
		for (String tagSearched : this.getHashSet()){
			if (!tagManager.matchTag(tagSearched)) return false;
		}
		
		return true;
	}

}
