package ar.uba.fi.tdd.grupo5;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.uba.fi.tdd.grupo5.framework.AssertionFailedException;

import ar.uba.fi.tdd.grupo5.framework.Assert;

public class AssertTest {

	@Test
	public void testAssertTrueStringBoolean() throws AssertionFailedException {
		assertTrue("JUnit assertTrue(String,boolean) fails with true parameter", true);
		Assert.assertTrue("Testing Framework assertTrue(String,boolean) fails with true parameter", true);
	}
	
	@Test(expected = AssertionFailedException.class)
	public void testFailAssertTrueStringBoolean() throws AssertionFailedException {
		Assert.assertTrue("Testing Framework assertTrue(String,boolean) throws AssertionFailedException with false parameter", false);
	}

	@Test
	public void testAssertTrueBoolean() throws AssertionFailedException {
		assertTrue(true);
		Assert.assertTrue(true);
	}
	
	@Test(expected = AssertionFailedException.class)
	public void testFailAssertTrueBoolean() throws AssertionFailedException {
		Assert.assertTrue(false);
	}

	@Test
	public void testAssertFalseStringBoolean() throws AssertionFailedException {
		assertFalse("JUnit assertFalse(String,boolean) fails with false parameter", false);
		Assert.assertFalse("Testing Framework assertFalse(String,boolean) fails with false parameter", false);
	}
	
	@Test(expected = AssertionFailedException.class)
	public void testFailAssertFalseStringBoolean() throws AssertionFailedException {
		Assert.assertFalse("Testing Framework assertFalse(String,boolean) throws AssertionFailedException with true parameter", true);
	}

	@Test
	public void testAssertFalseBoolean() throws AssertionFailedException {
		assertFalse(false);
		Assert.assertFalse(false);
	}
	
	@Test(expected = AssertionFailedException.class)
	public void testFailAssertFalseBoolean() throws AssertionFailedException {
		Assert.assertFalse(true);
	}

	@Test
	public void testAssertEqualsStringObjectObject() throws AssertionFailedException {
		Object object1 = new Float(5);
		Object object2 = new Float(5);
		assertEquals("JUnit assertEquals(String, object, object) fails with equal parameters", object1, object2);
		Assert.assertEquals("Testing Framework assertEquals(String, object, object) fails with equal parameters", object1, object2);
	}
	
	@Test(expected = AssertionFailedException.class)
	public void testFailAssertEqualsStringObjectObject() throws AssertionFailedException {
		Object object1 = new Float(5);
		Object object2 = new Float(6);
		Assert.assertEquals("Testing Framework assertEquals(String, object, object) throws AssertionFailedException with different parameters", object1, object2);
	}

	@Test
	public void testAssertEqualsObjectObject() throws AssertionFailedException {
		Object object1 = new Float(5);
		Object object2 = new Float(5);
		assertEquals(object1, object2);
		Assert.assertEquals( object1, object2);
	}
	
	@Test(expected = AssertionFailedException.class)
	public void testFailAssertEqualsObjectObject() throws AssertionFailedException {
		Object object1 = new Float(5);
		Object object2 = new Float(6);
		Assert.assertEquals(object1, object2);
	}

	@Test
	public void testAssertEqualsStringLongLong() throws AssertionFailedException {
		long long1 = 5;
		long long2 = 5;
		assertEquals("JUnit assertEquals(String, long, long) fails with equal parameters", long1, long2);
		Assert.assertEquals("Testing Framework assertEquals(String, long, long) fails with equal parameters", long1, long2);
	}
	
	@Test(expected = AssertionFailedException.class)
	public void testFailAssertEqualsStringLongLong() throws AssertionFailedException {
		long long1 = 5;
		long long2 = 6;
		Assert.assertEquals("Testing Framework assertEquals(String, long, long) throws AssertionFailedException with different parameters", long1, long2);
	}

	@Test
	public void testAssertEqualsLongLong() throws AssertionFailedException {
		long long1 = 5;
		long long2 = 5;
		assertEquals(long1, long2);
		Assert.assertEquals(long1, long2);
	}
	
	@Test(expected = AssertionFailedException.class)
	public void testFailAssertEqualsLongLong() throws AssertionFailedException {
		long long1 = 5;
		long long2 = 6;
		Assert.assertEquals(long1, long2);
	}

	@Test
	public void testAssertEqualsStringFloatFloatFloatZeroDelta() throws AssertionFailedException {
		float float1 = 5;
		float float2 = 5;
		float delta = 0;
		assertEquals("JUnit assertEquals(String, float, float, float) fails with equal parameters (Considering delta value)", float1, float2, delta);
		Assert.assertEquals("Testing Framework assertEquals(String, float, float, float) fails with equal parameters (Considering delta value)", float1, float2, delta);
	}
	
	@Test(expected = AssertionFailedException.class)
	public void testFailAssertEqualsStringFloatFloatFloatZeroDelta() throws AssertionFailedException {
		float float1 = 5;
		float float2 = 6;
		float delta = 0;
		Assert.assertEquals("Testing Framework assertEquals(String, float, float, float) throws AssertionFailedException with different parameters (Considering delta value)", float1, float2, delta);
	}
	
