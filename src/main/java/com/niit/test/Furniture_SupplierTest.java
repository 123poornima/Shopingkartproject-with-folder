package com.niit.test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.Furniture_SupplierDAO;

import com.niit.model.Furniture_Supplier;

public class Furniture_SupplierTest {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		
		Furniture_SupplierDAO supplierDAO= (Furniture_SupplierDAO) context.getBean("supplierDAO");

		Furniture_Supplier supplier=(Furniture_Supplier) context.getBean("supplier");
		
		
		supplier.setS_ID("242");
		supplier.setS_Name("po");
	
		supplier.setS_Address("DVG");
		supplier.setS_Phoneno("88676757");
		
		supplierDAO.addFurnitureSupplier(supplier);
		
		

	}

}
