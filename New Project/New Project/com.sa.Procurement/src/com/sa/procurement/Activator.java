package com.sa.procurement;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.sa.supplier.SupplierImpl;


public class Activator implements BundleActivator {

	ServiceReference Pref;

	public void start(BundleContext Context) throws Exception {
		System.out.println("Start Procurement");
		
		Pref = Context.getServiceReference(SupplierImpl.class.getName());
		SupplierImpl supplier = (SupplierImpl) Context.getService(Pref);
		supplier.RequestBook();
	}

	
	public void stop(BundleContext Context) throws Exception {
		System.out.println("Stop Procurement");
		Context.ungetService(Pref);
	}

}
