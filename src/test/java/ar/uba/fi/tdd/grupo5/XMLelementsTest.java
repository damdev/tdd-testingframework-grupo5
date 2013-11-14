package ar.uba.fi.tdd.grupo5;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.uba.fi.tdd.grupo5.xml.*;

public class XMLelementsTest {

	private final String emptyFailure = "<failure />\n";
	private final String failureWithAttributes = "<failure message=\"A message\" type=\"A type\" />\n";
	private final String emptyError = "<error />\n";
	private final String errorWithAttributes = "<error message=\"A message\" type=\"A type\" />\n";
	private final String propertyWithAttributes = "<property name=\"A name\" value=\"A value\" />\n";
	private final String propertiesWithPropertyStream = "<properties >\n\t<property name=\"A name\" value=\"A value\" />\n</properties>\n";
	private final String skippedElementStream = "<skipped>YES</skipped>\n";
	private final String nonSkippedElementStream = "<skipped>NO</skipped>\n";
	private final String systemerrElementStream = "<system-err>A content</system-err>\n";
	private final String systemoutElementStream = "<system-out>A content</system-out>\n";
	private final String testCaseWithOnlyNameAttribute = "<testcase name=\"A name\" />\n";
	private final String testCaseWithFullAttributes = "<testcase name=\"A name\" assertions=\"An assertions\" classname=\"A classname\" status=\"A status\" time=\"A time\" />\n";
	private final String testSuiteWithOnlyRequiredAttributesStream = "<testsuite name=\"A name\" tests=\"A tests\" />\n";
	private final String testSuiteWithFullAttributesStream = "<testsuite name=\"A name\" tests=\"A tests\" disabled=\"YES\" errors=\"An errors\" failures=\"A failures\" hostname=\"A hostname\" id=\"An ID\" package=\"A package\" skipped=\"YES\" time=\"A time\" timestamp=\"A timestamp\" />\n";
	private final String twoLevelStream = "<testsuite name=\"TestSuite name\" tests=\"A tests\" >\n\t<testcase name=\"TestCase name\" />\n</testsuite>\n";
	private final String threeLevelStream = "<testsuite name=\"TestSuite name\" tests=\"A tests\" >\n\t<testcase name=\"TestCase1 name\" />\n\t<testsuite name=\"TestSuite2 name\" tests=\"A tests\" >\n\t\t<testcase name=\"TestCase2 name\" />\n\t\t<testcase name=\"TestCase3 name\" />\n\t</testsuite>\n</testsuite>\n";

	@Test
	public void emptyFailureElement() {
		FailureElement failureElement = new FailureElement();
		String XML = failureElement.getXMLFormatElement();
		assertEquals(emptyFailure, XML);
	}

	@Test
	public void failureElementWithAttributes() {
		FailureElement failureElement = new FailureElement();
		failureElement.setMessageAttributeValue("A message");
		failureElement.setTypeAttributeValue("A type");
		String XML = failureElement.getXMLFormatElement();
		assertEquals(failureWithAttributes, XML);
	}

	@Test
	public void emptyErrorElement() {
		ErrorElement errorElement = new ErrorElement();
		String XML = errorElement.getXMLFormatElement();
		assertEquals(emptyError, XML);
	}

	@Test
	public void errorElementWithAttributes() {
		ErrorElement errorElement = new ErrorElement();
		errorElement.setMessageAttributeValue("A message");
		errorElement.setTypeAttributeValue("A type");
		String XML = errorElement.getXMLFormatElement();
		assertEquals(errorWithAttributes, XML);
	}

	@Test
	public void propertyElementWithAttributes() {
		PropertyElement propertyElement = new PropertyElement("A name",
				"A value");
		String XML = propertyElement.getXMLFormatElement();
		assertEquals(propertyWithAttributes, XML);
	}

	@Test
	public void propertiesElementWithProperty() {
		PropertiesElement propertiesElement = new PropertiesElement();
		propertiesElement.addPropertyElement(new PropertyElement("A name",
				"A value"));
		String XML = propertiesElement.getXMLFormatElement();
		assertEquals(propertiesWithPropertyStream, XML);
	}

