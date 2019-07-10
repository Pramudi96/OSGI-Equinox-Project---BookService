package com.sa.employee;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.sa.bookstore.BookStoreImpl;


public class Activator implements BundleActivator {

	ServiceReference EmployeeReference;
	
	
	public void start(BundleContext Context) throws Exception {
		System.out.println("Start Employee");
		EmployeeReference = Context.getServiceReference(BookStoreImpl.class.getName());
		BookStoreImpl bookstore = (BookStoreImpl) Context.getService(EmployeeReference);
		bookstore.salaryCalculation();
		

		
	}

	
	public void stop(BundleContext Context) throws Exception {
		System.out.println("Stop Employee");
		Context.ungetService(EmployeeReference);
	}
}
