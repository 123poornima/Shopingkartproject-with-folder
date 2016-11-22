package com.niit.dao;

import java.util.List;

import com.niit.model.Furniture_Supplier;
import com.niit.model.Furniture_Supplier;

public interface Furniture_SupplierDAO 
{
	public void addFurnitureSupplier (Furniture_Supplier supplier);
	 public Furniture_Supplier getFurnitureSupplier(String id);
	 public void deleteFurnitureSupplier(String id);
	 public List<Furniture_Supplier> furnitureSupplierList();
	public Furniture_Supplier getFurnitureSupplireName(String name);
	
}

