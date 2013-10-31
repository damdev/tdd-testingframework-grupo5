package ar.uba.fi.tdd.grupo5;

import static org.junit.Assert.*;
import org.junit.Test;
import ar.uba.fi.tdd.grupo5.framework.Assert;
import ar.uba.fi.tdd.grupo5.framework.AssertionFailedException;

public class AssertTest {

	@Test
	public void successAssertTrueWithPersonalizedMessage()
			throws AssertionFailedException {
		Assert.assertTrue("Testing Framework assertTrue(String,boolean) fails"
				+ " with true parameter", true);
		assertTrue(
				"JUnit assertTrue(String,boolean) fails with true parameter",
				true);
	}

	@Test(expected = AssertionFailedException.class)
	public void failAssertTrueWithPersonalizedMessage()
			throws AssertionFailedException {
		Assert.assertTrue("Testing Framework assertTrue(String,boolean) throws"
				+ " AssertionFailedException with false parameter", false);
	}

	@Test
	public void successAssertTrue() throws AssertionFailedException {
		Assert.assertTrue(true);
		assertTrue(true);
	}

	@Test(expected = AssertionFailedException.class)
	public void failAssertTrue() throws AssertionFailedException {
		Assert.assertTrue(false);
	}

	@Test
	public void successAssertFalseWithPersonalizedMessage()
			throws AssertionFailedException {
		Assert.assertFalse("Testing Framework assertFalse(String,boolean) "
				+ "fails with false parameter", false);
		assertFalse("JUnit assertFalse(String,boolean) fails with false"
				+ " parameter", false);
	}

	@Test(expected = AssertionFailedException.class)
	public void failAssertFalseWithPersonalizedMessage()
			throws AssertionFailedException {
		Assert.assertFalse("Testing Framework assertFalse(String,boolean) "
				+ "throws AssertionFailedException with true parameter", true);
	}

	@Test
	public void successAssertFalse() throws AssertionFailedException {
		assertFalse(false);
		Assert.assertFalse(false);
	}

	@Test(expected = AssertionFailedException.class)
	public void failAssertFalse() throws AssertionFailedException {
		Assert.assertFalse(true);
	}

	@Test
	public void successAssertEqualsObjectsWithPersonalizedMessage()
			throws AssertionFailedException {
		Object object1 = new Float(5);
		Object object2 = new Float(5);
		Assert.assertEquals("Testing Framework assertEquals(String, object, "
				+ "object) fails with equal parameters", object1, object2);
		assertEquals("JUnit assertEquals(String, object, object) fails with "
				+ "equal parameters", object1, object2);
	}

	@Test(expected = AssertionFailedException.class)
	public void failAssertEqualsObjectsWithPersonalizedMessage()
			throws AssertionFailedException {
		Object object1 = new Float(5);
		Object object2 = new Float(6);
		Assert.assertEquals("Testing Framework assertEquals(String, object, "
				+ "object) throws AssertionFailedException with different "
				+ "parameters", object1, object2);
	}

	@Test
	public void successAssertEqualsObjects() throws AssertionFailedException {
		Object object1 = new Float(5);
		Object object2 = new Float(5);
		Assert.assertEquals(object1, object2);
		assertEquals(object1, object2);
	}

	@Test(expected = AssertionFailedException.class)
	public void failAssertEqualsObjects() throws AssertionFailedException {
		Object object1 = new Float(5);
		Object object2 = new Float(6);
		Assert.assertEquals(object1, object2);
	}

	@Test
	public void successAssertEqualsLongWithPersonalizedMessage()
			throws AssertionFailedException {
		long long1 = 5;
		long long2 = 5;
		Assert.assertEquals("Testing Framework assertEquals(String, long, "
				+ "long) fails with equal parameters", long1, long2);
		assertEquals("JUnit assertEquals(String, long, long) fails with equal "
				+ "parameters", long1, long2);
	}

