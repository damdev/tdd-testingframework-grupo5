package ar.uba.fi.tdd.grupo5;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.uba.fi.tdd.grupo5.framework.Fixture;

public class FixtureTest {

	@Test
	public void addInteger() {
		Fixture fx = new Fixture();
		Integer integer = 1;
		fx.add("number", integer);
		assertEquals(1, (int) fx.get("number"));
	}
	
	@Test
	public void addString() {
		Fixture fx = new Fixture();
		String string = "hello";
		fx.add("string", string);
		assertEquals("hello", (String) fx.get("string"));
	}
	
	@Test
	public void addStringAndErroneousGet() {
		Fixture fx = new Fixture();
		String string = "bye";
		fx.add("string", string);
		assertEquals(null, fx.get("number"));
	}

}
