package ar.uba.fi.tdd.grupo5.test;

import ar.uba.fi.tdd.grupo5.framework.Assert;
import ar.uba.fi.tdd.grupo5.Calculator;
import ar.uba.fi.tdd.grupo5.framework.TestCase;
import ar.uba.fi.tdd.grupo5.framework.exception.AssertException;

public class AddTest extends TestCase {
	
	public AddTest(String name) {
		super(name);
	}
	
	public AddTest() {
		super();
	}
	
	public void testCode() throws AssertException{
		Calculator c = new Calculator();
		Assert.assertTrue( c.add(2, 3) == 5);
	}
}
