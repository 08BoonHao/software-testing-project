package my.edu.utar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Order implements OrderFunctionality{
		private String type;
		private int option;
		private int quantity;
		private String addOption1;
		private String addOption2;
		private List <Order> orderList = new ArrayList <Order>();
		
		public Order () {
			
		}
		
		public Order (String type, int option, int quantity, String addOption1, String addOption2) {
			this.type = type;
			this.option = option;
			this.quantity = quantity;
			this.addOption1 = addOption1;
			this.addOption2 = addOption2;
		}
		
		public Order(Order[] orders) {
			orderList = Arrays.asList(orders);
		}

		public String getType() {
			return type;
		}
		
		public int getOption () {
			return option;
		}
		
		public int getQuantity() {
			return quantity;
		}
		
		public String getAddOption1() {
			return addOption1;
		}
		
		public String getAddOption2() {
			return addOption2;
		}
		
		public void setType(String type) {
			if (type == null)
				throw new IllegalArgumentException("Type cannot be null\n");
			type = type.toUpperCase();
			if (!type.equals("D")&& !type.equals("P"))
				throw new IllegalArgumentException("Invalid type. Please enter again.\n");
			this.type = type;
		}
		
		public void setOption (int option) {
			if (option < 1 || option > 2)
				throw new IllegalArgumentException ("Invalid option. Please enter again.\n");
			this.option = option;
		}
		
		public void setQuantity (int quantity) {
			if (quantity < 1 || quantity > 50)
				throw new IllegalArgumentException ("Invalid quantity. Please enter again.\n");
			this.quantity = quantity;
		}
		
		public void setAddOption1 (String addOption1) {
			if (addOption1 == null)
				throw new IllegalArgumentException ("addOption1 cannot be null.\n");
			addOption1 = addOption1.toUpperCase();
			if (!addOption1.equals("Y")&& !addOption1.equals("N"))
				throw new IllegalArgumentException("Invalid choice. Please enter again.\n");
			this.addOption1 = addOption1;
		}
		
		public void setAddOption2 (String addOption2) {
			if (addOption2 == null)
				throw new IllegalArgumentException ("addOption2 cannot be null.\n");
			addOption2 = addOption2.toUpperCase();
			if (!addOption2.equals("Y")&& !addOption2.equals("N"))
				throw new IllegalArgumentException("Invalid choice. Please enter again.\n");
			this.addOption2 = addOption2;
		}

		public void addCustomerOrder(Order anOrder) {
			if (anOrder == null)
				throw new IllegalArgumentException ("Order cannot be null");
			if (anOrder.getType() == null || (!anOrder.getType().equals("D") && !anOrder.getType().equals("P")))
				throw new IllegalArgumentException ("Order type is incorrect");
			if (anOrder.getOption() < 1 || anOrder.getOption() > 2)
				throw new IllegalArgumentException ("Order option is invalid");
			if (anOrder.getQuantity() < 1 || anOrder.getQuantity() > 50)
				throw new IllegalArgumentException ("Order quantity is out of range");
			if (anOrder.getAddOption1() == null || (!anOrder.getAddOption1().equals("Y") && !anOrder.getAddOption1().equals("N")))
				throw new IllegalArgumentException ("Order additional option 1 is incorrect");
			if (anOrder.getAddOption2() == null || (!anOrder.getAddOption2().equals("Y") && !anOrder.getAddOption2().equals("N")))
				throw new IllegalArgumentException ("Order additional option 2 is incorrect");
			if ((anOrder.getType().equals("D") && anOrder.getAddOption1().equals("Y")) || (anOrder.getType().equals("D") && anOrder.getAddOption2().equals("Y")))
				throw new IllegalArgumentException("Order with Document cannot have high quality paper effect and design effect");
			orderList.add(anOrder);
		}
		
		public Order[] getOrderList(){
			Order [] orders = orderList.toArray(new Order[orderList.size()]);
			return orders;
		}
}

