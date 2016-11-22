package com.niit.dao;

import java.util.List;


import com.niit.model.Cart_Details;
//An interface in java is a blueprint of a class. It has static constants and abstract methods only.
public interface Cart_DetailsDAO 
{
  //addcart method initialization
  public void addToFurnitureCart(Cart_Details cart);
  // delete cart method initialization
  public void deleteFurnitureCart(int id);
  //getcart method initialization
  public Cart_Details getFurnitureCart(String p_id);
 
  public List<Cart_Details> furnitureCartList();
  public List<Cart_Details> userFurnitureCartList(String uname);
  
}
