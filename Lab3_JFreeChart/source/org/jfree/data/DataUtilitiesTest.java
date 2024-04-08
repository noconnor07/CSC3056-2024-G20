package org.jfree.data;

import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues2D;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class DataUtilitiesTest {

	private Values2D values2D;
	private double[][] doubleArray2D;

	@Before
	public void setUp() {
		// Initialising test data structures
		values2D = new DefaultKeyedValues2D();
		((DefaultKeyedValues2D) values2D).addValue(1, "Row1", "Column1");
		((DefaultKeyedValues2D) values2D).addValue(2, "Row2", "Column1");
		((DefaultKeyedValues2D) values2D).addValue(3, "Row1", "Column2");
		((DefaultKeyedValues2D) values2D).addValue(4, "Row2", "Column2");

		doubleArray2D = new double[][] { { 1.0, 2.0 }, { 3.0, 4.0 } };
	}

	@After
	public void tearDown() throws Exception {
		values2D = null;
		doubleArray2D = null;
	}

	// Test cases for calculateColumnTotal(Values2D data, int column) method

	// Tests method with valid inputs
	@Test
	public void testCalculateColumnTotal_ValidDataValidColumn() {
		double result = DataUtilities.calculateColumnTotal(values2D, 0);
		Assert.assertEquals("Valid data with valid column index should return correct total", 3.0, result, 0.0001d);
	}

	// Testing calculateColumnTotal with a column index exceeding the data range
	@Test(expected = IndexOutOfBoundsException.class)
	public void testCalculateColumnTotal_ValidDataInvalidColumn_Exceeding() {
		DataUtilities.calculateColumnTotal(values2D, 2); // Exceeding column index
	}

	// Test for valid data and negative column index
	@Test(expected = IndexOutOfBoundsException.class)
	public void testCalculateColumnTotal_ValidDataInvalidColumn_Negative() {
		DataUtilities.calculateColumnTotal(values2D, -1); // This should throw IndexOutOfBoundsException
	}

	// Tests mixed positive and negative values input
	@Test
	public void testCalculateColumnTotal_MixedValues() {
		DefaultKeyedValues2D mixedData = new DefaultKeyedValues2D();
		mixedData.addValue(10.0, "Row1", "Column1");
		mixedData.addValue(-5.0, "Row2", "Column1");
		mixedData.addValue(3.0, "Row3", "Column1");
		mixedData.addValue(-2.0, "Row4", "Column1");
		double result = DataUtilities.calculateColumnTotal(mixedData, 0);
		Assert.assertEquals("Column total with mixed positive and negative values should be correct", 6.0, result,
				0.0001d);
	}

	@Test
	public void testCalculateColumnTotal_WithMaxValue() {
		DefaultKeyedValues2D data = new DefaultKeyedValues2D();
		data.addValue(Double.MAX_VALUE, "Row1", "Column1");
		data.addValue(Double.MAX_VALUE, "Row2", "Column1");
		double result = DataUtilities.calculateColumnTotal(data, 0);
		Assert.assertEquals("Column total should handle Double.MAX_VALUE without overflow", Double.POSITIVE_INFINITY,
				result, 0.0d);
	}

	@Test
	public void testCalculateColumnTotal_WithLargeNegative() {
		DefaultKeyedValues2D data = new DefaultKeyedValues2D();
		data.addValue(-Double.MAX_VALUE, "Row1", "Column1");
		data.addValue(-Double.MAX_VALUE, "Row2", "Column1");
		double result = DataUtilities.calculateColumnTotal(data, 0);
		Assert.assertEquals("Column total should handle large negative values without underflow",
				-Double.POSITIVE_INFINITY, result, 0.0d);
	}

	// Test for calculateColumnTotal with empty dataset
	@Test
	public void testCalculateColumnTotal_EmptyDataset() {
		Values2D emptyData = new DefaultKeyedValues2D();
		// Attempting to calculate the total of an empty column
		double result = DataUtilities.calculateColumnTotal(emptyData, 0);
		Assert.assertEquals("Column total of an empty dataset should be 0.0", 0.0, result, 0.0001d);
	}

	// Test cases for calculateRowTotal(Values2D data, int row) method

	// Test for valid data and valid row index
	@Test
	public void testCalculateRowTotal_ValidDataValidRow() {
		double result = DataUtilities.calculateRowTotal(values2D, 0);
		Assert.assertEquals("Row total should match expected result", 4.0, result, 0.0001d);
	}

	// Testing calculateRowTotal with a row index exceeding the data range
	@Test(expected = IndexOutOfBoundsException.class)
	public void testCalculateRowTotal_ValidDataInvalidRow_Exceeding() {
		DataUtilities.calculateRowTotal(values2D, 2); // Should throw IndexOutOfBoundsException
	}

	// Testing calculateRowTotal with a negative row index
	@Test(expected = IndexOutOfBoundsException.class)
	public void testCalculateRowTotal_ValidDataInvalidRow_Negative() {
		DataUtilities.calculateRowTotal(values2D, -1); // Should throw IndexOutOfBoundsException
	}

	// Test method with mixed positive and negative values
	@Test
	public void testCalculateRowTotal_MixedValues() {
		DefaultKeyedValues2D mixedData = new DefaultKeyedValues2D();
		mixedData.addValue(5.0, "Row1", "Column1");
		mixedData.addValue(-1.0, "Row1", "Column2");
		mixedData.addValue(4.0, "Row1", "Column3");
		mixedData.addValue(-3.0, "Row1", "Column4");
		double result = DataUtilities.calculateRowTotal(mixedData, 0);
		Assert.assertEquals("Row total with mixed positive and negative values should be correct", 5.0, result,
				0.0001d);
	}

	@Test
	public void testCalculateRowTotal_WithMinValue() {
		DefaultKeyedValues2D data = new DefaultKeyedValues2D();
		data.addValue(Double.MIN_VALUE, "Row1", "Column1");
		data.addValue(Double.MIN_VALUE, "Row1", "Column2");
		double result = DataUtilities.calculateRowTotal(data, 0);
		Assert.assertEquals("Row total should handle Double.MIN_VALUE correctly", Double.MIN_VALUE * 2, result, 0.0d);
	}

	// Testing calculateRowTotal with empty dataset
	@Test
	public void testCalculateRowTotal_EmptyDataset() {
		Values2D emptyData = new DefaultKeyedValues2D();
		// Attempting to calculate the total of an empty row
		double result = DataUtilities.calculateRowTotal(emptyData, 0);
		Assert.assertEquals("Row total of an empty dataset should be 0.0", 0.0, result, 0.0001d);
	}

	// Test cases for createNumberArray(double[] data) method

	// Testing method with valid data
	@Test
	public void testCreateNumberArray_ValidData() {
		// Test for valid double array
		Number[] result = DataUtilities.createNumberArray(new double[] { 1.0, 2.0, 3.0 });
		Assert.assertArrayEquals("The result array should match the expected Number array",
				new Number[] { 1.0, 2.0, 3.0 }, result);
	}

	// Testing createNumberArray with null input array
	@Test(expected = IllegalArgumentException.class)
	public void testCreateNumberArray_NullData() {
		DataUtilities.createNumberArray(null); // Should throw IllegalArgumentException
	}

	// Test cases for createNumberArray2D(double[][] data)

	// Test for valid 2D double array
	@Test
	public void testCreateNumberArray2D_ValidData() {
		Number[][] result = DataUtilities.createNumberArray2D(doubleArray2D);
		Number[][] expected = new Number[][] { { 1.0, 2.0 }, { 3.0, 4.0 } };
		Assert.assertArrayEquals("The result 2D array should match the expected 2D Number array", expected, result);
	}

	// Testing createNumberArray2D with null data
	@Test(expected = IllegalArgumentException.class)
	public void testCreateNumberArray2D_NullData() {
		DataUtilities.createNumberArray2D(null); // Should throw IllegalArgumentException
	}

	// Testing createNumberArray2D with an empty 2D array
	@Test
	public void testCreateNumberArray2D_EmptyArray() {
		double[][] emptyArray2D = new double[][] {};
		Number[][] result = DataUtilities.createNumberArray2D(emptyArray2D);
		Assert.assertNotNull("Resulting 2D Number array should not be null", result);
		Assert.assertEquals("2D Number array created from an empty 2D double array should be empty", 0, result.length);
	}

	// Test cases for getCumulativePercentages(KeyedValues data)
	// Test for valid KeyedValues data
	@Test
	public void testGetCumulativePercentages_ValidData() {
		DefaultKeyedValues data = new DefaultKeyedValues();
		data.addValue("Key1", Double.valueOf(1)); // Use Double.valueOf to avoid deprecated constructor
		data.addValue("Key2", Double.valueOf(2)); // Use Double.valueOf to avoid deprecated constructor
		KeyedValues result = DataUtilities.getCumulativePercentages(data);
		Assert.assertEquals("Cumulative percentage for Key1 should match expected result", 0.3333,
				result.getValue("Key1").doubleValue(), 0.0001d);
		Assert.assertEquals("Cumulative percentage for Key2 should match expected result", 1.0,
				result.getValue("Key2").doubleValue(), 0.0001d);
	}

	// Test for null KeyedValues data
	@Test(expected = IllegalArgumentException.class)
	public void testGetCumulativePercentages_NullData() {
		DataUtilities.getCumulativePercentages(null);// Should throw IllegalArgumentException
	}

	// Test for empty KeyedValues object
	@Test
	public void testGetCumulativePercentages_EmptyKeyedValues() {
		KeyedValues emptyData = new DefaultKeyedValues();
		KeyedValues result = DataUtilities.getCumulativePercentages(emptyData);
		Assert.assertNotNull("Resulting KeyedValues should not be null", result);
		Assert.assertEquals("Cumulative percentages of an empty KeyedValues should be empty", 0, result.getItemCount());
	}
	
	// Lab3
	// Added test cases with white-box testing techniques to improve branch coverage
	
	// WB TC1
	// Method under test: getCumulativePercentages(KeyedValues)
	// This test case has been extended to address the handling of null vales
	// Before, I tested with a single null value, but due to branch coverage not being 100%,
	// I designed this test case to include null values in various positions within the dataset
	// and combine them with positive, negative and zero values
	
	@Test
	public void testGetCumulativePercentages_WithNullValue() {
	    // Initialise the KeyedValues dataset
	    DefaultKeyedValues data = new DefaultKeyedValues();
	    
	    // Adding various values, including nulls at different positions
	    data.addValue("Key1", 5.0); // Positive value
	    data.addValue("Key2", null); // Null value
	    data.addValue("Key3", -5.0); // Negative value
	    data.addValue("Key4", 0.0); // Zero value
	    data.addValue("Key5", null); // Another null value
	    data.addValue("Key6", 10.0); // Another positive value
	    
	    // Execute the method under test
	    KeyedValues result = DataUtilities.getCumulativePercentages(data);
	    
	    // Assertions
	    Assert.assertNotNull("Resulting KeyedValues should not be null", result);
	    
	    // Check specific expected behaviors:
	    // Assert cumulative percentages, accounting for how nulls are expected to be treated 
	    // Here it's assumed nulls are ignored in the cumulative calculation
	    double total = 10.0; 
	    Assert.assertEquals("Cumulative percentage for Key1 incorrect", 5.0 / total, result.getValue("Key1").doubleValue(), 0.0001d);
	    Assert.assertNull("Cumulative percentage for Key2 (null) should be handled appropriately", result.getValue("Key2"));
	    Assert.assertEquals("Cumulative percentage for Key3 incorrect", (5.0 - 5.0) / total, result.getValue("Key3").doubleValue(), 0.0001d);
	    Assert.assertEquals("Cumulative percentage for Key4 incorrect", (5.0 - 5.0) / total, result.getValue("Key4").doubleValue(), 0.0001d);
	    Assert.assertNull("Cumulative percentage for Key5 (null) should be handled appropriately", result.getValue("Key5"));
	    Assert.assertEquals("Cumulative percentage for Key6 incorrect", 1.0, result.getValue("Key6").doubleValue(), 0.0001d);
	}
	

	// WB TC2
	// Method under test: calculateColumnTotal(Values2D, int) 
	
	@Test
	public void testCalculateColumnTotal_WithNullValues() {
	    // Create a new dataset with a specific column having null values
	    DefaultKeyedValues2D dataWithNulls = new DefaultKeyedValues2D();
	    dataWithNulls.addValue(10.0, "Row1", "Column1");
	    dataWithNulls.addValue(null, "Row2", "Column1"); // Explicit null value
	    dataWithNulls.addValue(20.0, "Row3", "Column1");
	    
	    // Calculate the column total for the column with mixed null and non-null values
	    double result = DataUtilities.calculateColumnTotal(dataWithNulls, 0);
	    
	    // Assert that the total is correct, ignoring the null value
	    Assert.assertEquals("Column total should correctly ignore null values and sum others", 30.0, result, 0.0001d);
	}

	// WB TC3
	// Method under test: CalculateRowTotal(Values2D, int) 
	@Test
	public void testCalculateRowTotal_WithNullValues() {
	    // Create a new dataset with specific rows having null values among non-null values
	    DefaultKeyedValues2D dataWithNulls = new DefaultKeyedValues2D();
	    dataWithNulls.addValue(15.0, "Row1", "Column1");
	    dataWithNulls.addValue(null, "Row1", "Column2"); // Explicit null value in the row
	    dataWithNulls.addValue(25.0, "Row1", "Column3");
	    
	    // Calculate the row total for the row with mixed null and non-null values
	    double result = DataUtilities.calculateRowTotal(dataWithNulls, 0);
	    
	    // Assert that the total is correct, ignoring the null value
	    Assert.assertEquals("Row total should correctly ignore null values and sum others", 40.0, result, 0.0001d);
	}

	// WB TC4
	// Method under test: createNumberArray2D(double[][])
	// This tests how the createNumberArray2D method handles non-uniform arrays
	@Test
	public void testCreateNumberArray2D_NonUniformArrays() {
	    double[][] nonUniformArray2D = new double[][] { { 1.0 }, { 2.0, 3.0 }, { 4.0, 5.0, 6.0 } };
	    Number[][] result = DataUtilities.createNumberArray2D(nonUniformArray2D);
	    
	    // The non-uniform structure of the input should match the expected result
	    Number[][] expected = new Number[][] { { 1.0 }, { 2.0, 3.0 }, { 4.0, 5.0, 6.0 } };
	    Assert.assertNotNull("Resulting 2D number array should not be null", result);
	    Assert.assertEquals("Number of rows should match", nonUniformArray2D.length, result.length);
	    
	    // Asserts that each row of the resulting Number[][] matches the expected values
	    for (int i = 0; i < result.length; i++) {
	        Assert.assertArrayEquals("Row " + i + " should match the expected values", expected[i], result[i]);
	    }
	}

	// WB TC5
	// Method under test: createNumberArray(double[])
	/* This tests the method's ability to handle extreme boundary values
	* This test will check if the method can accurately convert the smallest and largest posible double values
	* into a Number object without loss of precision, overflow or underflow errors.
	*/
	@Test
	public void testCreateNumberArray_WithExtremeValues() {
	    // Input is an array with the smallest and largest double values
	    double[] extremeValues = { Double.MIN_VALUE, Double.MAX_VALUE };
	    
	    Number[] numberArray = DataUtilities.createNumberArray(extremeValues);
	    
	    // The resulting number array should accurately reflect the extreme values
	    Assert.assertNotNull("The resulting number array should not be null", numberArray);
	    Assert.assertEquals("The resulting number array should have the same length as the input array",
	                        extremeValues.length, numberArray.length);
	    Assert.assertEquals("The first element should be Double.MIN_VALUE",
	                        Double.MIN_VALUE, numberArray[0].doubleValue(), 0.0d);
	    Assert.assertEquals("The second element should be Double.MAX_VALUE",
	                        Double.MAX_VALUE, numberArray[1].doubleValue(), 0.0d);
	}
	
}

// completed
