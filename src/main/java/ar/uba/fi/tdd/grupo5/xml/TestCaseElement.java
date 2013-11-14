package ar.uba.fi.tdd.grupo5.xml;

public class TestCaseElement extends Element {

	public TestCaseElement(String nameAttributeValue) {
		super("testcase");
		setNameAttributeValue(nameAttributeValue);
	}

	public void setNameAttributeValue(String nameAttributeValue) {
		attributes.add(new Attribute("name", nameAttributeValue));
	}

	public void setAssertionsAttributeValue(String assertionsAttributeValue) {
		attributes.add(new Attribute("assertions", assertionsAttributeValue));
	}

	public void setTimeAttributeValue(String timeAttributeValue) {
		attributes.add(new Attribute("time", timeAttributeValue));
	}

	public void setClassnameAttributeValue(String classnameAttributeValue) {
		attributes.add(new Attribute("classname", classnameAttributeValue));
	}

	public void setStatusAttributeValue(String statusAttributeValue) {
		attributes.add(new Attribute("status", statusAttributeValue));
	}
	
	public void addSkippedElement(SkippedElement skipped){
		addChild(skipped);
	}
	
	public void addErrorElement(ErrorElement error){
		addChild(error);
	}
	
	public void addFailureElement(FailureElement failure){
		addChild(failure);
	}
	
	public void addSystemOutElement(SystemoutElement systemout){
		addChild(systemout);
	}
	
	public void addSystemErrElement(SystemerrElement systemerr){
		addChild(systemerr);
	}
}
