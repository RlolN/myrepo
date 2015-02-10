package org.jfree.data.test;

import junit.framework.TestCase;

import org.junit.*;
import org.jfree.data.Range;

public class RangeTestContains extends TestCase {

	private Range range;
	private double testValue;
	
	public RangeTestContains(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		range = new Range(-1, 10);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
}

	
	public void testNullValue(){
		assertTrue("Null value test within range", range.contains(testValue));
	}
	
	public void testAboveRange(){
		testValue = 999;
		assertFalse("Value (Large number) above range", range.contains(testValue));
	}
	
	public void testBelowRange(){
		testValue = -10;
		assertFalse("Value below range", range.contains(testValue));
	}
	
	public void testValueAtUpperBound(){
		testValue = 10;
		assertTrue("Value at upper bound", range.contains(testValue));
	}
	
	public void testValueAtLowerBound(){
		testValue = -1;
		assertTrue("Value at lower bound", range.contains(testValue));
	}
	
	
}
