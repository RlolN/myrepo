package org.jfree.data.test;


import org.junit.*;
import org.jfree.data.Range;

import junit.framework.TestCase;

public class RangeTestCombine extends TestCase {

	private Range range1;
	private Range range2 ;
	private Range range3 ;
	private Range range4 ;
	

	private Range NullRange1 = null;
	private Range NullRange2 = null;
	
	private Range expect;

	
	public RangeTestCombine(String name) {
		super(name);
	} 	
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception{
		
	}
	
	@Before
	protected void setUp() throws Exception {
		  range1 = new Range (0,5);
		  range2 = new Range (4,10);
		  range3 = new Range (1,2);
		  range4 = new Range (3,4);
	}
	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	/**
	 * Testing the Combine method
	 * the 2nd argument needs to be smaller than the 1st argument 
	 */
	
	@Test
	public void testTwoDisjoinRangesFirstTest(){
		expect = new Range(1,4);
		// Assertion failed, it requires the lower bound of the 2nd arg to be <= the lower bound of the 1st arg.
		assertEquals("Combining two disjoin ranges Test 1", expect, Range.combine(range3,range4));
	}
	
	@Test
	public void testTwoDisjoinRangesSecondTest(){
		expect = new Range(1,4);
		assertEquals("Combining two disjoin ranges Test 2", expect, Range.combine(range4,range3));
	}
	
	@Test
	public void testNullRangeAndNonNullRange(){
		expect = range1;
		assertEquals("Null Range Combines with Non-NullRange Test 1 ", expect ,Range.combine(NullRange2, range1));
		assertEquals("Null Range Combines with Non-NullRange Test 2 ", expect ,Range.combine(range1, NullRange2));	
	}
	
	@Test 
	public void testTwoNullRanges(){
//		assertEquals("Two Null Ranges Combine Test", new Range(0,0),Range.combine(NullRange1, NullRange2));
		assertNull("Two Null Ranges Combine Test", Range.combine(NullRange1,NullRange2));
	}
	
	
	@Test
	public void testTwoRangesInteract(){
		expect = new Range(0,10);
		assertEquals("Two Ranges interact Combine Test",expect ,Range.combine(range2,range1));
	}

	@Test
	public void testOneRangeInsideanotherRange(){
		expect = range1;
		assertEquals("One range is inside another range",expect, Range.combine(range4,range1));
	}
	
	@Test
	public void testTwoRangesAreContiguous(){
		expect = new Range(3,10);
		assertEquals("Two Ranges are Contiguous", expect, Range.combine(range2,range4));
		
	}
	
}