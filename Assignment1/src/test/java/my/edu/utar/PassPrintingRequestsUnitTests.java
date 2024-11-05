package my.edu.utar;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class PassPrintingRequestsUnitTests {

	//Test for PassPrintingRequest()
	/*
	 * Charge Module
	 * Test Case: 4.1.1~4.1.5
	 * Test Steps:
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
	@Parameters(method = "getParamsForPassPrintingRequestsValidValues")
	public void testWriteRequestsValidValues(Order[] orderList, Order[] expectedList) {
		OrderFunctionality of = new Order(orderList);
		PrintingFunctionality pf = new Printing ();
		NewCharge nc = new NewCharge (of, pf);
		nc.passPrintingRequest();
		assertEquals(expectedList.length, pf.getPrintingRequest());
		for (int i = 0; i < expectedList.length; i++) {
			assertEquals(expectedList[i].getType(), pf.getPrintList()[i].getType());
			assertEquals(expectedList[i].getOption(), pf.getPrintList()[i].getOption());
			assertEquals(expectedList[i].getQuantity(), pf.getPrintList()[i].getQuantity());
			assertEquals(expectedList[i].getAddOption1(), pf.getPrintList()[i].getAddOption1());
			assertEquals(expectedList[i].getAddOption2(), pf.getPrintList()[i].getAddOption2());
		}
	}
	//Invalid test is not needed at here, since invalid orders will be handled by the order module in order class.
}
