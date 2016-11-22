package com.niit.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.Cart_DetailsDAO;
import com.niit.dao.Furniture_CategoryDAO;
import com.niit.dao.Furniture_UserDAO;
import com.niit.model.Furniture_Category;
import com.niit.model.Furniture_User;
/*//===================================================================
The controller method sends object back to the dispatcher servlet
The dispatcher servlet now would find out the exact path of the view which is present in 
the project using view resolver class.
The JSP page responds back to the request and sends back to dispatcher servlet
The DS inturn sends response prepared by JSP file to the client browser.
=========================================================================*/
/* Controller-controller annotation on top of java class then it will consider as spring controller.
BENIFITS==we need not extend homecontroller class from specific base class or implement from any interface 
we need not put its entry in dispatcher-servlet.xml file 
  */
@Controller
public class HomeController
{
	
	@Autowired
	Furniture_CategoryDAO categoryDAO;
	
	@Autowired
	Furniture_Category category;
	
	@Autowired
	Furniture_UserDAO userDAO;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getLoad(Model model){
		System.out.println("on load");
		model.addAttribute("category", category);
		model.addAttribute("categoryList",this.categoryDAO.furnitureCategoryList());
		return "index";
	
}
	@RequestMapping(value = "/onLoad", method = RequestMethod.GET)
	public String onLoad(Model model){
		System.out.println("on load");
		model.addAttribute("category", category);
		model.addAttribute("categoryList",this.categoryDAO.furnitureCategoryList());
		return "index";
	
}
	
	@RequestMapping("/register")
	public ModelAndView getRegister(Model m,@RequestParam(value="error",required=false)String error)
	{
		m.addAttribute("user",new Furniture_User());
		ModelAndView model=new ModelAndView("signUp");
				
	    return model;
	}
	
	@RequestMapping(value="register/add",method=RequestMethod.POST)
	public String addUser(Model model, @Valid @ModelAttribute("user") Furniture_User user)
	{
		//user.setRole("ROLE_USER");
		
		userDAO.addFurnitureUser(user);
		ModelAndView mv=new ModelAndView("/");
		mv.addObject("success","data updated sucessfully");
		return "redirect:/";
		
	}
	
	
	
	@RequestMapping(value="/user")
	public String getUser()
	{
		return "login";
	}
	
	@RequestMapping(value="/login")
	public String  login(@RequestParam(value="error",required=false)String error,@RequestParam(value="logout",required=false) String logout,Model model)
	{
		if(error!=null)
		{
			System.out.println("Error..");
			model.addAttribute("loginerror","...Invalid username and password");
		}
		
		if(logout!=null)
		{
			System.out.println("logout called..");
			model.addAttribute("loginmsg","...you have been logged out");
		}
		
		return "login";
	}
	
	@RequestMapping(value="/payment",method=RequestMethod.POST)
	public String getFurniturePayment(Model model, @Valid @ModelAttribute("user") Furniture_User user)
	{
		userDAO.addFurnitureUser(user);
		ModelAndView mv=new ModelAndView("/");
		mv.addObject("success","order placed sucessfully");
		return "redirect:/";
		//return "payment";
	}
	
    @RequestMapping(value="/admin")
    public String getAdmin()
    {
    	return "adminHome";
    }
	
    @RequestMapping(value="/aboutUs")
    public String about()
    {
    	return "aboutUs";
    }
    
    @RequestMapping(value="/productList")
    public String getFurnitureProductList()
    {
    	return "productList";
    }
	
    
}
