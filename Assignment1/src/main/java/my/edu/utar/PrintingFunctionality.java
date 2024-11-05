package my.edu.utar;

public interface PrintingFunctionality {
	public void queueRequest(Order[] print);
	public int getPrintingRequest();
	public Order[] getPrintList ();

}