	@Test(expected = AssertionFailedException.class)
	public void failAssertEqualsLongWithPersonalizedMessage()
			throws AssertionFailedException {
		long long1 = 5;
		long long2 = 6;
		Assert.assertEquals("Testing Framework assertEquals(String, long, "
				+ "long) throws AssertionFailedException with different "
				+ "parameters", long1, long2);
	}

	@Test
	public void successAssertEqualsLong() throws AssertionFailedException {
		long long1 = 5;
		long long2 = 5;
		Assert.assertEquals(long1, long2);
		assertEquals(long1, long2);
	}

	@Test(expected = AssertionFailedException.class)
	public void failAssertEqualsLong() throws AssertionFailedException {
		long long1 = 5;
		long long2 = 6;
		Assert.assertEquals(long1, long2);
	}

	@Test
	public void successAssertEqualsFloatWithZeroDeltaValueWithPersonalizedMessage()
			throws AssertionFailedException {
		float float1 = 5;
		float float2 = 5;
		float delta = 0;
		Assert.assertEquals("Testing Framework assertEquals(String, float, "
				+ "float, float) fails with equal parameters (Considering "
				+ "delta value)", float1, float2, delta);
		assertEquals("JUnit assertEquals(String, float, float, float) fails "
				+ "with equal parameters (Considering delta value)", float1,
				float2, delta);
	}

	@Test(expected = AssertionFailedException.class)
	public void failAssertEqualsFloatWithZeroDeltaValueWithPersonalizedMessage()
			throws AssertionFailedException {
		float float1 = 5;
		float float2 = 6;
		float delta = 0;
		Assert.assertEquals("Testing Framework assertEquals(String, float, "
				+ "float, float) throws AssertionFailedException with "
				+ "different parameters (Considering delta value)", float1,
				float2, delta);
	}

	@Test
	public void successAssertEqualsFloatWithNonZeroDeltaValueWithPersonalizedMessage()
			throws AssertionFailedException {
		float float1 = 5;
		float float2 = 6;
		float delta = 1;
		Assert.assertEquals("Testing Framework assertEquals(String, float, "
				+ "float, float) fails with equal parameters (Considering "
				+ "delta value)", float1, float2, delta);
		assertEquals("JUnit assertEquals(String, float, float, float) fails "
				+ "with equal parameters (Considering delta value)", float1,
				float2, delta);
	}

	@Test(expected = AssertionFailedException.class)
	public void failAssertEqualsFloatWithNonZeroDeltaValueWithPersonalizedMessage()
			throws AssertionFailedException {
		float float1 = 5;
		float float2 = 7;
		float delta = 1;
		Assert.assertEquals("Testing Framework assertEquals(String, float, "
				+ "float, float) throws AssertionFailedException with "
				+ "different parameters (Considering delta value)", float1,
				float2, delta);
	}

	@Test
	public void successAssertEqualsFloatWithZeroDeltaValue()
			throws AssertionFailedException {
		float float1 = 5;
		float float2 = 5;
		float delta = 0;
		assertEquals(float1, float2, delta);
		Assert.assertEquals(float1, float2, delta);
	}

	@Test(expected = AssertionFailedException.class)
	public void failAssertEqualsFloatWithZeroDeltaValue()
			throws AssertionFailedException {
		float float1 = 5;
		float float2 = 6;
		float delta = 0;
		Assert.assertEquals(float1, float2, delta);
	}

	@Test
	public void successAssertEqualsFloatWithNonZeroDeltaValue()
			throws AssertionFailedException {
		float float1 = 5;
		float float2 = 6;
		float delta = 1;
		assertEquals(float1, float2, delta);
		Assert.assertEquals(float1, float2, delta);
	}

	@Test(expected = AssertionFailedException.class)
	public void failAssertEqualsFloatWithNonZeroDeltaValue()
			throws AssertionFailedException {
		float float1 = 5;
		float float2 = 7;
		float delta = 1;
		Assert.assertEquals(float1, float2, delta);
	}

