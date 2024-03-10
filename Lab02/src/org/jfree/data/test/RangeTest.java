package org.jfree.data.test;

import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


import org.jfree.data.Range;


public class RangeTest{
	
	private Range rangeObjectUnderTestRange;

	@Before
	public void setUp() throws Exception {
		rangeObjectUnderTestRange = new Range(-1,1);
	}

	@After
	public void tearDown() throws Exception {
	}

	
	// Test Cases for getCentralValue 
	
	 	@Test
	    public void testGetCentralValueWithPositiveRange() {
	        Range range = new Range(1, 3);
	        double expected = 2.0; 
	        assertEquals("The centeral value of 1 and 3 should be 2", expected, range.getCentralValue(), 0.000000001d);
	    }
	 
	 	@Test
	 	public void testGetCentralValueWithPositiveRangeShouldFail() {
		    Range range = new Range(1, 3);
		    double unexpected = 1.5; 
		    assertNotEquals("The central value of 1 and 3 should not be 1.5", unexpected, range.getCentralValue(), 0.000000001d);
		}

	    @Test
	    public void testGetCentralValueWithNegativeRange() {
	        Range range = new Range(-3, -1);
	        double expected = -2.0; // 
	        assertEquals("The centeral value of -3 and -1 should be -2", expected, range.getCentralValue(), 0.000000001d);
	    }
	    
	    @Test
	    public void testGetCentralValueWithNegativeRangeShouldFail() {
	        Range range = new Range(-3, -1);
	        double unexpected = -1.5; 
	        assertNotEquals("The central value of -3 and -1 should not be -1.5", unexpected, range.getCentralValue(), 0.000000001d);
	    }

	    @Test
	    public void testGetCentralValueWithMixedRange() {
	        Range range = new Range(-1, 1);
	        double expected = 0.0; // 
	        assertEquals("The centeral value of -1 and 1 should be 0", expected, range.getCentralValue(), 0.000000001d);
	    }
	    
	    @Test
	    public void testGetCentralValueWithMixedRangeShouldFail() {
	        Range range = new Range(-1, 1);
	        double unexpected = 0.5; 
	        assertNotEquals("The central value of -1 and 1 should not be 0.5", unexpected, range.getCentralValue(), 0.000000001d);
	    }
	    
	 // Test Cases for getLowerBound
	    
	    @Test
	    public void testGetLowerBoundWithPositiveRange() {
	        Range range = new Range(1, 5);
	        double expectedLower = 1.0;
	        assertEquals("The lower bound value of the range should be 1", expectedLower, range.getLowerBound(), 0.000000001d);
	    }

	    @Test
	    public void testGetLowerBoundWithPositiveRangeShouldFail() {
	        Range range = new Range(1, 5);
	        double unexpectedLower = 2.0;
	        assertNotEquals("The lower bound value of the range should not be 2", unexpectedLower, range.getLowerBound(), 0.000000001d);
	    }
	
	    @Test
	    public void testGetLowerBoundWithNegativeRange() {
	        Range range = new Range(-5, -1);
	        double expectedLower = -5.0;
	        assertEquals("The lower bound value of the range should be -5", expectedLower, range.getLowerBound(), 0.000000001d);
	    }

	    @Test
	    public void testGetLowerBoundWithNegativeRangeShouldFail() {
	        Range range = new Range(-5, -1);
	        double unexpectedLower = -4.0;
	        assertNotEquals("The lower bound value of the range should not be -4", unexpectedLower, range.getLowerBound(), 0.000000001d);
	    }
	    
	    @Test
	    public void testGetLowerBoundWithMixedRange() {
	        Range range = new Range(-1, 1);
	        double expectedLowerBound = -1;
	        assertEquals("The lower bound value of -1 and 1 should be -1", expectedLowerBound, range.getLowerBound(), 0.000000001d);
	    }

	    @Test
	    public void testGetLowerBoundWithMixedRangeShouldFail() {
	        Range range = new Range(-1, 1);
	        double unexpectedLowerBound = -2;
	        assertNotEquals("The lower bound value of -1 and 1 should not be -2", unexpectedLowerBound, range.getLowerBound(), 0.000000001d);
	    }
	    

	 // Test Cases for getUpperBound 
	    
		
		@Test
		public void testGetUpperBoundWithPositiveRange() {
		    Range range = new Range(1, 5);
		    double expectedUpper = 5;
		    System.out.println("testGetUpperBoundWithPositiveRange result " + range.getUpperBound());
		    assertEquals("The upper bound value of the range should be 5", expectedUpper, range.getUpperBound(), 0.000000001d);
		}
		
		@Test
		public void testGetUpperBoundWithPositiveRangeShouldFail() {
		    Range range = new Range(1, 5);
		    double unexpectedUpper = 4.0;
		    assertNotEquals("The upper bound value  of the range should not be 4", unexpectedUpper, range.getUpperBound(), 0.000000001d);
		}
		
		@Test
		public void testGetUpperBoundWithNegativeRange() {
		    Range range = new Range(-5, -1);
		    double expectedUpper = -1.0;
		    System.out.println("testGetUpperBoundWithPositiveRange result " + range.getUpperBound());
		    assertEquals("The upper bound value of the range should be -1", expectedUpper, range.getUpperBound(), 0.000000001d);
		}

