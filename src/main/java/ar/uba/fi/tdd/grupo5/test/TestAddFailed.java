package ar.uba.fi.tdd.grupo5.test;

import ar.uba.fi.tdd.grupo5.framework.Assert;
import ar.uba.fi.tdd.grupo5.framework.AssertionFailedException;
import ar.uba.fi.tdd.grupo5.Calculator;
import ar.uba.fi.tdd.grupo5.framework.TestCase;

public class TestAddFailed extends TestCase {
	
	public TestAddFailed(String name) {
		super(name);
	}
	
	public TestAddFailed() {
		super();
	}
	
	@Override
	public void testCode() throws AssertionFailedException {
		Calculator c = new Calculator();
		Assert.assertTrue( c.add(1, 1) == 1);
	}
}
