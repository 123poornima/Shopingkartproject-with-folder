package com.niit.controller;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.niit.dao.Furniture_CategoryDAO;
import com.niit.dao.FurnitureDAO;
import com.niit.dao.Furniture_SupplierDAO;
import com.niit.model.Furniture_Category;
import com.niit.model.Furniture;
import com.niit.model.Furniture_Supplier;
import com.niit.shopingkartfront.util.FileUtil;

@Controller
public class FurnitureController 
{
	@Autowired
	FurnitureDAO productDAO;
	
	@Autowired
	Furniture_Category category;
	
	@Autowired
	Furniture_CategoryDAO categoryDAO;
	
	@Autowired
	Furniture_SupplierDAO supplierDAO;
	
	@Autowired
	Furniture_Supplier supplier;
	
	@Autowired
	Furniture product;
	
	private Path path;
	
	@RequestMapping(value="/product/add", method=RequestMethod.POST)
	public String addFurnitureProduct(Model model,@Valid @ModelAttribute("product") Furniture product,HttpServletRequest request)
	{
		
		Furniture_Category category=categoryDAO.getFurnitureCategoryName(product.getCategory().getc_Name());
		categoryDAO.addFurnitureCategory(category);
		
		Furniture_Supplier supplier=supplierDAO.getFurnitureSupplireName(product.getSupplier().getS_Name());
		supplierDAO.addFurnitureSupplier(supplier);
		
		
		product.setCategory(category);
		product.setSupplier(supplier);
		
		product.setCategory_ID(category.getc_ID());
		product.setSupplier_ID(supplier.getS_ID());
		
		productDAO.addFurniture(product);

		MultipartFile file =product.getImage();
		String rootDirectory=request.getSession().getServletContext().getRealPath("/");
		path=Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\"+product.getp_id()+".jpg");
		
		if(file!=null &&!file.isEmpty())
		{
			try{
				file.transferTo(new File(path.toString()));
				System.out.println("image uploaded....");
			}
			catch(Exception e)
			{
				e.printStackTrace();
				throw new RuntimeException("image saving failed",e);
			}
			
		}
		//FileUtil.upload(path.toString(), file, product.getp_id()+".jpg");
		//System.out.println("image uploaded"+product.getp_id());
		return "redirect:/product";
		//return "product";
	}
	
	
	
	
	@RequestMapping("product/remove/{p_id}")
	public String deleteFurnitureProduct(@PathVariable("p_id") String id, ModelMap model) throws Exception {

		try {
			productDAO.deleteFurniture(id);
			model.addAttribute("message", "Successfully Added");
		} catch (Exception e)
		{
			model.addAttribute("message", e.getMessage());
			e.printStackTrace();
		}
		// redirectAttrs.addFlashAttribute(arg0, arg1)
		return "redirect:/product";
	}
	

	@RequestMapping("product/edit/{p_id}")
	public String editFurnitureProduct(@PathVariable("p_id") String id, Model model) 
	{
		System.out.println("editProduct");
		model.addAttribute("product", this.productDAO.getFurniture(id));
		model.addAttribute("productList", this.productDAO.furnitureList());
		model.addAttribute("categoryList", this.categoryDAO.furnitureCategoryList());
		model.addAttribute("supplierList", this.supplierDAO.furnitureSupplierList());
		return "product";
	}
	

	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String listFurnitureProducts(Model model)
	{
		model.addAttribute("product",new Furniture());
		model.addAttribute("supplier",new Furniture_Supplier());
		model.addAttribute("category",new Furniture_Category());
		model.addAttribute("productList",this.productDAO.furnitureList());
		model.addAttribute("categoryList",this.categoryDAO.furnitureCategoryList());
		model.addAttribute("supplierList",this.supplierDAO.furnitureSupplierList());
		return "product";
	}
	
	@RequestMapping(value="product/get/{p_id}")
	public String getSelectedFurnitureProduct(@PathVariable("p_id") String id,Model model,RedirectAttributes redirectAttributes)
	{
		redirectAttributes.addFlashAttribute("selectedProduct",productDAO.getFurniture(id));
		
		return "redirect:/backToHome";		
	}

	@RequestMapping(value="/backToHome",method=RequestMethod.GET)
	public String backToHome(@ModelAttribute("selectedProduct")
	final Furniture selectedProduct,final Model model)
	{
		model.addAttribute("selectedProduct",selectedProduct);
		model.addAttribute("categoryList",this.categoryDAO.furnitureCategoryList());
		return "item";
		
		
	}
	
}