package ar.uba.fi.tdd.grupo5.framework;

import java.util.HashMap;
import java.util.Map;

public class Fixture {

	private Map<String, Object> objectMap;

	public Fixture() {
		objectMap = new HashMap<String, Object>();
	}

	public void add(String ID, Object object) {
		objectMap.put(ID, object);
	}

	public Object get(String ID) {
		return objectMap.get(ID);
	}

	public Fixture cloneFixture() {
		Fixture clonedFixture = new Fixture();
		cloneMap(clonedFixture.objectMap);
		return clonedFixture;
	}

	private void cloneMap(Map<String, Object> emptylObjectMap) {
		emptylObjectMap.putAll(objectMap);
	}
}
