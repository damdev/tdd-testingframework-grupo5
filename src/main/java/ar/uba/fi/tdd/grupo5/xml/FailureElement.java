package ar.uba.fi.tdd.grupo5.xml;

public class FailureElement extends Element {

	public FailureElement() {
		super("failure");
	}

	public void setTypeAttributeValue(String typeAttributeValue) {
		attributes.add(new Attribute("type", typeAttributeValue));
	}

	public void setMessageAttributeValue(String messageAttributeValue) {
		attributes.add(new Attribute("message", messageAttributeValue));
	}

}
