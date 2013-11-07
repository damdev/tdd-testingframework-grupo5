package ar.uba.fi.tdd.grupo5.framework;

import java.util.HashMap;
import java.util.Map;


/**
 * 
 * The Fixture is the environment of the {@link TestSuite} and the
 * {@link TestCase}, filled by the user with the objects that he need to run the
 * tests
 * 
 */
public class Fixture {

	private Map<String, Object> objectMap;

	/**
	 * Constructs an empty {@code Fixture}.
	 * 
	 */
	public Fixture() {
		objectMap = new HashMap<String, Object>();
	}

	/**
	 * Add a pair <String, Object> to the {@code Fixture}.
	 * 
	 * @param ID
	 *            the ID of the object that is added to the Fixture
	 * @param object
	 *            the object itself that is added to the Fixture
	 * 
	 */
	public void add(String ID, Object object) {
		objectMap.put(ID, object);
	}

	/**
	 * Gets the object with the specified ID. If the ID doesn't exists
	 * in the Fixture, return null
	 * 
	 * @param ID
	 *            the ID of the searched object in the Fixture
	 * @return Object
	 * 
	 */
	public Object get(String ID) {
		return objectMap.get(ID);
	}

	/**
	 * Creates and returns a copy of this {@code Fixture}.
	 * 
	 * @return Fixture
	 *              a clone of this instance
	 * 
	 */
	public Fixture cloneFixture() {
		Fixture clonedFixture = new Fixture();
		cloneMap(clonedFixture.objectMap);
		return clonedFixture;
	}

	private void cloneMap(Map<String, Object> emptylObjectMap) {
		emptylObjectMap.putAll(objectMap);
	}
}
