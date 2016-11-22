package com.niit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.dao.Furniture_CategoryDAO;
import com.niit.model.Furniture_Category;

@Controller 
public class Furniture_CategoryController
{
	@Autowired
	Furniture_CategoryDAO categoryDAO;
	
	@Autowired
	Furniture_Category category;
	//for add and update category both
		@RequestMapping(value="/category/add", method=RequestMethod.POST)
		public String addFurnitureCategory(@ModelAttribute("category") Furniture_Category category)
		{
			categoryDAO.addFurnitureCategory(category);
			return "redirect:/category";
			//return "category";

		}
		
		@RequestMapping("/category/remove/{c_ID}")
		public String deleteFurnitureCategory(@PathVariable("c_ID") String id, ModelMap model) throws Exception {

			try {
				categoryDAO.deleteFurnitureCategory(id);
				model.addAttribute("message", "Successfully Added");
			} catch (Exception e) {
				model.addAttribute("message", e.getMessage());
				e.printStackTrace();
			}
			// redirectAttrs.addFlashAttribute(arg0, arg1)
			return "redirect:/category";
		}
		

		@RequestMapping("/category/edit/{c_ID}")
		public String editFurnitureCategory(@PathVariable("c_ID") String id, Model model) {
			System.out.println("editCategory");
			model.addAttribute("category", this.categoryDAO.getFurnitureCategory(id));
			model.addAttribute("categoryList", this.categoryDAO.furnitureCategoryList());
			return "category";
		}
		
		
			@RequestMapping(value = "/category", method = RequestMethod.GET)
			public String listFurnitureCategories(Model model){
				model.addAttribute("category", category);
				model.addAttribute("categoryList",this.categoryDAO.furnitureCategoryList());
				return "category";
			
		}
			
		
	
}