	@Test
	public void successAssertEqualsDoubleWithZeroDeltaValueWithPersonalizedMessage()
			throws AssertionFailedException {
		double double1 = 5;
		double double2 = 5;
		double delta = 0;
		assertEquals("JUnit assertEquals(String, double, double, double) "
				+ "fails with equal parameters (Considering delta value)",
				double1, double2, delta);
		Assert.assertEquals("Testing Framework assertEquals(String, double, "
				+ "double, double) fails with equal parameters (Considering "
				+ "delta value)", double1, double2, delta);
	}

	@Test(expected = AssertionFailedException.class)
	public void failAssertEqualsDoubleWithZeroDeltaValueWithPersonalizedMessage()
			throws AssertionFailedException {
		double double1 = 5;
		double double2 = 6;
		double delta = 0;
		Assert.assertEquals("Testing Framework assertEquals(String, double, "
				+ "double, double) throws AssertionFailedException with "
				+ "different parameters (Considering delta value)", double1,
				double2, delta);
	}

	@Test
	public void successAssertEqualsDoubleWithZeroDeltaValue()
			throws AssertionFailedException {
		double double1 = 5;
		double double2 = 5;
		double delta = 0;
		assertEquals(double1, double2, delta);
		Assert.assertEquals(double1, double2, delta);
	}

	@Test(expected = AssertionFailedException.class)
	public void failAssertEqualsDoubleWithZeroDeltaValue()
			throws AssertionFailedException {
		double double1 = 5;
		double double2 = 6;
		double delta = 0;
		Assert.assertEquals(double1, double2, delta);
	}

	@Test
	public void successAssertEqualsDoubleWithNonZeroDeltaValueWithPersonalizedMessage()
			throws AssertionFailedException {
		double double1 = 5;
		double double2 = 6;
		double delta = 1;
		assertEquals("JUnit assertEquals(String, double, double, double) "
				+ "fails with equal parameters (Considering delta value)",
				double1, double2, delta);
		Assert.assertEquals("Testing Framework assertEquals(String, double, "
				+ "double, double) fails with equal parameters (Considering "
				+ "delta value)", double1, double2, delta);
	}

	@Test(expected = AssertionFailedException.class)
	public void failAssertEqualsDoubleWithNonZeroDeltaValueWithPersonalizedMessage()
			throws AssertionFailedException {
		double double1 = 5;
		double double2 = 7;
		double delta = 1;
		Assert.assertEquals("Testing Framework assertEquals(String, double, "
				+ "double, double) throws AssertionFailedException with "
				+ "different parameters (Considering delta value)", double1,
				double2, delta);
	}

	@Test
	public void successAssertEqualsDoubleWithNonZeroDeltaValue()
			throws AssertionFailedException {
		double double1 = 5;
		double double2 = 6;
		double delta = 1;
		assertEquals(double1, double2, delta);
		Assert.assertEquals(double1, double2, delta);
	}

	@Test(expected = AssertionFailedException.class)
	public void failAssertEqualsDoubleWithNonZeroDeltaValue()
			throws AssertionFailedException {
		double double1 = 5;
		double double2 = 7;
		double delta = 1;
		Assert.assertEquals(double1, double2, delta);
	}

	@Test
	public void successAssertSameObjectWithPersonalizedMessage()
			throws AssertionFailedException {
		Object object = new Float(5);
		assertSame("JUnit assertSame(String, object, object) fails with same "
				+ "object parameters", object, object);
		Assert.assertSame("Testing Framework assertSame(String, object, "
				+ "object) fails with same object parameters", object, object);
	}

	@Test(expected = AssertionFailedException.class)
	public void failAssertSameObjectWithPersonalizedMessage()
			throws AssertionFailedException {
		Object object = new Float(5);
		Assert.assertSame("Testing Framework assertSame(String, object, "
				+ "object) throws AssertionFailedException with different "
				+ "object parameters", object, null);
	}

