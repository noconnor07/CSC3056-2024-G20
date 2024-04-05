package org.jfree.data;

import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;


public class RangeTest{
	
//	private Range rangeObjectUnderTestRange;

	@Before
	public void setUp() throws Exception {
//		rangeObjectUnderTestRange = new Range(-1,1);
	}

	@After
	public void tearDown() throws Exception {
	}

	
	// Test Cases for getCentralValue 
		
		// TC1
	 	@Test
	    public void testGetCentralValueWithPositiveRange() {
	        Range range = new Range(1, 3);
	        double expected = 2.0; 
	        assertEquals("The centeral value of 1 and 3 should be 2", expected, range.getCentralValue(), 0.000000001d);
	    }
	 
	 	// TC2
	 	@Test
	 	public void testGetCentralValueWithPositiveRangeShouldFail() {
		    Range range = new Range(1, 3);
		    double unexpected = 1.5; 
		    assertNotEquals("The central value of 1 and 3 should not be 1.5", unexpected, range.getCentralValue(), 0.000000001d);
		}

	 	// TC3
	    @Test
	    public void testGetCentralValueWithNegativeRange() {
	        Range range = new Range(-3, -1);
	        double expected = -2.0; // 
	        assertEquals("The centeral value of -3 and -1 should be -2", expected, range.getCentralValue(), 0.000000001d);
	    }
	    
	    // TC4
	    @Test
	    public void testGetCentralValueWithNegativeRangeShouldFail() {
	        Range range = new Range(-3, -1);
	        double unexpected = -1.5; 
	        assertNotEquals("The central value of -3 and -1 should not be -1.5", unexpected, range.getCentralValue(), 0.000000001d);
	    }

	    // TC5
	    @Test
	    public void testGetCentralValueWithMixedRange() {
	        Range range = new Range(-1, 1);
	        double expected = 0.0; // 
	        assertEquals("The centeral value of -1 and 1 should be 0", expected, range.getCentralValue(), 0.000000001d);
	    }
	    
	    // TC6
	    @Test
	    public void testGetCentralValueWithMixedRangeShouldFail() {
	        Range range = new Range(-1, 1);
	        double unexpected = 0.5; 
	        assertNotEquals("The central value of -1 and 1 should not be 0.5", unexpected, range.getCentralValue(), 0.000000001d);
	    }
	    
	 // Test Cases for getLowerBound
	    
	    // TC1
	    @Test
	    public void testGetLowerBoundWithPositiveRange() {
	        Range range = new Range(1, 5);
	        double expectedLower = 1.0;
	        assertEquals("The lower bound value of the range should be 1", expectedLower, range.getLowerBound(), 0.000000001d);
	    }

	    // TC2
	    @Test
	    public void testGetLowerBoundWithPositiveRangeShouldFail() {
	        Range range = new Range(1, 5);
	        double unexpectedLower = 2.0;
	        assertNotEquals("The lower bound value of the range should not be 2", unexpectedLower, range.getLowerBound(), 0.000000001d);
	    }
	
	    // TC3
	    @Test
	    public void testGetLowerBoundWithNegativeRange() {
	        Range range = new Range(-5, -1);
	        double expectedLower = -5.0;
	        assertEquals("The lower bound value of the range should be -5", expectedLower, range.getLowerBound(), 0.000000001d);
	    }

	    // TC4
	    @Test
	    public void testGetLowerBoundWithNegativeRangeShouldFail() {
	        Range range = new Range(-5, -1);
	        double unexpectedLower = -4.0;
	        assertNotEquals("The lower bound value of the range should not be -4", unexpectedLower, range.getLowerBound(), 0.000000001d);
	    }
	    
	    // TC5
	    @Test
	    public void testGetLowerBoundWithMixedRange() {
	        Range range = new Range(-1, 1);
	        double expectedLowerBound = -1;
	        assertEquals("The lower bound value of -1 and 1 should be -1", expectedLowerBound, range.getLowerBound(), 0.000000001d);
	    }

	    // TC6
	    @Test
	    public void testGetLowerBoundWithMixedRangeShouldFail() {
	        Range range = new Range(-1, 1);
	        double unexpectedLowerBound = -2;
	        assertNotEquals("The lower bound value of -1 and 1 should not be -2", unexpectedLowerBound, range.getLowerBound(), 0.000000001d);
	    }
	    

