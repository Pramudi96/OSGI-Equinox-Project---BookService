package com.sa.supplier;

public class StoreBooks {
	private String ISBN;
	private String BookName;
	private String Author;
	private int Quantity;
	private double Price;
	
	public StoreBooks(String ISBN, String BookName, String Author,int Quantity,double Price){
		this.ISBN = ISBN;
		this.BookName= BookName;
		this.Author = Author;
		this.Quantity= Quantity;
		this.Price = Price;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
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

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}


}
