package com.niit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.dao.ProductDAO;
import com.niit.model.Product;

//
@Controller
@RequestMapping("/product")
public class ProductController 
{
	@Autowired
	ProductDAO productDAO;
	
	@GetMapping("/add")
	public String addProduct(ModelMap map)
	{
		map.addAttribute("product",new Product());
		return "addproduct";
	}

	@PostMapping("/add")
	public String storeProduct(@ModelAttribute ("product") Product product)
	{
		
		productDAO.addProduct(product);
		return "redirect:/product/display";
	}
	
	@RequestMapping("/display")
	public void displayProduct()
	{
		
	}
	
	@RequestMapping("/delete")
	public void deleteProduct()
	{
		
	}
}
