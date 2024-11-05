package my.edu.utar;

import static org.junit.Assert.*;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class PrintingUnitTests {

	Printing print = new Printing ();
	
	//Test for queueRequest() in printing module
	/*
	 * Printing module
	 * Test case: 1.1.1
	 */
	private Object getParamsForGetAndWrite() {
		Order order1 = new Order("D", 1, 2, "N","N");
		Order [] orderList = new Order[] {order1};
		Order [] expectedOrder = new Order[]{order1};
		return new Object [] {
			new Object [] {orderList, expectedOrder}
		};
	}
	@Test
	@Parameters (method = "getParamsForGetAndWrite")
	public void testGetandWrite(Order[] order, Order[] expectedOrder) {
		print.queueRequest(order);
		assertArrayEquals(print.getPrintList(), expectedOrder);
	}
	//Invalid test is not needed at here, since invalid orders will be handled by the order module in order class.
}
