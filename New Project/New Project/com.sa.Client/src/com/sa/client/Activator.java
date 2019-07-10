package com.sa.client;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.sa.bookstore.BookStoreImpl;

public class Activator implements BundleActivator {

	ServiceReference ClientReference;
	
	public void start(BundleContext Context) throws Exception {
		 System.out.println("Start Client");
			ClientReference = Context.getServiceReference(BookStoreImpl.class.getName());
			BookStoreImpl bookStore = (BookStoreImpl) Context.getService(ClientReference);
			bookStore.Search();
			
			
	}

	
	public void stop(BundleContext Context) throws Exception {
		System.out.println("Stop Client");
		Context.ungetService(ClientReference);	
	}

}
