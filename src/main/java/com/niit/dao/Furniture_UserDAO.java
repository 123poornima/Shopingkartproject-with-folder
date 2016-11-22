package com.niit.dao;

import com.niit.model.Furniture;
import com.niit.model.Furniture_User;

public interface Furniture_UserDAO 
{
    public void addFurnitureUser(Furniture_User user);
    public Furniture_User getFurnitureUser(int id); 
}
