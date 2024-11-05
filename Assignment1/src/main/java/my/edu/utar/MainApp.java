package my.edu.utar;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
 * Display class created at here in order to show the IllegalArgumentException message for the user if they input invalid value
 */
class Display{
	Scanner input = new Scanner(System.in);
	
	public void showToScreen(String message) {
		System.out.print(message);
	}
}

public class MainApp {
	private static Order o = new Order ();
	private static Printing p = new Printing ();
	private static Display d = new Display ();
	public static void main(String[] args) {
		System.out.println("                                Welcome                                ");
		System.out.println("                Below is the details of printing services              ");
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("|    Type    |        Option        |  Quantity  |  Charge(RM/piece)  |");
		System.out.println("|---------------------------------------------------------------------|");
		System.out.println("|            |                      |     <5     |        0.50        |");
		System.out.println("|            |    Black & White     |    5-10    |        0.40        |");
		System.out.println("|            |                      |   11-20    |        0.30        |");
		System.out.println("|            |                      |   21-50    |        0.20        |");
		System.out.println("|  Document  |--------------------------------------------------------|");
		System.out.println("|            |                      |     <5     |        1.00        |");
		System.out.println("|            |        Color         |    5-10    |        0.90        |");
		System.out.println("|            |                      |   11-20    |        0.80        |");
		System.out.println("|            |                      |   21-50    |        0.70        |");
		System.out.println("|---------------------------------------------------------------------|");
		System.out.println("|            |                      |     <5     |        1.00        |");
		System.out.println("|            |      Normal(4R)      |    5-10    |        0.90        |");
		System.out.println("|            |                      |   11-20    |        0.75        |");
		System.out.println("|            |                      |   21-50    |        0.50        |");
		System.out.println("|   Photo    |--------------------------------------------------------|");
		System.out.println("|            |                      |     <5     |        1.20        |");
		System.out.println("|            |       Passport       |    5-10    |        0.95        |");
		System.out.println("|            |                      |   11-20    |        0.85        |");
		System.out.println("|            |                      |   21-50    |        0.75        |");
		System.out.println("|---------------------------------------------------------------------|");
		System.out.println();
		System.out.println("             ---------------------------------------------             ");
		System.out.println("             |  Additional Option  | Surcharge(RM/piece) |");
		System.out.println("             |-------------------------------------------|");
		System.out.println("             | High quality paper  |        0.10         |");
		System.out.println("             | Design effect       |        0.15         |");
		System.out.println("             ---------------------------------------------");
		
		getCustomerOrder();
		showCharge();
		Charge c = new Charge(o, p);
		c.passPrintingRequest();
		showPrintingRequest();
	}

	public static void getCustomerOrder () {
		String choice;
		Scanner scanner = new Scanner (System.in);
		String type, addOption1, addOption2;
		int option, quantity;
		
		do 
		{		
			//Get Order Type
			do {
				System.out.println("Enter printing type (D for document, P for Photo): ");
				type = scanner.next();
				type = type.toUpperCase();
				try {
					o.setType(type);
				}
				catch(IllegalArgumentException iae) {
					d.showToScreen(iae.getMessage());
				}
			} while (!type.equals("D") && !type.equals("P"));
			
			
			//Get Order Option
			if (type.equals("D")) {
				do {
					System.out.println("1. Black & White\n2. Colour\nChoose an option(1/2): ");
					option = scanner.nextInt();
					try {
						o.setOption(option);
					}
					catch(IllegalArgumentException iae) {
						d.showToScreen(iae.getMessage());
					}
				} while (option != 1 && option != 2);
			}
			else {
				do {
					System.out.println("1. Normal(4R)\n2. Passport\nChoose an option(1/2): ");
					option = scanner.nextInt();
					try {
						o.setOption(option);
					}
					catch(IllegalArgumentException iae) {
						d.showToScreen(iae.getMessage());
					}
				} while (option != 1 && option != 2);
			}
			
			//Get Order Quantity
			do {
				System.out.println("Enter quantity (1 to 50): ");
				quantity = scanner.nextInt();
				try {
					o.setQuantity(quantity);
				}
				catch(IllegalArgumentException iae) {
					d.showToScreen(iae.getMessage());
				}
			} while (quantity < 1 || quantity > 50);
			
			//Get Additional Option 1 (High quality paper)
			if (type.equals("P")) {
				do {
					System.out.println("Do you want to print your photo on high quality paper (Y/N): ");
					addOption1 = scanner.next();
					addOption1 = addOption1.toUpperCase();
					try{
						o.setAddOption1(addOption1);
					}
					catch(IllegalArgumentException iae) {
						d.showToScreen(iae.getMessage());
					}
				} while (!addOption1.equals("Y") && !addOption1.equals("N"));
			}
			else 
				addOption1 = "N";
				
			//Get Additional Option 2 (Design Effect)
			if (type.equals("P")) {
				do {
					System.out.println("Do you want to have design effect on your photo (Y/N): ");
					addOption2 = scanner.next();
					addOption2 = addOption2.toUpperCase();
					try{
						o.setAddOption2(addOption2);
					}
					catch(IllegalArgumentException iae) {
						d.showToScreen(iae.getMessage());
					}
				} while (!addOption2.equals("Y") && !addOption2.equals("N"));
			}
			else 
				addOption2 = "N";
				
			//create an order and add it to orderList
			Order anOrder = new Order (type, option, quantity, addOption1, addOption2);
			o.addCustomerOrder(anOrder);
			System.out.println("Order added successfully");
			
			//Any other order to add
			do {
				System.out.print("Do you want to add other order(Y/N): ");
				choice = scanner.next();
				choice = choice.toUpperCase();
				if (!choice.equals("Y") && !choice.equals("N"))
					System.out.println("Error.\nPlease enter again");
			} while (!choice.equals("Y") && !choice.equals("N"));
		} while(choice.equals("Y"));
	}
	