	@Test
	public void successAssertSameObject() throws AssertionFailedException {
		Object object = new Float(5);
		assertSame(object, object);
		Assert.assertSame(object, object);
	}

	@Test(expected = AssertionFailedException.class)
	public void failAssertSameObject() throws AssertionFailedException {
		Object object = new Float(5);
		Assert.assertSame(object, null);
	}

	@Test
	public void successAssertNotSameObjectWithPersonalizedMessage()
			throws AssertionFailedException {
		Object object1 = new Float(5);
		Object object2 = new Float(5);
		assertNotSame("JUnit assertNotSame(String, object, object) fails with "
				+ "same object parameters", object1, object2);
		Assert.assertNotSame("Testing Framework assertNotSame(String, object, "
				+ "object) fails with same object parameters", object1, object2);
	}

	@Test(expected = AssertionFailedException.class)
	public void failAssertNotSameObjectWithPersonalizedMessage()
			throws AssertionFailedException {
		Object object = new Float(5);
		Assert.assertNotSame("Testing Framework assertNotSame(String, object,"
				+ " object) throws AssertionFailedException with same object "
				+ "parameters", object, object);
	}

	@Test
	public void successAssertNotSameObject() throws AssertionFailedException {
		Object object1 = new Float(5);
		Object object2 = new Float(5);
		assertNotSame(object1, object2);
		Assert.assertNotSame(object1, object2);
	}

	@Test(expected = AssertionFailedException.class)
	public void failAssertNotSameObject() throws AssertionFailedException {
		Object object = new Float(5);
		Assert.assertNotSame(object, object);
	}

	@Test
	public void successAssertNotEqualsObjectsWithPersonalizedMessage()
			throws AssertionFailedException {
		Object object1 = new Float(5);
		Object object2 = new Float(6);
		Assert.assertNotEquals("Testing Framework assertNotEquals(String, "
				+ "object, object) fails with different parameters", object1,
				object2);
		assertFalse("JUnit assertFalse(String, boolean) fails with different "
				+ "parameters", object1 == object2);
	}

	@Test(expected = AssertionFailedException.class)
	public void failAssertNotEqualsObjectsWithPersonalizedMessage()
			throws AssertionFailedException {
		Object object1 = new Float(5);
		Assert.assertNotEquals("Testing Framework assertNotEquals(String, "
				+ "object, object) throws AssertionFailedException with same "
				+ "parameters", object1, object1);
	}

	@Test
	public void successAssertNotEqualsObjects() throws AssertionFailedException {
		Object object1 = new Float(5);
		Object object2 = new Float(6);
		Assert.assertNotEquals(object1, object2);
		assertFalse(object1 == object2);
	}

	@Test(expected = AssertionFailedException.class)
	public void failAssertNotEqualsObjects() throws AssertionFailedException {
		Object object1 = new Float(5);
		Assert.assertNotEquals(object1, object1);
		assertFalse(object1 == null);
	}

	@Test
	public void successAssertNotEqualsLongWithPersonalizedMessage()
			throws AssertionFailedException {
		long long1 = 5;
		long long2 = 6;
		Assert.assertNotEquals("Testing Framework assertNotEquals(String, "
				+ "long, long) fails with different parameters", long1, long2);
		assertFalse("JUnit assertFalse(String, boolean) fails with different "
				+ "parameters", long1 == long2);
	}

	@Test(expected = AssertionFailedException.class)
	public void failAssertNotEqualsLongWithPersonalizedMessage()
			throws AssertionFailedException {
		long long1 = 5;
		Assert.assertNotEquals("Testing Framework assertNotEquals(String, "
				+ "long, long) throws AssertionFailedException with same "
				+ "parameters", long1, long1);
	}