	@Test
	public void testAssertEqualsStringFloatFloatFloatNonZeroDelta() throws AssertionFailedException {
		float float1 = 5;
		float float2 = 6;
		float delta = 1;
		assertEquals("JUnit assertEquals(String, float, float, float) fails with equal parameters (Considering delta value)", float1, float2, delta);
		Assert.assertEquals("Testing Framework assertEquals(String, float, float, float) fails with equal parameters (Considering delta value)", float1, float2, delta);
	}
	
	@Test(expected = AssertionFailedException.class)
	public void testFailAssertEqualsStringFloatFloatFloatNonZeroDelta() throws AssertionFailedException {
		float float1 = 5;
		float float2 = 7;
		float delta = 1;
		Assert.assertEquals("Testing Framework assertEquals(String, float, float, float) throws AssertionFailedException with different parameters (Considering delta value)", float1, float2, delta);
	}

	@Test
	public void testAssertEqualsFloatFloatFloatZeroDelta() throws AssertionFailedException {
		float float1 = 5;
		float float2 = 5;
		float delta = 0;
		assertEquals(float1, float2, delta);
		Assert.assertEquals(float1, float2, delta);
	}
	
	@Test(expected = AssertionFailedException.class)
	public void testFailAssertEqualsFloatFloatFloatZeroDelta() throws AssertionFailedException {
		float float1 = 5;
		float float2 = 6;
		float delta = 0;
		Assert.assertEquals(float1, float2, delta);
	}
	
	@Test
	public void testAssertEqualsFloatFloatFloatNonZeroDelta() throws AssertionFailedException {
		float float1 = 5;
		float float2 = 6;
		float delta = 1;
		assertEquals(float1, float2, delta);
		Assert.assertEquals(float1, float2, delta);
	}
	
	@Test(expected = AssertionFailedException.class)
	public void testFailAssertEqualsFloatFloatFloatNonZeroDelta() throws AssertionFailedException {
		float float1 = 5;
		float float2 = 7;
		float delta = 1;
		Assert.assertEquals(float1, float2, delta);
	}

	@Test
	public void testAssertEqualsStringDoubleDoubleDoubleZeroDelta() throws AssertionFailedException {
		double double1 = 5;
		double double2 = 5;
		double delta = 0;
		assertEquals("JUnit assertEquals(String, double, double, double) fails with equal parameters (Considering delta value)", double1, double2, delta);
		Assert.assertEquals("Testing Framework assertEquals(String, double, double, double) fails with equal parameters (Considering delta value)", double1, double2, delta);
	}

	@Test(expected = AssertionFailedException.class)
	public void testFailAssertEqualsStringDoubleDoubleDoubleZeroDelta() throws AssertionFailedException {
		double double1 = 5;
		double double2 = 6;
		double delta = 0;
		Assert.assertEquals("Testing Framework assertEquals(String, double, double, double) throws AssertionFailedException with different parameters (Considering delta value)", double1, double2, delta);
	}
	
	@Test
	public void testAssertEqualsDoubleDoubleDoubleZeroDelta() throws AssertionFailedException {
		double double1 = 5;
		double double2 = 5;
		double delta = 0;
		assertEquals(double1, double2, delta);
		Assert.assertEquals(double1, double2, delta);
	}
	
	@Test(expected = AssertionFailedException.class)
	public void testFailAssertEqualsDoubleDoubleDoubleZeroDelta() throws AssertionFailedException {
		double double1 = 5;
		double double2 = 6;
		double delta = 0;
		Assert.assertEquals(double1, double2, delta);
	}
	
	@Test
	public void testAssertEqualsStringDoubleDoubleDoubleNonZeroDelta() throws AssertionFailedException {
		double double1 = 5;
		double double2 = 6;
		double delta = 1;
		assertEquals("JUnit assertEquals(String, double, double, double) fails with equal parameters (Considering delta value)", double1, double2, delta);
		Assert.assertEquals("Testing Framework assertEquals(String, double, double, double) fails with equal parameters (Considering delta value)", double1, double2, delta);
	}

	@Test(expected = AssertionFailedException.class)
	public void testFailAssertEqualsStringDoubleDoubleDoubleNonZeroDelta() throws AssertionFailedException {
		double double1 = 5;
		double double2 = 7;
		double delta = 1;
		Assert.assertEquals("Testing Framework assertEquals(String, double, double, double) throws AssertionFailedException with different parameters (Considering delta value)", double1, double2, delta);
	}
	
	@Test
	public void testAssertEqualsDoubleDoubleDoubleNonZeroDelta() throws AssertionFailedException {
		double double1 = 5;
		double double2 = 6;
		double delta = 1;
		assertEquals(double1, double2, delta);
		Assert.assertEquals(double1, double2, delta);
	}
	
