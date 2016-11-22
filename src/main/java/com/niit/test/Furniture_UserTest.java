package com.niit.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.Furniture_UserDAO;

import com.niit.model.Furniture_User;

public class Furniture_UserTest 
{

	public static void main(String[] args) 
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		
		Furniture_UserDAO userDAO= (Furniture_UserDAO) context.getBean("userDAO");

		Furniture_User user=(Furniture_User) context.getBean("user");
		
		
		user.setName("pooh");
		user.setMailId("pooh@gmail.com");
		user.setPassword("12345");
		user.setAddress("DVG");
		user.setPhoneNo("88676757");
		
		userDAO.addFurnitureUser(user);
		
		
	}

}
