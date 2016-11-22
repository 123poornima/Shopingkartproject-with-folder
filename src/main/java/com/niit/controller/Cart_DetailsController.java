package com.niit.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.dao.Cart_DetailsDAO;
import com.niit.dao.Furniture_CategoryDAO;
import com.niit.dao.FurnitureDAO;
import com.niit.dao.Furniture_UserDAO;
import com.niit.model.Cart_Details;
import com.niit.model.Furniture_Category;
import com.niit.model.Furniture;
import com.niit.model.Furniture_User;

@Controller
public class Cart_DetailsController 
{
	
 @Autowired(required=true)
 Cart_Details cart;
 
 @Autowired(required=true)
 Cart_DetailsDAO cartDAO;
 
 @Autowired(required=true)
 Furniture_CategoryDAO categoryDAO;
 
 @Autowired(required=true)
 FurnitureDAO productDAO;
 
 @Autowired(required=true)
 Furniture product;
 
 @Autowired(required=true)
 Furniture_UserDAO userDAO;
	
 	@Autowired(required=true)
   private Furniture_User user;
   
   
	@RequestMapping(value = "/myCart", method = RequestMethod.GET)
	public String myCart(Model model,Principal principal)
	{
		try
		{
		model.addAttribute("cart",new Cart_Details());
		model.addAttribute("cartList",this.cartDAO.userFurnitureCartList(principal.getName()));
		model.addAttribute("category",new Furniture_Category());
		model.addAttribute("categoryList",this.categoryDAO.furnitureCategoryList());
		model.addAttribute("displayCart","true");
		
		
		int i,j=0;
		int s=0;
		int n=cartDAO.userFurnitureCartList(principal.getName()).size();
		System.out.println(n);
		for(i=0;i<n;i++)
		{
			s=s+cartDAO.userFurnitureCartList(principal.getName()).get(i).getPrice();
		}
		System.out.print(s);
		model.addAttribute("sum",s);
		
		}
		catch(Exception ex)
		{
			System.out.println("ex.getMessage");
		}
		return "cart";
		
		
	}
	
	@RequestMapping(value = "cart/add/{p_id}", method = RequestMethod.GET)
	public String addToCart(@PathVariable("p_id") String id, HttpServletRequest request ,Principal principal)
	{
		try
		{
		
		Furniture product=productDAO.getFurniture(id);
		//User user = userDAO.getUser(id);
		Cart_Details cart=new Cart_Details();   		
		cart.setPrice(product.getp_price());
		cart.setP_id(product.getp_id());
		cart.setP_name(product.getp_name());
		cart.setQuantity(1);
		cart.setU_id(principal.getName());
		cart.setStatus("N");
		
		cartDAO.addToFurnitureCart(cart);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return "redirect:/";
		
		
		
	}
	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public String checkout(Model model,Principal principal)
	{
		int i,j=0;
		int s=0;
		int n=cartDAO.userFurnitureCartList(principal.getName()).size();
		System.out.println(n);
		for(i=0;i<n;i++)
		{
			s=s+cartDAO.userFurnitureCartList(principal.getName()).get(i).getPrice();
		}
		System.out.print(s);
		model.addAttribute("sum",s);
		model.addAttribute("cart",new Cart_Details());
		model.addAttribute("cartList",this.cartDAO.userFurnitureCartList(principal.getName()));
		
		return "/checkout";
	    
	}
	@RequestMapping("/cart/delete/{id}")
	public String deleteCart(@PathVariable("id") int id,Model model)
	{
		cartDAO.deleteFurnitureCart(id);
		return "redirect:/myCart";
	}
	
	
	
	
	
	@RequestMapping("/thanks")
	public String getThanks()
	{
		return "thanks";
	}
	
}
