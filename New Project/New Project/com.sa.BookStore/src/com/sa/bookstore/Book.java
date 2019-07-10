package com.sa.bookstore;

public class Book {
	
	private String ISBN;
	private String BookName;
	private String Author;
	private String SupplierID;
	private int Quantity;
	private double Price;
	
	public Book(String ISBN,String BookName,String Author,String SupplierID,int Quantity,double Price){
		this.ISBN =ISBN;
		this.BookName =BookName;
		this.Author =Author;
		this.SupplierID = SupplierID;
		this.Quantity =Quantity;
		this.Price = Price;
		
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getBookName() {
		return BookName;
	}

	public void setBookName(String bookName) {
		BookName = bookName;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public String getSupplierID() {
		return SupplierID;
	}

	public void setSupplierID(String supplierID) {
		SupplierID = supplierID;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}
	
	
	
	

}
