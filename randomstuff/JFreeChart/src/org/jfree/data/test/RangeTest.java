package org.jfree.data.test;

import org.junit.*;
import org.jfree.data.Range;
import junit.framework.TestCase;


public class RangeTest extends TestCase {

	private Range nonNullrange;
	private Range Nullrange;
	private double testValue;
	
	public RangeTest(String name) {
		super(name);
	}
	
	@Before
	protected void setUp() throws Exception {
		nonNullrange = new Range (4,12);
		Nullrange = new Range (0,0);
	}

	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testValueInsideRange(){
		testValue = 6.4;
		assertEquals("Test value inside range",testValue, nonNullrange.constrain(testValue));
	}
	
	@Test
	public void testValueAboveRange(){
		testValue = 20;
		assertEquals("Test value above range", (double) 12 , nonNullrange.constrain(testValue));
	}
}
