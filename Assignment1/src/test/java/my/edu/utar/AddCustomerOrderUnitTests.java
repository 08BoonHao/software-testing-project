package my.edu.utar;

import static org.junit.Assert.*;
import java.util.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import org.junit.Test;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class AddCustomerOrderUnitTests {

	Order o = new Order ();
	
	static Scanner inputStream = null;
	
	//Valid test for addCustomerOrder()
	/*
	 * Order Module
	 * Test Case: 2.1.1
	 */
	private Object [] getParamsForAddCustomerOrderValidValue() {
		String filename = "valid.txt";
		String [] tokens = null;
		
		try {
			inputStream = new Scanner (new File(filename));
		}
		catch (FileNotFoundException e){
			System.out.println("Error opening the file " + filename);
			System.exit(0);
		}
		while(inputStream.hasNext()) {
			String singleLine = inputStream.next();
			tokens = singleLine.split(",");
		}
		Order inputOrder1 = new Order(tokens[0], Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]), tokens[3], tokens[4]);
		Order inputOrder2 = new Order(tokens[5], Integer.parseInt(tokens[6]), Integer.parseInt(tokens[7]), tokens[8], tokens[9]);
		Order [] expectedResult = new Order[] {inputOrder1, inputOrder2};
		return new Object [] {
				new Object [] {inputOrder1,inputOrder2, expectedResult}
		};
	}
	@Test
	@Parameters(method = "getParamsForAddCustomerOrderValidValue")
	public void testAddCustomerOrderValidTest(Order inputOrder1,Order inputOrder2, Order [] expectedOrder) {
		o.addCustomerOrder(inputOrder1);
		o.addCustomerOrder(inputOrder2);
		assertArrayEquals(expectedOrder, o.getOrderList());
	}
	
	
	//Invalid test for addCustomerOrder ()
	/*
	 * Order Module
	 * Test Case: 2.1.2~2.1.16
	 */
	private Object [] getParamsForAddCustomerOrderInvalidValue() {
		String filename = "invalid.txt";
		String [] tokens = null;
		
		try {
			inputStream = new Scanner (new File(filename));
		}
		catch (FileNotFoundException e){
			System.out.println("Error opening the file " + filename);
			System.exit(0);
		}
		List<Object[]> testData = new ArrayList <>();
		
		while(inputStream.hasNext()) {
			String singleLine = inputStream.nextLine();
			if (singleLine.trim().equals("null")) {
				testData.add(new Order[] {null});
			}
			else{
				tokens = singleLine.split(",");
				Order order = new Order(tokens[0], Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]), tokens[3], tokens[4]);
				testData.add(new Order[] {order});
			}
		}
		return testData.toArray();
	}
	@Test(expected = IllegalArgumentException.class)
	@Parameters(method = "getParamsForAddCustomerOrderInvalidValue")
	public void testAddCustomerOrderInvalidTest (Order inputOrder) {
		o.addCustomerOrder(inputOrder);
	}
}
