package com.niit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.dao.ProductDAO;
import com.niit.model.Product;


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
	public String storeProduct(@ModelAttribute("product") Product product)
	{
		productDAO.addProduct(product);
		return "redirect:/product/display";
	}
	
	@RequestMapping("/display")
	public String displayProducts(ModelMap map)
	{
		map.addAttribute("products",productDAO.displayProducts());
		return "displayproducts";
	}
	
	@RequestMapping("/display/{productid}")
	public String displayProduct(@PathVariable("productid") int productid, ModelMap map)
	{
		Product product=new Product();
		product.setProductid(productid);
		map.addAttribute("product",productDAO.displayProductById(product));
		return "displayproduct";
	}

	
	@RequestMapping("/delete")
	public void deleteProduct()
	{
		
	}
}
