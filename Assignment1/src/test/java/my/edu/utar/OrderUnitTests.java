package my.edu.utar;

import static org.junit.Assert.*;
import org.junit.Test;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class OrderUnitTests {
	
	Order o = new Order ();
	
	//Valid test for setType()
	/*
	 * Order Module
	 * Test Case 1.1.1~1.1.2
	 */
	private Object [] getParamsForSetTypeValidTest () {
		return new Object [] {
			new Object [] {"D", "D"},
			new Object [] {"d", "D"}
		};
	}
	@Test
	@Parameters(method = "getParamsForSetTypeValidTest")
	public void testSetTypeValidTest(String inputType, String expectedType) {
		o.setType(inputType);
		assertEquals(o.getType(), expectedType);
	}

	
	//Invalid test for setType()
	/*
	 * Order Module
	 * Test Case 1.1.3~1.1.5
	 */
	private Object [] getParamsForSetTypeInvalidTest() {
		return new Object [] {
			new Object [] {null},
			new Object [] {"do"},
			new Object [] {""}
		};
	}
	@Test(expected = IllegalArgumentException.class)
	@Parameters(method = "getParamsForSetTypeInvalidTest")
	public void testSetTypeInvalidTest(String inputType) {
		o.setType(inputType);
	}

	
	//Valid test for setOption ()
	/*
	 * Order Module
	 * Test Case 1.2.1
	 */
	private Object[] getParamsForSetOptionValidTest(){
		return new Object[]{
			new Object[] {1,1}
		};
	}
	@Test
	@Parameters(method="getParamsForSetOptionValidTest")
	public void testSetOptionValidTest(int option,int expectedOption){
		o.setOption(option);
		assertEquals(o.getOption(),expectedOption);
	}

	
	//Invalid test for setOption ()
	/*
	 * Order Module
	 * Test Case 1.2.2~1.2.3
	 */
	private Object[] getParamsForSetOptionInvalidTest () {
		return new Object [] {
				new Object [] {0},
				new Object [] {3}
		};
	}
	@Test(expected = IllegalArgumentException.class)
	@Parameters(method = "getParamsForSetOptionInvalidTest")
	public void testSetOptionInvalidTest(int option) {
		o.setOption(option);
	}
	
	
	//Valid test for setQuantity ()
	/*
	 * Order Module
	 * Test Case 1.3.1
	 */
	private Object[] getParamsForSetQuantityValidTest(){
		return new Object[]{
			new Object[] {1,1}
		};
	}
	@Test
	@Parameters(method="getParamsForSetQuantityValidTest")
	public void testSetQuantityValidTest(int quantity,int expectedQuantity){
		o.setQuantity(quantity);
		assertEquals(o.getQuantity(),expectedQuantity);
	}

	
	//Invalid test for setQuantity ()
	/*
	 * Order Module
	 * Test Case 1.3.2~1.3.3
	 */
	private Object[] getParamsForSetQuantityInvalidTest () {
		return new Object [] {
				new Object [] {0},
				new Object [] {51}
		};
	}
	@Test(expected = IllegalArgumentException.class)
	@Parameters(method = "getParamsForSetQuantityInvalidTest")
	public void testSetQuantityInvalidTest(int quantity) {
		o.setQuantity(quantity);
	}

	//Valid test for setAddOption1()
	/*
	 * Order Module
	 * Test Case 1.4.1~1.4.2
	 */
	private Object[]getParamsForSetAddOption1ValidTest(){
		return new Object[]{
			new Object[] {"Y","Y"},
			new Object[] {"y","Y"}
		};
	}
	@Test
	@Parameters(method="getParamsForSetAddOption1ValidTest")
	public void testSetAddOption1ValidTest(String addOption1,String expectedOption1){
		o.setAddOption1(addOption1);
		assertEquals(o.getAddOption1(),expectedOption1);
	}

		
	//Invalid test for setAddOption1 ()
	/*
	 * Order Module
	 * Test Case 1.4.3~1.4.5
	 */
	private Object[]getParamsForSetAddOption1InvalidTest(){
		return new Object[]{
			new Object [] {null},
			new Object [] {"do"},
			new Object [] {""}
		};
	}
	@Test(expected=IllegalArgumentException.class)
	@Parameters(method="getParamsForSetAddOption1InvalidTest")
	public void testSetAddOption1InValidTest(String addOption1){
		o.setAddOption1(addOption1);
	}

		
	//Valid test for setAddOption2()
	/*
	 * Order Module
	 * Test Case 1.5.1~1.5.2
	 */
	private Object[]getParamsForSetAddOption2ValidTest(){
		return new Object[]{
			new Object[] {"Y","Y"},
			new Object[] {"y","Y"}
		};
	}
	@Test
	@Parameters(method="getParamsForSetAddOption2ValidTest")
	public void testSetAddOption2ValidTest(String addOption2,String expectedOption2){
		o.setAddOption2(addOption2);
		assertEquals(o.getAddOption2(),expectedOption2);
	}


	//Invalid test for setAddOption2()
	/*
	 * Order Module
	 * Test Case 1.5.3~1.5.5
	 */
	private Object[]getParamsForSetAddOption2InvalidTest(){
		return new Object[]{
			new Object [] {null},
			new Object [] {"do"},
			new Object [] {""}
		};
	}
	@Test(expected=IllegalArgumentException.class)
	@Parameters(method="getParamsForSetAddOption2InvalidTest")
	public void testSetAddOption2InValidTest(String addOption2){
		o.setAddOption2(addOption2);
	}
}
