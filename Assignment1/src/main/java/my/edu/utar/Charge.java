package my.edu.utar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Charge {
	Order o;
	Printing print;
	List <Order> orderList;
	List <Order> printList; 
	
	public Charge() {
		
	}
	
	public Charge (Order order, Printing print) {
		this.o = order;
		this.print = print;
	}
	
	public Order[] getPrintList(){
		Order [] prints = printList.toArray(new Order[printList.size()]);
		return prints;
	}
	
	public void setPrintList (List <Order> printList) {
		this.printList = printList;
	}
	
	public double getTotalCharge () {
		Order [] orders = o.getOrderList();
		orderList = Arrays.asList(orders);
		
		double total = 0;
		double price;
		for (int i = 0; i < orderList.size(); i++) {
			Order anOrder = orderList.get(i);
			
			//count Total Charge part
			if (anOrder.getType().equals("D") || anOrder.getType().equals("d")) 
				price = calDocCharge(anOrder);
			else 
				price = calPhotoCharge(anOrder);
			total += price;
			price = 0;
		}
		total = Math.round(total*100.0)/100.0;
		return total;
	}
	
	public double calDocCharge(Order anOrder) {
		double price = 0;
		if (anOrder.getOption() == 1) {
			if (anOrder.getQuantity()> 0 && anOrder.getQuantity() < 5)
				price =  anOrder.getQuantity() * 0.5;
			else if (anOrder.getQuantity() < 11)
				price = anOrder.getQuantity() * 0.4;
			else if (anOrder.getQuantity() < 21)
				price = anOrder.getQuantity() * 0.3;
			else 
				price = anOrder.getQuantity() * 0.2;
		}
		else {
			if (anOrder.getQuantity() > 0 && anOrder.getQuantity() < 5)
				price = anOrder.getQuantity() * 1;
			else if (anOrder.getQuantity() < 11)
				price = anOrder.getQuantity() * 0.9;
			else if (anOrder.getQuantity() < 21)
				price = anOrder.getQuantity() * 0.8;
			else
				price = anOrder.getQuantity() * 0.7;
		}
		return price;
	}

	public double calPhotoCharge (Order anOrder) {
		double price = 0;
		
		if (anOrder.getOption() == 1) {
			if (anOrder.getQuantity() > 0 && anOrder.getQuantity() < 5)
				price = anOrder.getQuantity() * 1;
			else if (anOrder.getQuantity() < 11)
				price = anOrder.getQuantity() * 0.9;
			else if (anOrder.getQuantity() < 21)
				price = anOrder.getQuantity() * 0.75;
			else
				price = anOrder.getQuantity() * 0.5;
		}
		else {
			if (anOrder.getQuantity() > 0 && anOrder.getQuantity() < 5)
				price = anOrder.getQuantity() * 1.2;
			else if (anOrder.getQuantity() < 11)
				price = anOrder.getQuantity() * 0.95;
			else if (anOrder.getQuantity() < 21)
				price = anOrder.getQuantity() * 0.85;
			else
				price = anOrder.getQuantity() * 0.75;
		}
		
		if (anOrder.getAddOption1().equals("Y") || anOrder.getAddOption1().equals("y"))
			price = price + anOrder.getQuantity() * 0.1;
		
		if (anOrder.getAddOption2().equals("Y") || anOrder.getAddOption2().equals("y"))
			price = price + anOrder.getQuantity() * 0.15;
		price = Math.round(price*100.0)/100.0;
		return price;
	}
	
	/*
	 * Steps to arrange the orderList as printing request list
	 * 1. Copy the orderList to another array list
	 * 2. Compare the orders in the array list
	 * 3. If there are two orders same for document, if the option is the same:
	 * 3.1 Get the quantity of the two orders.
	 * 3.2 Remove the two orders from the array list
	 * 3.3 Add another orders to the array list, with the type, and option is the same as the two orders, 
	 * and the quantity of the order sum of the two orders
	 * 4. If there are two orders same for photo, if the option, addOption1, and addOption2 are same:
	 * 3.1 Get the quantity of the two orders.
	 * 3.2 Remove the two orders from the array list
	 * 3.3 Add another orders to the array list, with the type, option, addOption1, and addOption2 is the 
	 * same as the two orders, and the quantity of the order sum of the two orders
	 */
	public void passPrintingRequest () {
		Order [] orders = o.getOrderList();
		orderList = Arrays.asList(orders);
		
		List <Order> printingList = new ArrayList <Order> (); 
		Order order1, order2;
		int quantity;
		for (int i = 0; i < orderList.size(); i++) {
			order1 = orderList.get(i);
			printingList.add(order1);
		}
	
		int k = 0;
		while (k < printingList.size()) {
			int m = k + 1;
			while (m < printingList.size()) {
				order1 = printingList.get(k);
				order2 = printingList.get(m);
				if (order1.getType().equals("D") || order1.getType().equals("d")) {
					if (order1.getType().equals(order2.getType()) && order1.getOption() == order2.getOption()) {
						quantity = order1.getQuantity() + order2.getQuantity();
						printingList.remove(m);
						printingList.remove(k);
						printingList.add(new Order(order1.getType(), order1.getOption(), quantity, order1.getAddOption1(), order1.getAddOption2()));
						m = k + 1;
						k = 0;
					}	
					else {
						m++;
					}
				}
				else {
					if (order1.getType().equals(order2.getType()) && order1.getOption() == order2.getOption() && order1.getAddOption1().equals(order2.getAddOption1()) && order1.getAddOption2().equals(order2.getAddOption2())) {
						quantity = order1.getQuantity() + order2.getQuantity();
						printingList.remove(m);
						printingList.remove(k);
						printingList.add(new Order(order1.getType(), order1.getOption(), quantity, order1.getAddOption1(), order1.getAddOption2()));
						m = k + 1;
						k = 0;
					}	
					else {
						m++;
					}
				}
			}
			k++;
		}
		setPrintList(printingList);
		Order [] prints = printingList.toArray(new Order[printingList.size()]);
		print.queueRequest(prints);
	}
	
}

