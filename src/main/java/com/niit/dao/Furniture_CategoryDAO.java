package com.niit.dao;

import java.util.List;

import com.niit.model.Furniture_Category;


public interface Furniture_CategoryDAO 
{
	public void addFurnitureCategory(Furniture_Category category);
	public Furniture_Category getFurnitureCategory(String id);
	public void deleteFurnitureCategory(String id);
	public List<Furniture_Category> furnitureCategoryList();
	public Furniture_Category getFurnitureCategoryName(String name);


}