package ar.uba.fi.tdd.grupo5.framework.tagmanager;

import java.util.ArrayList;
import java.util.List;

public class MixedCriteria implements Criteria {

	private List<Criteria> criteriaList;
	
	public MixedCriteria() {
		criteriaList = new ArrayList<>();
	}
	
	public void add(Criteria criteria){
		criteriaList.add(criteria);
	}

	/**
	 * @param tagManager that we want to know if match all the criterias contained
	 */
	@Override
	public boolean match(TagManager tagManager) {
		
		for (Criteria criteria : criteriaList){
			if (!criteria.match(tagManager)) return false;
		}
		
		return true;
	}

}
