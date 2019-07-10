package com.sa.supplier;

import java.util.HashMap;
import java.util.Scanner;

import org.osgi.framework.ServiceReference;

import com.sa.bookstore.BookStoreImpl;

import java.util.Map.Entry;

public class SupplierImpl {
	public HashMap<String, StoreBooks> SupplierBooks;// This Stores SupplierStock Details
	BookStoreImpl bookStoreRef;
	String BookName, Date, Decision;
	int Quantity;

	public SupplierImpl(BookStoreImpl bookRef) {

		if (bookRef != null) {
			bookStoreRef = bookRef;
			bookStoreRef.fillValues();
		}
		StoreBooks();
	}

	public SupplierImpl() {
		// TODO Auto-generated constructor stub
	}

	public void StoreBooks() {
		// TODO Auto-generated method stub
		SupplierBooks = new HashMap<>();
		SupplierBooks.put("Biology", new StoreBooks("001", "Biology", "Nimal Perera", 100, 1000.00));
		SupplierBooks.put("Physics", new StoreBooks("002", "Physics", "Amal Silva", 50, 2000.00));
		SupplierBooks.put("Chemistry", new StoreBooks("003", "Chemistry", "Sunil Liyanage", 100, 3000.00));
		SupplierBooks.put("Zoology", new StoreBooks("004", "Zoology", "Kamal De  Silva", 200, 1000.00));

	}

	public void RequestBook() {
		// TODO Auto-generated method stub

		System.out.println("Do you Want to Supply a Book  [Yes or No]");
		Scanner sc3 = new Scanner(System.in);
		Decision = sc3.nextLine();
		if (Decision.equalsIgnoreCase("Yes")) {
			System.out.println("Enter BookName  :");
			Scanner sc2 = new Scanner(System.in);
			BookName = sc2.nextLine();
			// System.out.println("Book Available");

			if (containsEntry(BookName)) {
				System.out.println("Book Available");

				System.out.println("Enter Quantity  :");
				Scanner sc1 = new Scanner(System.in);
				Quantity = sc1.nextInt();
				if (Quantity < SupplierBooks.get(BookName).getQuantity()) {
					System.out.println("Available in Our store");

					/*
					 * System.out.println("Enter a Required Date	:"); Scanner sc7 = new
					 * Scanner(System.in); Date = sc7.nextLine();
					 */

					double price = SupplierBooks.get(BookName).getPrice() * Quantity;

					System.out.println("Request for :" + BookName);
					System.out.println("Quantity   : " + Quantity);
					System.out.println("You Have to Pay :" + price);
					// System.out.println("Return :" + Date);
					System.out.println("Do you approve :");
					Scanner sc7 = new Scanner(System.in);
					String response = sc7.nextLine();
					if ("Yes".equalsIgnoreCase(response)) {
						int currentSuppQuantity = getEntry(BookName).getQuantity();
						getEntry(BookName).setQuantity(currentSuppQuantity - Quantity);
						System.out.println(currentSuppQuantity);
						System.out.println("Supplier Book reservation is successful");
						//bookStoreRef.fillValues();
						int currentBookStoreQuantity = bookStoreRef.getBookEntry(BookName).getQuantity();
						bookStoreRef.getBookListMap().get(BookName).setQuantity(currentBookStoreQuantity + Quantity);
						System.out.println("Book reservation is successful");

					}

				} else {
					System.out.println("Not available in Our stores Please check within 2 weeks");
				}

			} else {
				System.out.println("Sorry We Don't Have That Book");
			}

		} else {
			System.out.println("Thank You");
		}

	}


	public boolean containsEntry(String bookName) {
		for (Entry<String, StoreBooks> entry : SupplierBooks.entrySet()) {
			String key = entry.getKey();
			if (SupplierBooks.get(key).getBookName().equalsIgnoreCase(bookName)) {
				return true;
			}
		}
		return false;
	}

	public StoreBooks getEntry(String bookName) {
		for (String name : SupplierBooks.keySet()) {
			if (SupplierBooks.get(name).getBookName().equalsIgnoreCase(bookName)) {
				return SupplierBooks.get(name);
			}
		}
		return null;
	}

	public HashMap<String, StoreBooks> getSupplierBookListMap() {
		return SupplierBooks;
	}

	public void displaySupplierBookList() {
		if (getSupplierBookListMap().isEmpty() == true) {
			System.out.println("Sorry! The Supplier bookStore is empty");
		} else {
			for (Entry<String, StoreBooks> entry : getSupplierBookListMap().entrySet()) {
				// String key = entry.getKey();
				StoreBooks bookObj = entry.getValue();
				System.out.println("The Book ISBN :" + bookObj.getISBN());
				System.out.println("The Book Name :" + bookObj.getBookName());
				System.out.println("The Book Author :" + bookObj.getAuthor());
				System.out.println("The Book Quantity :" + bookObj.getQuantity());
				System.out.println("The Book Price :" + bookObj.getPrice());
			}
		}
	}

}
