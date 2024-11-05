package my.edu.utar;

import static org.junit.Assert.*;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class ChargeModuleIntegrationTest {
	
	//Test for getTotalCharge()
	/*
	 * Charge module
	 * Test Case: 5.1.1~5.1.11
	 */
	private Object[] getParamsForGetTotalChargeValidValues() {
		return new Object[] {
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
		Order order = new Order (orderList);
		Printing print = new Printing ();
		Charge charge = new Charge (order, print);
		assertEquals(charge.getTotalCharge(), expectedResult, 0);
	}
	//Invalid test is not needed at here, since invalid orders will be handled by the order module in order class.
	
	//Test for passPrintingRequest()
	/*
	 * Charge module
	 * Test Case: 5.2.1~5.2.5 
	 * 	 * Test Steps:
	 * 1. Test the length of the expectedPrintList and the length of the printList that is passed to printing module
	 * 2. For each of the orders, test each of the components of the orders to check whether the value of the components in 
	 * the expectedPrintList is same with the value of the components in the printList that is passed to the printing module.
	 */
	private Object [] getParamsForPassPrintingRequestsValidValues() {
		//1. Two order that has the same type, option, addOption1, addOption2
		Order order1_1 = new Order("D", 1, 2, "N", "N");
		Order order1_2 = new Order("D", 1, 3, "N", "N");
		Order order1_expected = new Order("D", 1, 5, "N", "N");
		Order [] orderList1 = new Order[]{order1_1, order1_2};
		Order [] expectedList1 = new Order[] {order1_expected};
		
		//2. Two order with different type, or different option, or different addOption1, or different addOption2
		Order order2_1 = new Order("D", 1, 2, "N", "N");
		Order order2_2 = new Order("P", 1, 2, "N", "N");
		Order [] orderList2 = new Order[] {order2_1, order2_2};
		Order [] expectedList2 = new Order[] {order2_1, order2_2};
		
		//3. Three order: two same type, option, addOption1, and addOption2, one different
		Order order3_1 = new Order("D", 1, 2, "N", "N");
		Order order3_2 = new Order("D", 1, 3, "N", "N");
		Order order3_3 = new Order("D", 2, 10, "N", "N");
		Order order3_add = new Order("D", 1, 5, "N", "N");
		Order [] orderList3 = new Order[] {order3_1, order3_2, order3_3};
		Order [] expectedList3 = new Order [] {order3_3, order3_add};
		
		//4. Four order: two same type, option, addOption1, and addOption2, another two also has same type, option, addOption1, and addOption2
		Order order4_1 = new Order("D", 1, 2, "N", "N");
		Order order4_2 = new Order("P", 2, 3, "Y", "Y");
		Order order4_3 = new Order("P", 2, 5, "Y", "Y");
		Order order4_4 = new Order("D", 1, 3, "N", "N");
		Order order4_add1 = new Order("D",1 , 5, "N", "N");
		Order order4_add2 = new Order("P", 2, 8, "Y", "Y");
		Order [] orderList4 = new Order[] {order4_1, order4_2, order4_3, order4_4};
		Order [] expectedList4 = new Order [] {order4_add1, order4_add2};
		
		//5. Four order: three same type, option, addOption1, and addOption2, other one is different
		Order order5_1 = new Order ("D", 1, 3, "N", "N");
		Order order5_2 = new Order ("D", 1, 9, "N", "N");
		Order order5_3 = new Order ("P", 1, 3, "Y", "N");
		Order order5_4 = new Order ("D", 1, 12, "N", "N");
		Order order5_add = new Order ("D", 1, 24, "N", "N");
		Order[] orderList5 = new Order[] {order5_1, order5_2, order5_3, order5_4};
		Order[] expectedList5 = new Order[] {order5_3, order5_add};
		return new Object [] {
				new Object [] {orderList1, expectedList1},
				new Object [] {orderList2, expectedList2},
				new Object [] {orderList3, expectedList3},
				new Object [] {orderList4, expectedList4},
				new Object [] {orderList5, expectedList5}
		};
	}
	@Test
	@Parameters (method = "getParamsForPassPrintingRequestsValidValues")
	public void testPassPrintingRequests (Order[] orders, Order[] expectedPrintRequests) {
		Order order = new Order (orders);
		Printing print = new Printing ();
		Charge charge = new Charge (order, print);
		charge.passPrintingRequest();
		Order [] actualPrintRequests = charge.getPrintList();
		assertEquals(expectedPrintRequests.length, actualPrintRequests.length);
		for (int i = 0; i < expectedPrintRequests.length; i++) {
			assertEquals(expectedPrintRequests[i].getType(), actualPrintRequests[i].getType());
			assertEquals(expectedPrintRequests[i].getOption(), actualPrintRequests[i].getOption());
			assertEquals(expectedPrintRequests[i].getQuantity(), actualPrintRequests[i].getQuantity());
			assertEquals(expectedPrintRequests[i].getAddOption1(), actualPrintRequests[i].getAddOption1());
			assertEquals(expectedPrintRequests[i].getAddOption2(), actualPrintRequests[i].getAddOption2());
		}
	}
	//Invalid test is not needed at here, since invalid orders will be handled by the order module in order class.
}
