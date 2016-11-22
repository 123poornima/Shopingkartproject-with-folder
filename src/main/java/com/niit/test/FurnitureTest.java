package com.niit.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.FurnitureDAO;
import com.niit.model.Furniture;

public class FurnitureTest {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		FurnitureDAO productDAO=(FurnitureDAO) context.getBean("productDAO");
		System.out.println("success");
		
		Furniture product=(Furniture)context.getBean("product");
		
		
		product.setp_id("01");
		product.setp_name("tmh");
		product.setp_price(200);
		product.setp_description("900");
				
		productDAO.addFurniture(product);

	}

}
