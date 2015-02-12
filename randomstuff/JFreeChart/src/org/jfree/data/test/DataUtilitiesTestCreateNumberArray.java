package org.jfree.data.test;

import org.junit.*;
import org.jfree.data.DataUtilities;

import junit.framework.TestCase;

public class DataUtilitiesTestCreateNumberArray extends TestCase {
	
	public DataUtilitiesTestCreateNumberArray(String name) {
		super(name);
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
	public void testValidInitializedInput(){
		double [] input = {9.3,0.4,1,4,5.5};
		Number [] expected = {9.3,0.4,1,4,5.5};
		Number [] output = DataUtilities.createNumberArray(input);
		
		Boolean result = true;		
		for(int i = 0; (i < output.length) && result; i++){
			
			// the method CreatNumebrArray did not copy the last element of the input array
			if(output[i] == null){
				result = false;
				break;
			}
			// comparing elements of the output array and the expected array
			if(output[i].doubleValue() != expected[i].doubleValue()){
				result = false;
			}
		}
		// Result expected to be false, because the method does not 
		// copy the last element of the input argument.
		assertFalse("Test valid input", result);	
	}
}