	 // Test Cases for getUpperBound 
	    
	    // TC1
		@Test
		public void testGetUpperBoundWithPositiveRange() {
		    Range range = new Range(1, 5);
		    double expectedUpper = 5;
		   // System.out.println("testGetUpperBoundWithPositiveRange result " + range.getUpperBound());
		    assertEquals("The upper bound value of the range should be 5", expectedUpper, range.getUpperBound(), 0.000000001d);
		}
		
		// TC2
		@Test
		public void testGetUpperBoundWithPositiveRangeShouldFail() {
		    Range range = new Range(1, 5);
		    double unexpectedUpper = 4.0;
		    assertNotEquals("The upper bound value  of the range should not be 4", unexpectedUpper, range.getUpperBound(), 0.000000001d);
		}
		
		// TC3
		@Test
		public void testGetUpperBoundWithNegativeRange() {
		    Range range = new Range(-5, -1);
		    double expectedUpper = -1.0;
		   // System.out.println("testGetUpperBoundWithPositiveRange result " + range.getUpperBound());
		    assertEquals("The upper bound value of the range should be -1", expectedUpper, range.getUpperBound(), 0.000000001d);
		}

		// TC4
		@Test
		public void testGetUpperBoundWithNegativeRangeShouldFail() {
		    Range range = new Range(-5, -1);
		    double unexpectedUpper = -2.0;
		    assertNotEquals("The upper bound value of the range should not be -2", unexpectedUpper, range.getUpperBound(), 0.000000001d);
		}

		// TC5
	    @Test
	    public void testGetUpperBoundWithMixedRange() {
	        Range range = new Range(-1, 1);
	        double expectedUpperBound = 1;
	       // System.out.println("testGetUpperBoundWithMixedRange result " + range.getUpperBound());
	        assertEquals("The upper bound value of -1 and 1 should be 1", expectedUpperBound, range.getUpperBound(), 0.000000001d);
	    }

	    // TC6
	    @Test
	    public void testGetUpperBoundWithMixedRangeShouldFail() {
	        Range range = new Range(-1, 1);
	        double unexpectedUpperBound = 2;
	        assertNotEquals("The upper bound value of -1 and 1 should not be 2", unexpectedUpperBound, range.getUpperBound(), 0.000000001d);
	    }
	    
	 // Test Cases for Intersects 
	    
	    // TC1
	    @Test
	    public void testIntersectsPositiveRange() {
	        Range baseRange = new Range(1, 5);
	        Range intersectingRange = new Range(3, 7);
	        Assert.assertTrue("The ranges should intersect", 
	            baseRange.intersects(intersectingRange.getLowerBound(), intersectingRange.getUpperBound()));
	    }

	    // TC2
	    @Test
	    public void testDoesNotIntersectPositiveRange() {
	        Range baseRange = new Range(1, 5);
	        Range nonIntersectingRange = new Range(6, 10);
	        Assert.assertFalse("The ranges should not intersect", 
	            baseRange.intersects(nonIntersectingRange.getLowerBound(), nonIntersectingRange.getUpperBound()));
	    }
	    
	    // TC3
	    @Test
	    public void testIntersectsNegativeRange() {
	        Range baseRange = new Range(-5, -1);
	        Range intersectingRange = new Range(-4, -2);
	        Assert.assertTrue("The ranges should intersect", 
	            baseRange.intersects(intersectingRange.getLowerBound(), intersectingRange.getUpperBound()));
	    }

	    // TC4
	    @Test
	    public void testDoesNotIntersectNegativeRange() {
	        Range baseRange = new Range(-5, -1);
	        Range nonIntersectingRange = new Range(-10, -6);
	       //  System.out.println("testDoesNotIntersectNegativeRange result " + nonIntersectingRange.getLowerBound() + nonIntersectingRange.getUpperBound());
	        Assert.assertFalse("The ranges should not intersect", 
	            baseRange.intersects(nonIntersectingRange.getLowerBound(), nonIntersectingRange.getUpperBound()));
	    }
	    