		@Test
		public void testGetUpperBoundWithNegativeRangeShouldFail() {
		    Range range = new Range(-5, -1);
		    double unexpectedUpper = -2.0;
		    assertNotEquals("The upper bound value of the range should not be -2", unexpectedUpper, range.getUpperBound(), 0.000000001d);
		}

	    @Test
	    public void testGetUpperBoundWithMixedRange() {
	        Range range = new Range(-1, 1);
	        double expectedUpperBound = 1;
	        System.out.println("testGetUpperBoundWithMixedRange result " + range.getUpperBound());
	        assertEquals("The upper bound value of -1 and 1 should be 1", expectedUpperBound, range.getUpperBound(), 0.000000001d);
	    }

	    @Test
	    public void testGetUpperBoundWithMixedRangeShouldFail() {
	        Range range = new Range(-1, 1);
	        double unexpectedUpperBound = 2;
	        assertNotEquals("The upper bound value of -1 and 1 should not be 2", unexpectedUpperBound, range.getUpperBound(), 0.000000001d);
	    }
	    
	 // Test Cases for Intersects 
	    @Test
	    public void testIntersectsPositiveRange() {
	        Range baseRange = new Range(1, 5);
	        Range intersectingRange = new Range(3, 7);
	        Assert.assertTrue("The ranges should intersect", 
	            baseRange.intersects(intersectingRange.getLowerBound(), intersectingRange.getUpperBound()));
	    }

	    @Test
	    public void testDoesNotIntersectPositiveRange() {
	        Range baseRange = new Range(1, 5);
	        Range nonIntersectingRange = new Range(6, 10);
	        Assert.assertFalse("The ranges should not intersect", 
	            baseRange.intersects(nonIntersectingRange.getLowerBound(), nonIntersectingRange.getUpperBound()));
	    }
	    
	    @Test
	    public void testIntersectsNegativeRange() {
	        Range baseRange = new Range(-5, -1);
	        Range intersectingRange = new Range(-4, -2);
	        Assert.assertTrue("The ranges should intersect", 
	            baseRange.intersects(intersectingRange.getLowerBound(), intersectingRange.getUpperBound()));
	    }

	    @Test
	    public void testDoesNotIntersectNegativeRange() {
	        Range baseRange = new Range(-5, -1);
	        Range nonIntersectingRange = new Range(-10, -6);
	        System.out.println("testDoesNotIntersectNegativeRange result " + nonIntersectingRange.getLowerBound() + nonIntersectingRange.getUpperBound());
	        Assert.assertFalse("The ranges should not intersect", 
	            baseRange.intersects(nonIntersectingRange.getLowerBound(), nonIntersectingRange.getUpperBound()));
	    }
	    
	    @Test
	    public void testIntersectsMixedRange() {
	        Range baseRange = new Range(-3, 3);
	        Range intersectingRange = new Range(-2, 2);
	        Assert.assertTrue("The ranges should intersect", 
	            baseRange.intersects(intersectingRange.getLowerBound(), intersectingRange.getUpperBound()));
	    }

	    @Test
	    public void testDoesNotIntersectMixedRange() {
	        Range baseRange = new Range(-3, 3);
	        Range nonIntersectingRange = new Range(4, 8);
	        Assert.assertFalse("The ranges should not intersect", 
	            baseRange.intersects(nonIntersectingRange.getLowerBound(), nonIntersectingRange.getUpperBound()));
	    }
	    
	 // Test Cases for Expand to Include 
	    
	    @Test
	    public void testExpandToIncludePositiveRange() {
	        Range range = new Range(1, 5);
	        double valueToInclude = 10;
	        Range expandedRange = Range.expandToInclude(range, valueToInclude);
	        Assert.assertEquals("The upper bound should be expanded to include 10", valueToInclude, expandedRange.getUpperBound(), 0.000000001d);
	        Assert.assertEquals("The lower bound should remain the same", 1, expandedRange.getLowerBound(), 0.000000001d);
	    }

	    @Test
	    public void testExpandToIncludeNegativeRange() {
	        Range range = new Range(-5, -1);
	        double valueToInclude = -10;
	        Range expandedRange = Range.expandToInclude(range, valueToInclude);
	        Assert.assertEquals("The lower bound should be expanded to include -10", valueToInclude, expandedRange.getLowerBound(), 0.000000001d);
	        Assert.assertEquals("The upper bound should remain the same", -1, expandedRange.getUpperBound(), 0.000000001d);
	    }

	    @Test
	    public void testExpandToIncludeMixedRange() {
	        Range range = new Range(-3, 3);
	        double valueToInclude = 5;
	        Range expandedRange = Range.expandToInclude(range, valueToInclude);
	        Assert.assertEquals("The upper bound should be expanded to include 5", valueToInclude, expandedRange.getUpperBound(), 0.000000001d);
	        Assert.assertEquals("The lower bound should remain the same", -3, expandedRange.getLowerBound(), 0.000000001d);
	    }
	    
	    @Test
	    public void testExpandToIncludeValueAlreadyInPositiveRange() {
	        Range range = new Range(1, 5);
	        double valueToInclude = 3;
	        Range expandedRange = Range.expandToInclude(range, valueToInclude);
	        Assert.assertEquals("The upper bound should remain the same when including 3", 5, expandedRange.getUpperBound(), 0.000000001d);
	        Assert.assertEquals("The lower bound should remain the same when including 3", 1, expandedRange.getLowerBound(), 0.000000001d);
	    }
	    
	    
	}


