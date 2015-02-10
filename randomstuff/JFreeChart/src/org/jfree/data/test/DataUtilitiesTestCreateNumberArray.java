package org.jfree.data.test;

import org.jfree.data.DataUtilities;
import org.jmock.Mockery;

import junit.framework.TestCase;

public class DataUtilitiesTestCreateNumberArray extends TestCase {

	private Mockery mockery;
	
	public DataUtilitiesTestCreateNumberArray(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	
	public void testValidInitializedInput(){
//		mockery = new Mockery();
		double [] input = {9.3,0.4};
		Number [] expected = {9.3,0.4,1,4,5.5};
		Number [] output = DataUtilities.createNumberArray(input);
		
		Boolean result = false;		
		for(int i = 0; (i < output.length) && !result; i++){
					
//			if(output[i].doubleValue() != expected[i].doubleValue()){
//				result = false;
//			}
			System.out.println(output[i]);
		}
		
		assertTrue("Test valid input", result);	
	}
	
	public void testInvalidInput(){
		int [] input = {3,2,4,1};
		Number [] expected = {3.2};
		Number [] output = DataUtilities.createNumberArray(input);
	}
	
	public void testNullInput(){
		double [] input ;
			Number [] output = DataUtilities.createNumberArray(input);
		
	}
}