	public static void showCharge() {
		Charge ch = new Charge(o, p);
		Order [] orders = o.getOrderList();
		List <Order> orderList = Arrays.asList(orders);
		System.out.println(orderList.size());
		System.out.println("No.\tType\t\tOption\t\tQuantity\tHigh Quality Paper\tDesign Effect\tSubCharge(RM)");
		for (int i = 0; i < orderList.size(); i++) {
			System.out.print((i + 1) + ". \t");
			Order anOrder = orderList.get(i);
			if (anOrder.getType().equals("D") || anOrder.getType().equals("d")) {
				System.out.print("Document\t");
				if (anOrder.getOption() == 1) 
					System.out.print("Black & White\t" + anOrder.getQuantity() + "\t\t-\t\t\t-\t\t" + Math.round(ch.calDocCharge(anOrder)*100.0)/100.0 + "\n");
				else
					System.out.print("Colour\t\t" + anOrder.getQuantity() + "\t\t-\t\t\t-\t\t" + Math.round(ch.calDocCharge(anOrder)*100.0)/100.0 + "\n");
			}
			else {
				System.out.print("Photo\t\t");
				if (anOrder.getOption() == 1) 
					System.out.print("Normal(4R)\t" + anOrder.getQuantity() + "\t\t" + anOrder.getAddOption1() + "\t\t\t" + anOrder.getAddOption2() + "\t\t" + Math.round(ch.calPhotoCharge(anOrder)*100.0)/100.0 + "\n");
				else
					System.out.print("Passport\t" + anOrder.getQuantity() + "\t\t" + anOrder.getAddOption1() + "\t\t\t" + anOrder.getAddOption2() + "\t\t" + Math.round(ch.calPhotoCharge(anOrder)*100.0)/100.0 + "\n");
			}
		}
		Order [] arrayToReturn = new Order [orderList.size()];
		arrayToReturn = orderList.toArray(arrayToReturn);
		System.out.println("Total: RM " + Math.round(ch.getTotalCharge()*100.0)/100.0);
	}
	
	private static void showPrintingRequest() {
		System.out.println("\nPrinting Request");
		System.out.println("No.\tType\t\tOption\t\tQuantity\tHigh Quality Paper\tDesign Effect");
		Order [] prints= p.getPrintList();
		List <Order> printList = Arrays.asList(prints);
		Order order;
		for (int i = 0; i < printList.size(); i++) {
			System.out.print((i + 1) + ".\t");
			order = printList.get(i);
			if (order.getType().equals("D")) {
				System.out.print("Document\t");
				if (order.getOption() == 1) 
					System.out.print("Black & White\t" + order.getQuantity() + "\t\t-\t\t\t-\t\t" + "\n");
				else
					System.out.print("Colour\t\t" + order.getQuantity() + "\t\t-\t\t\t-\t\t" + "\n");
			}
			else {
				System.out.print("Photo\t\t");
				if (o.getOption() == 1) 
					System.out.print("Normal(4R)\t" + order.getQuantity() + "\t\t" + order.getAddOption1() + "\t\t\t" + order.getAddOption2() + "\t\t" + "\n");
				else
					System.out.print("Passport\t" + order.getQuantity() + "\t\t" + order.getAddOption1() + "\t\t\t" + order.getAddOption2() + "\t\t" + "\n");
			}		
		}	
		System.out.println("Total Printing Request: " + p.getPrintingRequest());
	}
}

