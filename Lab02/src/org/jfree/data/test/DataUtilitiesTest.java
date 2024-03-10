package org.jfree.data.test;

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
}
