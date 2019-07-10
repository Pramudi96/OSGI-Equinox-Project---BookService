package com.sa.bookstore;

public class OrderList {

	private String NIC;
	private String BookName;
	private int Quantity;
	private double Price;
	
	
	public OrderList(){
		
	}

	public OrderList(String NIC,String BookName,int Quantity,double Price){
		this.NIC = NIC;
		this.BookName =BookName;
		this.Quantity = Quantity;
		this.Price = Price;
	}
	
	public double getPrice() {
		return Price;
	}

	public double setPrice(double price) {
		return Price = price;
	}

	public String getNIC() {
		return NIC;
	}

	public String setNIC(String nIC) {
		return NIC = nIC;
	}

	public String getBookName() {
		return BookName;
	}

	public String setBookName(String bookName) {
		return BookName = bookName;
	}
	public int getQuantity() {
		return Quantity;
	}

	public int setQuantity(int quantity) {
		return Quantity = quantity;
	}
	

}
