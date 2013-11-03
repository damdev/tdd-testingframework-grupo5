package ar.uba.fi.tdd.grupo5.test;

import ar.uba.fi.tdd.grupo5.framework.Assert;
import ar.uba.fi.tdd.grupo5.Calculator;
import ar.uba.fi.tdd.grupo5.framework.TestCase;
import ar.uba.fi.tdd.grupo5.framework.exception.AssertException;

public class ProductTest extends TestCase {
	
	public ProductTest(String name) {
		super(name);
	}
	
	public ProductTest() {
		super();
	}
	
	public void testCode() throws AssertException{
		Calculator c = new Calculator();
		Assert.assertTrue( c.product(2, 7) == 14);
	}
}