	@Test(expected = AssertionFailedException.class)
	public void testFailAssertEqualsDoubleDoubleDoubleNonZeroDelta() throws AssertionFailedException {
		double double1 = 5;
		double double2 = 7;
		double delta = 1;
		Assert.assertEquals(double1, double2, delta);
	}
	
	@Test
	public void testSameStringObjectObject() throws AssertionFailedException {
		Object object = new Float(5);
		assertSame("JUnit assertSame(String, object, object) fails with same object parameters", object, object);
		Assert.assertSame("Testing Framework assertSame(String, object, object) fails with same object parameters", object, object);
	}
	
	@Test(expected = AssertionFailedException.class)
	public void testFailSameStringObjectObject() throws AssertionFailedException {
		Object object = new Float(5);
		Assert.assertSame("Testing Framework assertSame(String, object, object) throws AssertionFailedException with different object parameters", object, null);
	}
	
	@Test
	public void testSameObjectObject() throws AssertionFailedException {
		Object object = new Float(5);
		assertSame(object, object);
		Assert.assertSame(object, object);
	}
	
	@Test(expected = AssertionFailedException.class)
	public void testFailSameObjectObject() throws AssertionFailedException {
		Object object = new Float(5);
		Assert.assertSame(object, null);
	}
	
	@Test
	public void testNotSameStringObjectObject() throws AssertionFailedException {
		Object object1 = new Float(5);
		Object object2 = new Float(5);
		assertNotSame("JUnit assertNotSame(String, object, object) fails with same object parameters", object1, object2);
		Assert.assertNotSame("Testing Framework assertNotSame(String, object, object) fails with same object parameters", object1, object2);
	}
	
	@Test(expected = AssertionFailedException.class)
	public void testFailNotSameStringObjectObject() throws AssertionFailedException {
		Object object = new Float(5);
		Assert.assertNotSame("Testing Framework assertNotSame(String, object, object) throws AssertionFailedException with same object parameters", object, object);
	}
	
	@Test
	public void testNotSameObjectObject() throws AssertionFailedException {
		Object object1 = new Float(5);
		Object object2 = new Float(5);
		assertNotSame(object1, object2);
		Assert.assertNotSame(object1, object2);
	}
	
	@Test(expected = AssertionFailedException.class)
	public void testFailNotSameObjectObject() throws AssertionFailedException {
		Object object = new Float(5);
		Assert.assertNotSame(object, object);
	}
	
	/*
	@Test
	public void testAssertNotEqualsStringObjectObject() throws AssertionFailedException {
		fail("Not yet implemented");
	}
	
	@Test(expected = AssertionFailedException.class)
	public void testFailAssertNotEqualsStringObjectObject() throws AssertionFailedException {
		fail("Not yet implemented");
	}

	@Test
	public void testAssertNotEqualsObjectObject() throws AssertionFailedException {
		fail("Not yet implemented");
	}
	
	@Test(expected = AssertionFailedException.class)
	public void testFailAssertNotEqualsObjectObject() throws AssertionFailedException {
		fail("Not yet implemented");
	}

	@Test
	public void testAssertNotEqualsStringLongLong() throws AssertionFailedException {
		fail("Not yet implemented");
	}
	
	@Test(expected = AssertionFailedException.class)
	public void testFailAssertNotEqualsStringLongLong() throws AssertionFailedException {
		fail("Not yet implemented");
	}

	@Test
	public void testAssertNotEqualsLongLong() throws AssertionFailedException {
		fail("Not yet implemented");
	}
	
	@Test(expected = AssertionFailedException.class)
	public void testFailAssertNotEqualsLongLong() throws AssertionFailedException {
		fail("Not yet implemented");
	}

	@Test
	public void testAssertNotEqualsStringFloatFloatFloat() throws AssertionFailedException {
		fail("Not yet implemented");
	}
	
	@Test(expected = AssertionFailedException.class)
	public void testFailAssertNotEqualsStringFloatFloatFloat() throws AssertionFailedException {
		fail("Not yet implemented");
	}

	@Test
	public void testAssertNotEqualsFloatFloatFloat() throws AssertionFailedException {
		fail("Not yet implemented");
	}
	
	@Test(expected = AssertionFailedException.class)
	public void testFailAssertNotEqualsFloatFloatFloat() throws AssertionFailedException {
		fail("Not yet implemented");
	}

	@Test
	public void testAssertNotEqualsStringDoubleDoubleDouble() throws AssertionFailedException {
		fail("Not yet implemented");
	}
	
	@Test(expected = AssertionFailedException.class)
	public void testFailAssertNotEqualsStringDoubleDoubleDouble() throws AssertionFailedException {
		fail("Not yet implemented");
	}

	@Test
	public void testAssertNotEqualsDoubleDoubleDouble() throws AssertionFailedException {
		fail("Not yet implemented");
	}
	
	@Test(expected = AssertionFailedException.class)
	public void testFailAssertNotEqualsDoubleDoubleDouble() throws AssertionFailedException {
		fail("Not yet implemented");
	}
	*/
}