	@Test
	public void successAssertNotEqualsLong() throws AssertionFailedException {
		long long1 = 5;
		long long2 = 6;
		Assert.assertNotEquals(long1, long2);
		assertFalse(long1 == long2);
	}

	@Test(expected = AssertionFailedException.class)
	public void failAssertNotEqualsLong() throws AssertionFailedException {
		long long1 = 5;
		Assert.assertNotEquals(long1, long1);
	}

	@Test
	public void successAssertNotEqualsFloatWithNonZeroDeltaValueWithPersonalizedMessage()
			throws AssertionFailedException {
		float float1 = 5;
		float float2 = 7;
		float delta = 1;
		Assert.assertNotEquals("Testing Framework assertNotEquals(String, "
				+ "float, float, float) fails with non equal parameters "
				+ "(Considering delta value)", float1, float2, delta);
		assertFalse("JUnit assertFalse(String, condition) fails with non "
				+ "equal parameters (Considering positive delta value)",
				float1 == float2 + delta);
		assertFalse("JUnit assertFalse(String, condition) fails with non "
				+ "equal parameters (Considering negative delta value)",
				float1 == float2 - delta);
	}

	@Test(expected = AssertionFailedException.class)
	public void failAssertNotEqualsFloatWithNonZeroDeltaValueWithPersonalizedMessage()
			throws AssertionFailedException {
		float float1 = 5;
		float float2 = 5;
		float delta = 1;
		Assert.assertNotEquals("Testing Framework assertNotEquals(String, "
				+ "float, float, float) throws AssertionFailedException with "
				+ "equal parameters (Considering delta value)", float1, float2,
				delta);
	}

	@Test
	public void successAssertNotEqualsFloatWithZeroDeltaValueWithPersonalizedMessage()
			throws AssertionFailedException {
		float float1 = 5;
		float float2 = 7;
		float delta = 0;
		Assert.assertNotEquals("Testing Framework assertNotEquals(String, "
				+ "float, float, float) fails with non equal parameters "
				+ "(Considering delta value)", float1, float2, delta);
		assertFalse("JUnit assertFalse(String, condition) fails with non "
				+ "equal parameters (Considering positive delta value)",
				float1 == float2 + delta);
		assertFalse("JUnit assertFalse(String, condition) fails with non "
				+ "equal parameters (Considering negative delta value)",
				float1 == float2 - delta);
	}

	@Test(expected = AssertionFailedException.class)
	public void failAssertNotEqualsFloatWithZeroDeltaValueWithPersonalizedMessage()
			throws AssertionFailedException {
		float float1 = 5;
		float float2 = 5;
		float delta = 0;
		Assert.assertNotEquals("Testing Framework assertNotEquals(String, "
				+ "float, float, float) throws AssertionFailedException with "
				+ "equal parameters (Considering delta value)", float1, float2,
				delta);
	}

	@Test
	public void successAssertNotEqualsFloatWithNonZeroDeltaValue()
			throws AssertionFailedException {
		float float1 = 5;
		float float2 = 7;
		float delta = 1;
		Assert.assertNotEquals(float1, float2, delta);
		assertFalse(float1 == float2 + delta);
		assertFalse(float1 == float2 - delta);
	}

	@Test(expected = AssertionFailedException.class)
	public void failAssertNotEqualsFloatWithNonZeroDeltaValue()
			throws AssertionFailedException {
		float float1 = 5;
		float float2 = 5;
		float delta = 1;
		Assert.assertNotEquals(float1, float2, delta);
	}

	@Test
	public void successAssertNotEqualsFloatWithZeroDeltaValue()
			throws AssertionFailedException {
		float float1 = 5;
		float float2 = 7;
		float delta = 0;
		Assert.assertNotEquals(float1, float2, delta);
		assertFalse(float1 == float2 + delta);
		assertFalse(float1 == float2 - delta);
	}

