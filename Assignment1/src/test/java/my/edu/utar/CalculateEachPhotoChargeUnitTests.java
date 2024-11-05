package my.edu.utar;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
@RunWith(JUnitParamsRunner.class)
public class CalculateEachPhotoChargeUnitTests {
	//Test for CalculatePhotoCharge()
	/*
	 * Charge module
	 * Test case: 2.1.1~2.1.32
	 * Boundary-value analysis
	 */
	private Object [] getParamsForTestCalculateEachPhotoChargeForNormalSizeValidValues () {
		return new Object [] {
				new Object [] {new Order ("P", 1, 1, "N", "N"), 1},
				new Object [] {new Order ("P", 1, 4, "N", "N"), 4},
				new Object [] {new Order ("P", 1, 5, "N", "N"), 4.5},
				new Object [] {new Order ("P", 1, 10, "N", "N"), 9},
				new Object [] {new Order ("P", 1, 11, "N", "N"), 8.25},
				new Object [] {new Order ("P", 1, 20, "N", "N"), 15},
				new Object [] {new Order ("P", 1, 21, "N", "N"), 10.5},
				new Object [] {new Order ("P", 1, 50, "N", "N"), 25},
				new Object [] {new Order ("P", 1, 1, "Y", "N"), 1.1},
				new Object [] {new Order ("P", 1, 4, "Y", "N"), 4.4},
				new Object [] {new Order ("P", 1, 5, "Y", "N"), 5},
				new Object [] {new Order ("P", 1, 10, "Y", "N"), 10},
				new Object [] {new Order ("P", 1, 11, "Y", "N"), 9.35},
				new Object [] {new Order ("P", 1, 20, "Y", "N"), 17},
				new Object [] {new Order ("P", 1, 21, "Y", "N"), 12.6},
				new Object [] {new Order ("P", 1, 50, "Y", "N"), 30},
				new Object [] {new Order ("P", 1, 1, "N", "Y"), 1.15},
				new Object [] {new Order ("P", 1, 4, "N", "Y"), 4.6},
				new Object [] {new Order ("P", 1, 5, "N", "Y"), 5.25},
				new Object [] {new Order ("P", 1, 10, "N", "Y"), 10.5},
				new Object [] {new Order ("P", 1, 11, "N", "Y"), 9.9},
				new Object [] {new Order ("P", 1, 20, "N", "Y"), 18},
				new Object [] {new Order ("P", 1, 21, "N", "Y"), 13.65},
				new Object [] {new Order ("P", 1, 50, "N", "Y"), 32.5},
				new Object [] {new Order ("P", 1, 1, "Y", "Y"), 1.25},
				new Object [] {new Order ("P", 1, 4, "Y", "Y"), 5},
				new Object [] {new Order ("P", 1, 5, "Y", "Y"), 5.75},
				new Object [] {new Order ("P", 1, 10, "Y", "Y"), 11.5},
				new Object [] {new Order ("P", 1, 11, "Y", "Y"), 11},
				new Object [] {new Order ("P", 1, 20, "Y", "Y"), 20},
				new Object [] {new Order ("P", 1, 21, "Y", "Y"), 15.75},
				new Object [] {new Order ("P", 1, 50, "Y", "Y"), 37.5},
		};
	}
	@Test
	@Parameters(method = "getParamsForTestCalculateEachPhotoChargeForNormalSizeValidValues")
	public void testCalculateEachPhotoChargeForNormalSizeValidValues(Order anOrder, double expectedResult) {
		Charge charge = new Charge ();
		assertEquals(charge.calPhotoCharge(anOrder), expectedResult, 0);
	}

	/*
	 * Charge module
	 * Test case: 2.2.1~2.2.32
	 * Boundary-value analysis
	 */
	private Object [] getParamsForTestCalculateEachPhotoChargeForPassportSizeValidValues () {
		return new Object [] {
				new Object [] {new Order ("P", 2, 1, "N", "N"), 1.2},
				new Object [] {new Order ("P", 2, 4, "N", "N"), 4.8},
				new Object [] {new Order ("P", 2, 5, "N", "N"), 4.75},
				new Object [] {new Order ("P", 2, 10, "N", "N"), 9.5},
				new Object [] {new Order ("P", 2, 11, "N", "N"), 9.35},
				new Object [] {new Order ("P", 2, 20, "N", "N"), 17},
				new Object [] {new Order ("P", 2, 21, "N", "N"), 15.75},
				new Object [] {new Order ("P", 2, 50, "N", "N"), 37.5},
				new Object [] {new Order ("P", 2, 1, "Y", "N"), 1.3},
				new Object [] {new Order ("P", 2, 4, "Y", "N"), 5.2},
				new Object [] {new Order ("P", 2, 5, "Y", "N"), 5.25},
				new Object [] {new Order ("P", 2, 10, "Y", "N"), 10.5},
				new Object [] {new Order ("P", 2, 11, "Y", "N"), 10.45},
				new Object [] {new Order ("P", 2, 20, "Y", "N"), 19},
				new Object [] {new Order ("P", 2, 21, "Y", "N"), 17.85},
				new Object [] {new Order ("P", 2, 50, "Y", "N"), 42.5},
				new Object [] {new Order ("P", 2, 1, "N", "Y"), 1.35},
				new Object [] {new Order ("P", 2, 4, "N", "Y"), 5.4},
				new Object [] {new Order ("P", 2, 5, "N", "Y"), 5.5},
				new Object [] {new Order ("P", 2, 10, "N", "Y"), 11},
				new Object [] {new Order ("P", 2, 11, "N", "Y"), 11},
				new Object [] {new Order ("P", 2, 20, "N", "Y"), 20},
				new Object [] {new Order ("P", 2, 21, "N", "Y"), 18.9},
				new Object [] {new Order ("P", 2, 50, "N", "Y"), 45},
				new Object [] {new Order ("P", 2, 1, "Y", "Y"), 1.45},
				new Object [] {new Order ("P", 2, 4, "Y", "Y"), 5.8},
				new Object [] {new Order ("P", 2, 5, "Y", "Y"), 6},
				new Object [] {new Order ("P", 2, 10, "Y", "Y"), 12},
				new Object [] {new Order ("P", 2, 11, "Y", "Y"), 12.1},
				new Object [] {new Order ("P", 2, 20, "Y", "Y"), 22},
				new Object [] {new Order ("P", 2, 21, "Y", "Y"), 21},
				new Object [] {new Order ("P", 2, 50, "Y", "Y"), 50},
		};
	}
	@Test
	@Parameters(method = "getParamsForTestCalculateEachPhotoChargeForPassportSizeValidValues")
	public void testCalculateEachPhotoChargeForPassportSizeValidValues(Order anOrder, double expectedResult) {
		Charge charge = new Charge ();
		assertEquals(charge.calPhotoCharge(anOrder), expectedResult, 0);
	}
	//Invalid test is not needed at here, since invalid orders will be handled by the order module in order class.
}
