package ar.uba.fi.tdd.grupo5.framework.tagmanager;

public class AllTags extends TagManager implements Criteria {

	private final static String className = "All Tags Criteria";

	public AllTags() {
		super(className);
	}

	public AllTags(String inputTags) {
		super(className);
		add(inputTags);
	}

	/**
	 * 
	 * @param tagManager
	 *            wanted to analyze
	 * @return true if all of the tags contained in my tagSet are contained in
	 *         the tagManager recibed
	 */
	@Override
	public boolean match(TagManager tagManager) {
		if (this.bothEmpty(tagManager))
			return true;
		if (!this.hasTags())
			return true;
		for (String tagSearched : this.getHashSet()) {
			if (!tagManager.matchTag(tagSearched))
				return false;
		}
		return true;
	}
}
