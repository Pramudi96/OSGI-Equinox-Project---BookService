package com.sa.bookstore;

import java.util.HashMap;
import java.util.Map.Entry;

//import org.osgi.framework.ServiceReference;
import java.util.Scanner;

public class BookStoreImpl {

	public String input1, input2, input3, input4, Decision, Decision2;
	public int Quantity, Quantity2;
	public HashMap<String, Book> bookList = new HashMap<>();
	public HashMap<String, ReservedList> reservedList = new HashMap<>();
	public HashMap<String, Employee> employeeD = new HashMap<>();
	Employee employee;

	public BookStoreImpl() {
		fillValues();

	}

	public void fillValues() {
		bookList.put("Biology", new Book("001", "Biology", "Nimal Perera", "123", 100, 1000.00));
		bookList.put("Physics", new Book("002", "Physics", "Amal Silva", "134", 50, 2000.00));
		bookList.put("Chemistry", new Book("003", "Chemistry", "Sunil Liyanage", "145", 100, 3000.00));
		bookList.put("Zoology", new Book("004", "Zoology", "Kamal De  Silva", "156", 200, 1000.00));

	}

	public void Search() {
		System.out.print("Enter BookName:");

		Scanner s = new Scanner(System.in);
		String input1 = s.nextLine();
		System.out.println(input1);

		if (bookList.containsKey(input1)) {
			System.out.println("Book available");

			System.out.println("Enter Quantity:");
			Scanner sc = new Scanner(System.in);
			Quantity = sc.nextInt();

			if (Quantity > bookList.get(input1).getQuantity()) {

				System.out.println("Unfortunately, book is not availble at the current moment!");
				System.out.println("Do you Want to Make an order ?[Yes or No]");
				Scanner sc1 = new Scanner(System.in);
				Decision = sc1.nextLine();

				if (Decision.equalsIgnoreCase("Yes")) {

					System.out.println("Please enter Your NIC number   :");
					Scanner s9 = new Scanner(System.in);
					String Decision2 = s.nextLine();
					System.out.println(Decision2);

					OrderList ordered = new OrderList();
					String p = ordered.setNIC(Decision2);
					String q = ordered.setBookName(input1);
					int r = ordered.setQuantity(Quantity);
					double s1 = ordered.setPrice((r * bookList.get(input1).getPrice()));

					HashMap<String, OrderList> OrderList = new HashMap<>();
					OrderList.put(p, new OrderList(p, q, r, s1));
					for (Entry<String, OrderList> entry : OrderList.entrySet()) {
						OrderList orderObj = entry.getValue();
						System.out.println("NIC	:" + orderObj.getNIC());
						System.out.println("BookName	:" + orderObj.getBookName());
						System.out.println("Quantity	:" + orderObj.getQuantity());
						System.out.println("You Have To Pay   :" + orderObj.getPrice());
					}

					System.out.println("Your order has been accepted ,please check again within two weeks");
				} else {
					System.out.println("Thank You... Please visit us again");
				}

			} else {
				System.out.println("You can reserve now. Do you want to reserve? [Yes or No]");
				Scanner s1 = new Scanner(System.in);
				String input2 = s.nextLine();
				System.out.println(input2);

				if (input2.equalsIgnoreCase("Yes")) {
					System.out.println("Please enter Your NIC number   :");
					Scanner s4 = new Scanner(System.in);
					String input4 = s.nextLine();
					System.out.println(input4);

					ReservedList reserved = new ReservedList();
					String a = reserved.setNIC(input4);
					String b = reserved.setBookName(input1);
					int c = reserved.setQuantity(Quantity);
					double d = reserved.setPrice((c * bookList.get(input1).getPrice()));

					HashMap<String, ReservedList> reservedList = new HashMap<>();
					reservedList.put(a, new ReservedList(a, b, c, d));
					for (Entry<String, ReservedList> entry : reservedList.entrySet()) {
						ReservedList reserveObj = entry.getValue();
						System.out.println("NIC	:" + reserveObj.getNIC());
						System.out.println("BookName	:" + reserveObj.getBookName());
						System.out.println("Quantity	:" + reserveObj.getQuantity());
						System.out.println("You Have To Pay   :" + reserveObj.getPrice());

					}

					System.out.println("Reserved Book For You");
				}

				else
					System.out.println("Thank you... Please visit us agian.");
			}
		} else {
			System.out.println("Sorry, we do not sell that book");

		}

	}

	public HashMap<String, Book> getBookListMap() {
		return bookList;
	}

	public HashMap<String, ReservedList> getreservedListMap() {
		return reservedList;
	}

	public void displayBookList() {
		if (getBookListMap().isEmpty() == true) {
			System.out.println("Sorry! The bookStore is empty");
		} else {
			for (Entry<String, Book> entry : getBookListMap().entrySet()) {
				// String key = entry.getKey();
				Book bookObj = entry.getValue();
				System.out.println("The Book ISBN :" + bookObj.getISBN());
				System.out.println("The Book Name :" + bookObj.getBookName());
				System.out.println("The Book Author :" + bookObj.getAuthor());
				System.out.println("The Book Quantity :" + bookObj.getQuantity());
			}
		}

	}

	public void displayReservedList() {
		if (getreservedListMap().isEmpty() == true) {
			System.out.println("Sorry ! The reserved list is empty");
		}

		else {
			for (Entry<String, ReservedList> entry : getreservedListMap().entrySet()) {
				ReservedList reserveObj = entry.getValue();
				System.out.println("The reserved person's NIC No :" + reserveObj.getNIC());
				System.out.println("The reserved Book Name :" + reserveObj.getBookName());
				System.out.println("The reserved quantity :" + reserveObj.getQuantity());
			}
		}
	}

	public void salaryCalculation() {
		employeeD.put("E100", new Employee("E100", "Nimal", 10, 10000.00));
		employeeD.put("E200", new Employee("E200", "Kamal", 20, 20000.00));
		employeeD.put("E300", new Employee("E300", "Amal", 4, 15000.00));
		employeeD.put("E400", new Employee("E400", "Sunil", 1, 30000.00));

		System.out.println("Enter Employee Id before");
		Scanner sc = new Scanner(System.in);
		String input5 = sc.nextLine();

		if (employeeD.containsKey(input5)) {

			if (employeeD.get(input5).getOtHrs() >= 10) {
				double Salary = employeeD.get(input5).getBasicSalary() + (employeeD.get(input5).getOtHrs() * 2000.00);

				System.out.println("Employee No		:" + employeeD.get(input5).getEmpNo());
				System.out.println("Employee Name	:" + employeeD.get(input5).getEmpName());
				System.out.println("Your Salary	:" + Salary);

			} else {

				double Salary = employeeD.get(input5).getBasicSalary() + (employeeD.get(input5).getOtHrs() * 1000.00);
				System.out.println("Employee No		:" + employeeD.get(input5).getEmpNo());
				System.out.println("Employee Name	:" + employeeD.get(input5).getEmpName());
				System.out.println("Your Salary	:" + Salary);

			}

		} else {
			System.out.println("Wrong Employee ID");

		}

	}

	public Book getBookEntry(String bookName) {
		for (String name : bookList.keySet()) {
			System.out.println(bookList.get(name).getBookName());
			if (bookList.get(name).getBookName().equalsIgnoreCase(bookName)) {
				System.out.println(bookList.get(bookName).getBookName());
				return bookList.get(name);
			}
		}
		System.out.println(bookName);
		return null;
	}

}
