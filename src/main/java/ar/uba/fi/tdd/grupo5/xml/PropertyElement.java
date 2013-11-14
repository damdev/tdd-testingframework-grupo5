package ar.uba.fi.tdd.grupo5.xml;

public class PropertyElement extends Element {

	public PropertyElement(String nameAttributeValue, String valueAttributeValue) {
		super("property");
		setNameAttributeValue(nameAttributeValue);
		setValueAttributeValue(valueAttributeValue);
	}

	public void setNameAttributeValue(String nameAttributeValue) {
		attributes.add(new Attribute("name", nameAttributeValue));
	}

	public void setValueAttributeValue(String valueAttributeValue) {
		attributes.add(new Attribute("value", valueAttributeValue));
	}

}
