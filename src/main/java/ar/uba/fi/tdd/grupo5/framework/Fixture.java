package ar.uba.fi.tdd.grupo5.framework;

import java.util.Map;

public class Fixture {
	
	private Map<String, Object> objectMap;
	
	public Fixture(){
		objectMap.clear();
	}
	
	public void addObject(String ID, Object object){
		objectMap.put(ID, object);
	}
	
	public Fixture cloneFixture(){
		Fixture clonedFixture = new Fixture();
		cloneMap(clonedFixture.objectMap);
		return clonedFixture;
	}
	
	private void cloneMap(Map<String, Object> emptylObjectMap){
		emptylObjectMap.putAll(objectMap);
	}
}
