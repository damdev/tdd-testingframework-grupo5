package ar.uba.fi.tdd.grupo5.xml;

public class TestSuiteElement extends Element {

	public TestSuiteElement(String nameAttributeValue,
			String testsAttributeValue) {
		super("testsuite");
		setNameAttributeValue(nameAttributeValue);
		setTestsAttributeValue(testsAttributeValue);
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

	public void setSkippedAttributeValue(boolean isSkipped) {
		attributes.add(new Attribute("skipped", skippedMode(isSkipped)));
	}

	public void setTimestampAttributeValue(String timestampAttributeValue) {
		attributes.add(new Attribute("timestamp", timestampAttributeValue));
	}

	public void setHostnameAttributeValue(String hostnameAttributeValue) {
		attributes.add(new Attribute("hostname", hostnameAttributeValue));
	}

	public void setIDAttributeValue(String idAttributeValue) {
		attributes.add(new Attribute("id", idAttributeValue));
	}

	public void setPackageAttributeValue(String packageAttributeValue) {
		attributes.add(new Attribute("package", packageAttributeValue));
	}

	private String disableMode(boolean isDisabled) {
		if (isDisabled) {
			return "YES";
		} else {
			return "NO";
		}
	}

	private String skippedMode(boolean isSkipped) {
		if (isSkipped) {
			return "YES";
		} else {
			return "NO";
		}
	}
}
