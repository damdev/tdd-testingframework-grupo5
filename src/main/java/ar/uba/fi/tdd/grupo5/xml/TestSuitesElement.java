package ar.uba.fi.tdd.grupo5.xml;

public class TestSuitesElement extends Element {

	public TestSuitesElement() {
		super("testsuites");
	}

	public void setNameAttributeValue(String nameAttributeValue) {
		attributes.add(new Attribute("name", nameAttributeValue));
	}

	public void setTestsAttributeValue(String testsAttributeValue) {
		attributes.add(new Attribute("tests", testsAttributeValue));
	}

	public void setFailuresAttributeValue(String failuresAttributeValue) {
		attributes.add(new Attribute("failures", failuresAttributeValue));
	}

	public void setErrorsAttributeValue(String errorsAttributeValue) {
		attributes.add(new Attribute("errors", errorsAttributeValue));
	}

	public void setTimeAttributeValue(String timeAttributeValue) {
		attributes.add(new Attribute("time", timeAttributeValue));
	}

	public void setDisabledAttributeValue(boolean isDisabled) {
		attributes.add(new Attribute("disabled", disableMode(isDisabled)));
	}
	
	public void addTestSuiteElement(TestSuiteElement testSuite){
		addChild(testSuite);
	}
	
	private String disableMode(boolean isDisabled) {
		if (isDisabled) {
			return "YES";
		} else {
			return "NO";
		}
	}
}
