package my.edu.utar;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class CalculateEachDocChargeUnitTests {

	//Test for CalculateDocumentCharge()
	/*
	 * Charge Module
	 * Test Case: 1.1.1~1.1.16
	 * Boundary Value Analysis
	 */
	private Object [] getParamsForTestCalculateEachDocChargeValidValues () {
		return new Object [] {
				new Object [] {new Order ("D", 1, 1, "N", "N"), 0.5},
				new Object [] {new Order ("D", 1, 4, "N", "N"), 2},
				new Object [] {new Order ("D", 1, 5, "N", "N"), 2},
				new Object [] {new Order ("D", 1, 10, "N", "N"), 4},
				new Object [] {new Order ("D", 1, 11, "N", "N"), 3.3},
				new Object [] {new Order ("D", 1, 20, "N", "N"), 6},
				new Object [] {new Order ("D", 1, 21, "N", "N"), 4.2},
				new Object [] {new Order ("D", 1, 50, "N", "N"), 10},
				new Object [] {new Order ("D", 2, 1, "N", "N"), 1},
				new Object [] {new Order ("D", 2, 4, "N", "N"), 4},
				new Object [] {new Order ("D", 2, 5, "N", "N"), 4.5},
				new Object [] {new Order ("D", 2, 10, "N", "N"), 9},
				new Object [] {new Order ("D", 2, 11, "N", "N"), 8.8},
				new Object [] {new Order ("D", 2, 20, "N", "N"), 16},
				new Object [] {new Order ("D", 2, 21, "N", "N"), 14.7},
				new Object [] {new Order ("D", 2, 50, "N", "N"), 35}
		};
	}
	@Test
	@Parameters(method = "getParamsForTestCalculateEachDocChargeValidValues")
	public void testCalculateEachDocChargeValidValues(Order anOrder, double expectedResult) {
		Charge charge = new Charge ();
		assertEquals(charge.calDocCharge(anOrder), expectedResult, 0);
	}
	//Invalid test is not needed at here, since invalid orders will be handled by the order module in order class.
}