	@Test
	public void skippedElement() {
		SkippedElement skippedElement = new SkippedElement(true);
		String XML = skippedElement.getXMLFormatElement();
		assertEquals(skippedElementStream, XML);
	}

	@Test
	public void nonSkippedElement() {
		SkippedElement nonSkippedElement = new SkippedElement(false);
		String XML = nonSkippedElement.getXMLFormatElement();
		assertEquals(nonSkippedElementStream, XML);
	}

	@Test
	public void systemerrElement() {
		SystemerrElement systemerrElement = new SystemerrElement("A content");
		String XML = systemerrElement.getXMLFormatElement();
		assertEquals(systemerrElementStream, XML);
	}

	@Test
	public void systemoutElement() {
		SystemoutElement systemoutElement = new SystemoutElement("A content");
		String XML = systemoutElement.getXMLFormatElement();
		assertEquals(systemoutElementStream, XML);
	}

	@Test
	public void testCaseElementWithOnlyName() {
		TestCaseElement testCaseElement = new TestCaseElement("A name");
		String XML = testCaseElement.getXMLFormatElement();
		assertEquals(testCaseWithOnlyNameAttribute, XML);
	}

	@Test
	public void testCaseElementWithFullAttributes() {
		TestCaseElement testCaseElement = new TestCaseElement("A name");
		testCaseElement.setAssertionsAttributeValue("An assertions");
		testCaseElement.setClassnameAttributeValue("A classname");
		testCaseElement.setStatusAttributeValue("A status");
		testCaseElement.setTimeAttributeValue("A time");
		String XML = testCaseElement.getXMLFormatElement();
		assertEquals(testCaseWithFullAttributes, XML);
	}

	@Test
	public void testSuiteElementWithRequiredAttributes() {
		TestSuiteElement testSuiteElement = new TestSuiteElement("A name",
				"A tests");
		String XML = testSuiteElement.getXMLFormatElement();
		assertEquals(testSuiteWithOnlyRequiredAttributesStream, XML);
	}

	@Test
	public void testSuiteElementWithFullAttributes() {
		TestSuiteElement testSuiteElement = new TestSuiteElement("A name",
				"A tests");
		testSuiteElement.setDisabledAttributeValue(true);
		testSuiteElement.setErrorsAttributeValue("An errors");
		testSuiteElement.setFailuresAttributeValue("A failures");
		testSuiteElement.setHostnameAttributeValue("A hostname");
		testSuiteElement.setIDAttributeValue("An ID");
		testSuiteElement.setPackageAttributeValue("A package");
		testSuiteElement.setSkippedAttributeValue(true);
		testSuiteElement.setTimeAttributeValue("A time");
		testSuiteElement.setTimestampAttributeValue("A timestamp");
		String XML = testSuiteElement.getXMLFormatElement();
		assertEquals(testSuiteWithFullAttributesStream, XML);
	}

	@Test
	public void twoLevelAnidationTest() {
		TestSuiteElement testSuiteElement = new TestSuiteElement(
				"TestSuite name", "A tests");
		testSuiteElement
				.addTestCaseElement(new TestCaseElement("TestCase name"));
		String XML = testSuiteElement.getXMLFormatElement();
		assertEquals(twoLevelStream, XML);
	}

	@Test
	public void threeLevelAnidationTest() {
		TestSuiteElement testSuiteElement = new TestSuiteElement(
				"TestSuite name", "A tests");
		TestSuiteElement testSuiteElement2 = new TestSuiteElement(
				"TestSuite2 name", "A tests");

		testSuiteElement.addTestCaseElement(new TestCaseElement(
				"TestCase1 name"));
		testSuiteElement.addTestSuiteElement(testSuiteElement2);
		testSuiteElement2.addTestCaseElement(new TestCaseElement(
				"TestCase2 name"));
		testSuiteElement2.addTestCaseElement(new TestCaseElement(
				"TestCase3 name"));

		String XML = testSuiteElement.getXMLFormatElement();
		assertEquals(threeLevelStream, XML);
	}
}