package com.niit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController 
{
	@RequestMapping("/add")
	public void addProduct()
	{
		
	}
	
	@RequestMapping("/delete")
	public void deleteProduct()
	{
		
	}
}