	    // TC5
	    @Test
	    public void testIntersectsMixedRange() {
	        Range baseRange = new Range(-3, 3);
	        Range intersectingRange = new Range(-2, 2);
	        Assert.assertTrue("The ranges should intersect", 
	            baseRange.intersects(intersectingRange.getLowerBound(), intersectingRange.getUpperBound()));
	    }

	    // TC6
	    @Test
	    public void testDoesNotIntersectMixedRange() {
	        Range baseRange = new Range(-3, 3);
	        Range nonIntersectingRange = new Range(4, 8);
	        Assert.assertFalse("The ranges should not intersect", 
	            baseRange.intersects(nonIntersectingRange.getLowerBound(), nonIntersectingRange.getUpperBound()));
	    }
	    
	 // Test Cases for Expand to Include 
	    
	    // TC1
	    @Test
	    public void testExpandToIncludePositiveRange() {
	        Range range = new Range(1, 5);
	        double valueToInclude = 10;
	        Range expandedRange = Range.expandToInclude(range, valueToInclude);
	        Assert.assertEquals("The upper bound should be expanded to include 10", valueToInclude, expandedRange.getUpperBound(), 0.000000001d);
	        Assert.assertEquals("The lower bound should remain the same", 1, expandedRange.getLowerBound(), 0.000000001d);
	    }

	    // TC2
	    @Test
	    public void testExpandToIncludeNegativeRange() {
	        Range range = new Range(-5, -1);
	        double valueToInclude = -10;
	        Range expandedRange = Range.expandToInclude(range, valueToInclude);
	        Assert.assertEquals("The lower bound should be expanded to include -10", valueToInclude, expandedRange.getLowerBound(), 0.000000001d);
	        Assert.assertEquals("The upper bound should remain the same", -1, expandedRange.getUpperBound(), 0.000000001d);
	    }

	    // TC3
	    @Test
	    public void testExpandToIncludeMixedRange() {
	        Range range = new Range(-3, 3);
	        double valueToInclude = 5;
	        Range expandedRange = Range.expandToInclude(range, valueToInclude);
	        Assert.assertEquals("The upper bound should be expanded to include 5", valueToInclude, expandedRange.getUpperBound(), 0.000000001d);
	        Assert.assertEquals("The lower bound should remain the same", -3, expandedRange.getLowerBound(), 0.000000001d);
	    }
	    
	    // TC4
	    @Test
	    public void testExpandToIncludeValueAlreadyInPositiveRange() {
	        Range range = new Range(1, 5);
	        double valueToInclude = 3;
	        Range expandedRange = Range.expandToInclude(range, valueToInclude);
	        Assert.assertEquals("The upper bound should remain the same when including 3", 5, expandedRange.getUpperBound(), 0.000000001d);
	        Assert.assertEquals("The lower bound should remain the same when including 3", 1, expandedRange.getLowerBound(), 0.000000001d);
	    }
	    
	    // TC5
	    @Test
	    public void testExpandToIncludeValueAlreadyInNegativeRange() {
	        Range range = new Range(-5, -1);
	        double valueToInclude = -3;
	        Range expandedRange = Range.expandToInclude(range, valueToInclude);
	        Assert.assertEquals("The upper bound should remain the same when including -3", -1, expandedRange.getUpperBound(), 0.000000001d);
	        Assert.assertEquals("The lower bound should remain the same when including -3", -5, expandedRange.getLowerBound(), 0.000000001d);
	    }

	    // TC6
	    @Test
	    public void testExpandToIncludeValueAlreadyInMixedRange() {
	        Range range = new Range(-3, 3);
	        double valueToInclude = 0;
	        Range expandedRange = Range.expandToInclude(range, valueToInclude);
	        Assert.assertEquals("The upper bound should remain the same when including 0", 3, expandedRange.getUpperBound(), 0.000000001d);
	        Assert.assertEquals("The lower bound should remain the same when including 0", -3, expandedRange.getLowerBound(), 0.000000001d);
	    }
	    
	 /* White Box Testing 
	  * For addition coverage 
	  */
	    
	 // Test Range Constructor
	    
	    @Test(expected = IllegalArgumentException.class)
	    public void testRangeConstructorWithInvalidArguments() {
	        // This should throw an IllegalArgumentException because the lower bound is greater than the upper bound
	        new Range(4.0, 2.0);
	    }

