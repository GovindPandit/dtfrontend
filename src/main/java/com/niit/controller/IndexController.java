package com.niit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.dao.UserDAO;
import com.niit.model.User;

@Controller
public class IndexController 
{
	@Autowired
	UserDAO userDAO;
	
	@RequestMapping(value= {"/home","","/"})
	public String m1()
	{
		return "index";
	}
	
	@RequestMapping(value= {"/register"})
	public String m2(ModelMap map)
	{
		User u=new User();
		map.addAttribute("user", u);
		return "register";
	}
	
	@RequestMapping(value= {"/registercontroller"})
	public String m3(@ModelAttribute("user") User user)
	{
		userDAO.addUser(user);
		return "index";
	}
	
	@RequestMapping(value= {"/login"})
	public String m3()
	{
		return "login";
	}
}
