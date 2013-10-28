package ar.uba.fi.tdd.grupo5.test;

import ar.uba.fi.tdd.grupo5.framework.Assert;
import ar.uba.fi.tdd.grupo5.framework.AssertionFailedException;
import ar.uba.fi.tdd.grupo5.Calculator;
import ar.uba.fi.tdd.grupo5.framework.TestCase;

public class TestSubstraction extends TestCase {
	
	public TestSubstraction(String name) {
		super(name);
	}
	
	public TestSubstraction() {
		super();
	}
	
	public void testCode() throws AssertionFailedException{
		Calculator c = new Calculator();
		Assert.assertTrue( c.substract(10, 2) == 8);
	}
}