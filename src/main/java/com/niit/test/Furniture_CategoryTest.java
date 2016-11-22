package com.niit.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.Furniture_CategoryDAO;
import com.niit.model.Furniture_Category;



public class Furniture_CategoryTest
{
	public static void main(String[] args) 
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		
		Furniture_CategoryDAO categoryDAO= (Furniture_CategoryDAO) context.getBean("categoryDAO");

		Furniture_Category category=(Furniture_Category) context.getBean("category");
		
		
		category.setc_ID("789");
		category.setc_Name("poohhh");
		category.setC_Description("fihhh");
		
		
		categoryDAO.addFurnitureCategory(category);
		
		
	}
}