	@Test(expected = AssertionFailedException.class)
	public void failAssertNotEqualsFloatWithZeroDeltaValue()
			throws AssertionFailedException {
		float float1 = 5;
		float float2 = 5;
		float delta = 0;
		Assert.assertNotEquals(float1, float2, delta);
	}

	@Test
	public void successAssertNotEqualsDoubleWithNonZeroDeltaValueWithPersonalizedMessage()
			throws AssertionFailedException {
		double double1 = 5;
		double double2 = 7;
		double delta = 1;
		Assert.assertNotEquals("Testing Framework assertNotEquals(String, "
				+ "double, double, double) fails with non equal parameters "
				+ "(Considering delta value)", double1, double2, delta);
		assertFalse("JUnit assertFalse(String, condition) fails with non "
				+ "equal parameters (Considering positive delta value)",
				double1 == double2 + delta);
		assertFalse("JUnit assertFalse(String, condition) fails with non "
				+ "equal parameters (Considering negative delta value)",
				double1 == double2 - delta);
	}

	@Test(expected = AssertionFailedException.class)
	public void failAssertNotEqualsDoubleWithNonZeroDeltaValueWithPersonalizedMessage()
			throws AssertionFailedException {
		double double1 = 5;
		double double2 = 5;
		double delta = 1;
		Assert.assertNotEquals("Testing Framework assertNotEquals(String, "
				+ "double, double, double) throws AssertionFailedException "
				+ "with equal parameters (Considering delta value)", double1,
				double2, delta);
	}

	@Test
	public void successAssertNotEqualsDoubleWithZeroDeltaValueWithPersonalizedMessage()
			throws AssertionFailedException {
		double double1 = 5;
		double double2 = 7;
		double delta = 0;
		Assert.assertNotEquals("Testing Framework assertNotEquals(String, "
				+ "double, double, double) fails with non equal parameters "
				+ "(Considering delta value)", double1, double2, delta);
		assertFalse("JUnit assertFalse(String, condition) fails with non "
				+ "equal parameters (Considering positive delta value)",
				double1 == double2 + delta);
		assertFalse("JUnit assertFalse(String, condition) fails with non "
				+ "equal parameters (Considering negative delta value)",
				double1 == double2 - delta);
	}

	@Test(expected = AssertionFailedException.class)
	public void failAssertNotEqualsDoubleWithZeroDeltaValueWithPersonalizedMessage()
			throws AssertionFailedException {
		double double1 = 5;
		double double2 = 5;
		double delta = 0;
		Assert.assertNotEquals("Testing Framework assertNotEquals(String, "
				+ "double, double, double) throws AssertionFailedException "
				+ "with equal parameters (Considering delta value)", double1,
				double2, delta);
	}

	@Test
	public void successAssertNotEqualsDoubleWithNonZeroDeltaValue()
			throws AssertionFailedException {
		double double1 = 5;
		double double2 = 7;
		double delta = 1;
		Assert.assertNotEquals(double1, double2, delta);
		assertFalse(double1 == double2 + delta);
		assertFalse(double1 == double2 - delta);
	}

	@Test(expected = AssertionFailedException.class)
	public void failAssertNotEqualsDoubleWithNonZeroDeltaValue()
			throws AssertionFailedException {
		double double1 = 5;
		double double2 = 5;
		double delta = 1;
		Assert.assertNotEquals(double1, double2, delta);
	}

	@Test
	public void successAssertNotEqualsDoubleWithZeroDeltaValue()
			throws AssertionFailedException {
		double double1 = 5;
		double double2 = 7;
		double delta = 0;
		Assert.assertNotEquals(double1, double2, delta);
		assertFalse(double1 == double2 + delta);
		assertFalse(double1 == double2 - delta);
	}

	@Test(expected = AssertionFailedException.class)
	public void failAssertNotEqualsDoubleWithZeroDeltaValue()
			throws AssertionFailedException {
		double double1 = 5;
		double double2 = 5;
		double delta = 0;
		Assert.assertNotEquals(double1, double2, delta);
	}
}