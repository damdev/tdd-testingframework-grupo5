package ar.uba.fi.tdd.grupo5.framework.tagmanager;

public class AllMatch implements Criteria {

	/**
	 * Used when we want all the cases
	 * @return always return true
	 */
	@Override
	public boolean match(TagManager tagManager) {
		return true;
	}

}
