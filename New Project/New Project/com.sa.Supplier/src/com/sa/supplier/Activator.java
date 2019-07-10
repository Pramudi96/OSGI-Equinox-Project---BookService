package com.sa.supplier;

import org.osgi.framework.BundleActivator;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.eclipse.core.resources.*;

import com.sa.bookstore.BookStoreImpl;


public class Activator implements BundleActivator {

	ServiceRegistration SupplierReg;
	
	public void start(BundleContext Context) throws Exception {
		System.out.println("Start Supplier");
		ServiceReference bookstoreRef = Context.getServiceReference(BookStoreImpl.class.getName());
		BookStoreImpl bookStoreImplObj = (BookStoreImpl)Context.getService(bookstoreRef);
		SupplierImpl supplier = new SupplierImpl (bookStoreImplObj);
		SupplierReg= Context.registerService(SupplierImpl .class.getName(), supplier, null);
		supplier.RequestBook();
		
	}

	
	public void stop(BundleContext Context) throws Exception {
		System.out.println("Stop Supplier");
		SupplierReg.unregister();
	}

}
