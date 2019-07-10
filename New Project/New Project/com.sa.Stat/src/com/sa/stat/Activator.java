package com.sa.stat;

import org.osgi.framework.BundleActivator;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.sa.bookstore.BookStoreImpl;
import com.sa.supplier.SupplierImpl;

//import com.sa.bookstore.BookStoreImpl;

/*import com.sa.supplier.SupplierImpl;*/

public class Activator implements BundleActivator {
	
	ServiceReference StatRef;

	public void start(BundleContext Context) throws Exception {
		System.out.println("Start Stat");
		StatRef = Context.getServiceReference(BookStoreImpl.class.getName());
		BookStoreImpl bookStore = (BookStoreImpl) Context.getService(StatRef);
		StatRef = Context.getServiceReference(SupplierImpl.class.getName());
		SupplierImpl supplier = (SupplierImpl) Context.getService(StatRef);
		bookStore.displayBookList();
		bookStore.displayReservedList();
		supplier.displaySupplierBookList();
	}

	
	public void stop(BundleContext Context) throws Exception {
		System.out.println("Stop Stat");
		Context.ungetService(StatRef);
	}

}
