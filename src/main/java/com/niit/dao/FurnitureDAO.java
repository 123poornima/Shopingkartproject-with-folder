package com.niit.dao;

import java.util.List;

import com.niit.model.Furniture_Category;
import com.niit.model.Furniture;

public interface FurnitureDAO 
{
	public void addFurniture(Furniture product);
	  public Furniture getFurniture(String id); 	   
	   public void deleteFurniture(String id);   	   
	   public List<Furniture> furnitureList(); 	   
	   public Furniture getFurnitureName(String name);
	   
}