	 // Test for get Length 
	    
	    @Test
	    public void testGetLength() {
	        Range range = new Range(1.0, 5.0);
	        double expectedLength = 4.0;
	        assertEquals("Length should be 4.0", expectedLength, range.getLength(), 0.000000001d);
	    }
	    
	  // Test for Contains
	    
	    @Test
	    public void testContainsInRange() {
	        Range range = new Range(1.0, 5.0);
	        double inRange = 3.0;
	        assertTrue("Range should contain 3.0", range.contains(inRange));
	    }
	    
	    @Test
	    public void testContainsOutOfRange() {
	        Range range = new Range(1.0, 5.0);
	        double outOfRange = 6.0;
	        assertFalse("Range should not contain 6.0", range.contains(outOfRange));
	    }
	    
	 // Test Cases for Intersects (additional test cases)
	    
	    @Test
	    public void testDoesNotIntersectCompletelyBeforeRange() {
	        Range baseRange = new Range(1, 5);
	        Assert.assertFalse("Ranges (-2, 0) and (1, 5) should not intersect", 
	            baseRange.intersects(-2, 0));
	    }

	    @Test
	    public void testDoesNotIntersectCompletelyAfterRange() {
	        Range baseRange = new Range(1, 5);
	        Assert.assertFalse("Ranges (1, 5) and (6, 8) should not intersect", 
	            baseRange.intersects(6, 8));
	    }

	 // Test Cases for ExpandToInclude (additional test cases)
	    
	    @Test
	    public void testExpandToIncludeWithNullRange() {
	        double valueToInclude = 5;
	        Range expandedRange = Range.expandToInclude(null, valueToInclude);
	        Assert.assertNotNull("Expanded range should not be null when initial range is null", expandedRange);
	        Assert.assertEquals("The lower bound should be set to the value to include when initial range is null", 
	        		valueToInclude, expandedRange.getLowerBound(), 0.000000001d);
	        Assert.assertEquals("The upper bound should be set to the value to include when initial range is null", 
	        		valueToInclude, expandedRange.getUpperBound(), 0.000000001d);
	    }
	    
	 // Test Cases for Range expand(Range range, double lowerMargin, double upperMargin)

	    @Test(expected = IllegalArgumentException.class)
	    public void testExpandWithNullRange() {
	        Range.expand(null, 0.1, 0.1);
	    }

	 // Test for Constrain
	    
	    @Test
	    public void testConstrainWithinRange() {
	        Range range = new Range(1.0, 5.0);
	        double constrained = range.constrain(3.0);
	        assertEquals("Constrained value should be the same as input value within range", 3.0, constrained, 0.000000001d);
	    }
	    
	    @Test
	    public void testConstrainAboveRange() {
	        Range range = new Range(1.0, 5.0);
	        double constrained = range.constrain(10.0);
	        assertEquals("Constrained value should be the upper bound of the range when input value is above range", 5.0, constrained, 0.000000001d);
	    }

	    @Test
	    public void testConstrainBelowRange() {
	        Range range = new Range(1.0, 5.0);
	        double constrained = range.constrain(-1.0);
	        assertEquals("Constrained value should be the lower bound of the range when input value is below range", 1.0, constrained, 0.000000001d);
	    }

	    
	 // Test for Combine
	    
	    @Test
	    public void testCombine() {
	        Range range1 = new Range(1.0, 5.0);
	        Range range2 = new Range(4.0, 10.0);
	        Range combined = Range.combine(range1, range2);
	        assertEquals("Combined range should start at 1.0", 1.0, combined.getLowerBound(), 0.000000001d);
	        assertEquals("Combined range should end at 10.0", 10.0, combined.getUpperBound(), 0.000000001d);
	    }
	    
	    // Testing Null Values
	    @Test
	    public void testCombineWithFirstRangeNull() {
	        Range range1 = null;
	        Range range2 = new Range(4.0, 10.0);
	        Range combined = Range.combine(range1, range2);
	        assertSame("Combine should return the second range when the first range is null", range2, combined);
	    }
	    
	    @Test
	    public void testCombineWithSecondRangeNull() {
	        Range range1 = new Range(1.0, 5.0);
	        Range range2 = null;
	        Range combined = Range.combine(range1, range2);
	        assertSame("Combine should return the first range when the second range is null", range1, combined);
	    }

