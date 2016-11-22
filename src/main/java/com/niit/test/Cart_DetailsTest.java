package com.niit.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.Cart_DetailsDAO;

import com.niit.model.Cart_Details;


public class Cart_DetailsTest {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		
		Cart_DetailsDAO cartDAO= (Cart_DetailsDAO) context.getBean("cartDAO");

		Cart_Details cart=(Cart_Details) context.getBean("cart");
		
		
		cart.setP_name("pooh");
		cart.setPrice(435);
		cart.setQuantity(5);
		cart.setStatus("pending");
		cart.setU_id("1");
		cart.setP_id("3");
		
		cartDAO.addToFurnitureCart(cart);

	}

}
