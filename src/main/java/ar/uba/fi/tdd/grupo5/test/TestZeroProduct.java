package ar.uba.fi.tdd.grupo5.test;

import ar.uba.fi.tdd.grupo5.framework.Assert;
import ar.uba.fi.tdd.grupo5.framework.AssertionFailedException;
import ar.uba.fi.tdd.grupo5.Calculator;
import ar.uba.fi.tdd.grupo5.framework.TestCase;

public class TestZeroProduct extends TestCase {
	
	public TestZeroProduct(String name) {
		super(name);
	}
	
	public TestZeroProduct() {
		super();
	}
	
	public void testCode() throws AssertionFailedException{
		Calculator c = new Calculator();
		Assert.assertTrue( c.product(5, 0) == 0);
	}
}