	    @Test
	    public void testCombineWithBothRangesNull() {
	        Range range1 = null;
	        Range range2 = null;
	        Range combined = Range.combine(range1, range2);
	        assertNull("Combine should return null when both ranges are null", combined);
	    }
	    
	  // Test for Expand
	    
	    @Test
	    public void testExpand() {
	        Range range = new Range(1.0, 5.0);
	        Range expanded = Range.expand(range, 0.5, 0.25); // Expands by 50% on the lower side and 25% on the upper side
	        assertEquals("Expanded range should start at -1.0", -1.0, expanded.getLowerBound(), 0.000000001d);
	        assertEquals("Expanded range should end at 6.0", 6.0, expanded.getUpperBound(), 0.000000001d);
	    }
	    
	  // Test for Shift(Range base, double delta)
	    
	    @Test
	    public void testShift() {
	        Range range = new Range(1.0, 5.0);
	        Range shifted = Range.shift(range, 2.0);
	        assertEquals("Shifted range should start at 3.0", 3.0, shifted.getLowerBound(), 0.000000001d);
	        assertEquals("Shifted range should end at 7.0", 7.0, shifted.getUpperBound(), 0.000000001d);
	    }
	    
	 // Test for Shift(Range base, double delta, boolean allowZeroCrossing)
	    
	    @Test
	    public void testShiftWithNoZeroCrossing() {
	        Range range = new Range(-3.0, 1.0);
	        Range shifted = Range.shift(range, 5.0, false); // Shift by 5.0 without allowing zero crossing
	        assertEquals("Shifted range should start at 0.0 due to no zero crossing", 0.0, shifted.getLowerBound(), 0.000000001d);
	        assertEquals("Shifted range should end at 4.0", 4.0, shifted.getUpperBound(), 0.000000001d);
	    }
	    
	    @Test
	    public void testShiftAllowingZeroCrossing() {
	        Range range = new Range(-3.0, 1.0);
	        Range shifted = Range.shift(range, 5.0, true); // Allow zero crossing
	        assertEquals("Shifted range should start at 2.0 when allowing zero crossing", 2.0, shifted.getLowerBound(), 0.000000001d);
	        assertEquals("Shifted range should end at 6.0 when allowing zero crossing", 6.0, shifted.getUpperBound(), 0.000000001d);
	    }
	    
	    @Test
	    public void testShiftNoZeroCrossingDoesNotCrossZero() {
	        Range range = new Range(2.0, 6.0);
	        Range shifted = Range.shift(range, -1.0, false); // Shift by -1.0 without allowing zero crossing
	        assertEquals("Shifted range should start at 1.0", 1.0, shifted.getLowerBound(), 0.000000001d);
	        assertEquals("Shifted range should end at 5.0", 5.0, shifted.getUpperBound(), 0.000000001d);
	    }
	    
	  // Test for Equals 
	    
	    @Test
	    public void testEqualsWithNonRangeObject() {
	        Range range = new Range(1.0, 5.0);
	        Object obj = new Object();
	        assertFalse("Should return false as object is not a Range", range.equals(obj));
	    }

	    @Test
	    public void testEqualsWithNull() {
	        Range range = new Range(1.0, 5.0);
	        Object obj = null;
	        assertFalse("Should return false as object is null", range.equals(obj));
	    }

	    @Test
	    public void testEqualsWithDifferentRanges() {
	        Range range1 = new Range(1.0, 5.0);
	        Range range2 = new Range(1.0, 6.0);
	        assertFalse("Should return false as ranges are different", range1.equals(range2));
	    }

	    @Test
	    public void testEqualsWithIdenticalRanges() {
	        Range range1 = new Range(1.0, 5.0);
	        Range range2 = new Range(1.0, 5.0);
	        assertTrue("Should return true as ranges are identical", range1.equals(range2));
	    }
	    
	 // Test for HashCode

	    @Test
	    public void testHashCodeConsistency() {
	        Range range = new Range(1.0, 5.0);
	        int hash1 = range.hashCode();
	        int hash2 = range.hashCode();
	        assertEquals("Hash codes should be consistent", hash1, hash2);
	    }


	}


