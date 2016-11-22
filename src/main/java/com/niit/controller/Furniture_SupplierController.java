package com.niit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.dao.Furniture_SupplierDAO;
import com.niit.model.Furniture_Supplier;

@Controller
public class Furniture_SupplierController 
{
	@Autowired
	Furniture_SupplierDAO supplierDAO;
	
	@Autowired
	Furniture_Supplier supplier;
	
	@RequestMapping(value="/supplier/add", method=RequestMethod.POST)
	public String addFurnitureSupplier(@ModelAttribute("supplier") Furniture_Supplier supplier)
	{

		
		supplierDAO.addFurnitureSupplier(supplier);

		return "redirect:/supplier";
		//return "supplier";
	}
	@RequestMapping("supplier/remove/{s_ID}")
	public String deleteFurnitureSupplier(@PathVariable("s_ID") String id, ModelMap model) throws Exception {

		try {
			supplierDAO.deleteFurnitureSupplier(id);
			model.addAttribute("message", "Successfully Added");
		} catch (Exception e)
		{
			model.addAttribute("message", e.getMessage());
			e.printStackTrace();
		}
		// redirectAttrs.addFlashAttribute(arg0, arg1)
		return "redirect:/supplier";
	}
	
	@RequestMapping("supplier/edit/{s_ID}")
	public String editFurnitureSupplier(@PathVariable("s_ID") String id, Model model) 
	{
		System.out.println("editSupplier");
		model.addAttribute("supplier", this.supplierDAO.getFurnitureSupplier(id));
		model.addAttribute("listSupplier", this.supplierDAO.furnitureSupplierList());
		return "supplier";
	}
	

	@RequestMapping(value = "/supplier", method = RequestMethod.GET)
	public String listFurnitureSuppliers(Model model)
	{
		model.addAttribute("supplier", supplier);
		model.addAttribute("supplierList",this.supplierDAO.furnitureSupplierList());
		return "supplier";
	}
}
	