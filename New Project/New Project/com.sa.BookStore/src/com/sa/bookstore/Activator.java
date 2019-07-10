package com.sa.bookstore;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
//import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
	
	ServiceRegistration bookStoreRegistration;
	

	public void start(BundleContext Context) throws Exception {
		System.out.println("BookStore Start");
		BookStoreImpl bookStore = new BookStoreImpl();
		//System.out.println(bookStore);
		bookStoreRegistration= Context.registerService(BookStoreImpl.class.getName(), bookStore, null);
	
		
	}

	
	public void stop(BundleContext Context) throws Exception {
		System.out.println("BookStore Stop");
		bookStoreRegistration.unregister();
		
	}

}
