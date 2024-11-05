package my.edu.utar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Printing implements PrintingFunctionality{
	private List <Order> printList = new ArrayList <Order> ();
	
	public Printing (){
		printList = new ArrayList <Order> ();
	}
	
	public int getPrintingRequest () {
		return printList.size();
	}
	
	public Order [] getPrintList (){
		Order [] orders = printList.toArray(new Order[printList.size()]);
		return orders;
	}
	
	public void queueRequest (Order[] print) {
		List <Order> printingList = Arrays.asList(print);
		for (int i = 0; i < printingList.size(); i++) {
			Order anOrder = printingList.get(i);
			printList.add(anOrder);
		}
	}
}
