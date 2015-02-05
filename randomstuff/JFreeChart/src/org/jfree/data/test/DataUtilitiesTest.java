package org.jfree.data.test;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.*;

import junit.framework.TestCase;

public class DataUtilitiesTest extends TestCase {

	public DataUtilitiesTest(String name) {
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
		super.setUp();
	}
	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	@Test
	public void testcalculateColumnTotalForTwoValue(){
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations(){
			{
			one(values).getRowCount();
			will(returnValue(2));
			one(values).getValue(0,0);
			will(returnValue(7.5));
			one(values).getValue(1,0);
			will(returnValue(2.5));	
			}
		});
		double result = DataUtilities.calculateColumnTotal(values,0);
		
		assertEquals(result,10.0,.000000001d);
	}
	

}
