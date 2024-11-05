package my.edu.utar;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class GetTotalChargeUnitTests {
	
	//Test for GetTotalCharge()
	/*
	 * Charge module
	 * Test case: 3.1.1~3.1.11
	 */
	private Object [] getParamsForGetTotalChargeValidValues () {
		return new Object [] {
				new Object [] {new Order[] {new Order ("D", 1, 3, "N", "N"), new Order("D", 2, 18, "N", "N")}, 15.9},
				new Object [] {new Order[] {new Order ("D", 1, 7, "N", "N"), new Order("P", 1, 6, "Y", "N")}, 8.8},
				new Object [] {new Order[] {new Order ("D", 1, 12, "N", "N"), new Order ("P", 2, 3, "N", "N")}, 7.2},
				new Object [] {new Order[] {new Order ("D", 2, 30, "N", "N"), new Order("P", 1, 15, "Y", "Y")}, 36},
				new Object [] {new Order[] {new Order ("D", 2, 4, "N", "N"), new Order("P", 2, 30, "N", "Y")}, 31.0},
				new Object [] {new Order[] {new Order ("P", 1, 40, "N", "N"), new Order("P", 2, 17, "Y", "Y")}, 38.7},
				new Object [] {new Order[] {new Order ("D", 1, 38, "N", "N"), new Order ("D", 2, 8, "N", "N"), new Order("P", 1, 3, "N", "Y")}, 18.25},
				new Object [] {new Order[] {new Order ("D", 1, 23, "N", "N"), new Order ("D", 2, 3, "N", "N"), new Order("P", 2, 9, "Y", "N")}, 17.05},
				new Object [] {new Order[] {new Order ("D", 1, 14, "N", "N"), new Order ("P", 1, 9, "N", "Y"), new Order("P", 2, 13, "N", "N")}, 24.7},
				new Object [] {new Order[] {new Order ("D", 2, 12, "N", "N"), new Order ("P", 1, 18, "Y", "N"), new Order("P", 2, 3, "N", "Y")}, 28.95},
				new Object [] {new Order[] {new Order ("D", 1, 50, "N", "N"), new Order("D", 2, 50, "N", "N"), new Order("P", 1, 50, "Y", "Y"), new Order("P", 2, 50, "Y", "Y")}, 132.5}
		};
	}
	@Test
	@Parameters(method = "getParamsForGetTotalChargeValidValues")
	public void testGetTotalChargeValidValues(Order[] orderList, double expectedResult) {
		OrderFunctionality of = new Order(orderList);
		PrintingFunctionality pf = new Printing();
		NewCharge nc = new NewCharge (of, pf);
		assertEquals(nc.getTotalCharge(), expectedResult, 0);
	}
	//Invalid test is not needed at here, since invalid orders will be handled by the order module in order class.
}
