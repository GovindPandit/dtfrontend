package com.niit.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.niit.dao.ProductDAO;
import com.niit.dao.UserDAO;
import com.niit.model.Product;

@Controller
@RequestMapping("/product")
public class ProductController 
{
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	UserDAO userDAO;
	
		
	public List<String> displayImage(int productid)
	{

		List<String> images=new ArrayList();
		
		try
		{
			String path="D:\\Eclipse Projects\\dtfrontend\\src\\main\\webapp\\WEB-INF\\resources\\images";
			Path p=Paths.get(path+productid);
			DirectoryStream<Path> files=Files.newDirectoryStream(p,"*.*");
			
			for(Path file:files)
			{
//				FileInputStream fis=new FileInputStream(file.toString());
//				byte[] arr=new byte[fis.available()];
//				fis.read(arr);
				
				images.add(file.getFileName().toString());
			}
			
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
		return images;
	}
	
	@GetMapping("/add")
	public String addProduct(ModelMap map)
	{
		map.addAttribute("product",new Product());
		return "addproduct";
	}

	@PostMapping("/add")
	public String storeProduct(@ModelAttribute("product") Product product,@RequestParam("productimage") MultipartFile productImage)
	{
		productDAO.addProduct(product);
		String path="D:\\Eclipse Projects\\dtfrontend\\src\\main\\webapp\\WEB-INF\\resources\\images";
		Path p=Paths.get(path+product.getProductid());
		if (!Files.exists(p))
		{    
			try
			{
				Files.createDirectory(p);
				System.out.println("Directory created");
			}
			catch (Exception e) 
			{
				System.out.println(e);
			}
        }
		
		List<String> files=displayImage(product.getProductid());
		
		path=String.valueOf(p.toString()+"\\"+(files.size()+1)+".jpg");
		System.out.println(path);
		File imageFile=new File(path);
		
		if(!productImage.isEmpty())
		{
			try
			{
				byte buffer[]=productImage.getBytes();
				FileOutputStream fos=new FileOutputStream(imageFile);
				BufferedOutputStream bos=new BufferedOutputStream(fos);
				bos.write(buffer);
				bos.close();
			}
			catch (Exception e) 
			{
				System.out.println(e);
			}
		}
		return "redirect:/product/display";
	}
	
	@RequestMapping("/display")
	public String displayProducts(ModelMap map)
	{
		List<Product> products=new ArrayList<Product>();
		List<String> images=new ArrayList<String>();
		for(Product p:productDAO.displayProducts())
		{
			List<String> im=displayImage(p.getProductid());
			if(!im.isEmpty())
			p.setImageurl(im.get(0));	
			products.add(p);
		}
		map.addAttribute("products",products);
		return "displayproducts";
	}
	
	@RequestMapping("/hightolow")
	public String sortPrice1(ModelMap map)
	{
		map.addAttribute("products",productDAO.displayProductByPriceDesc());
		return "displayproducts";
	}
	
	@RequestMapping("/lowtohigh")
	public String sortPrice2(ModelMap map)
	{
		map.addAttribute("products",productDAO.displayProductByPriceAsc());
		return "displayproducts";
	}
	
	@RequestMapping("/searchbyname")
	public String searchByName(@RequestParam("search") String name,ModelMap map)
	{
		map.addAttribute("products",productDAO.searchByName(name));
		return "displayproducts";
	}
	
	@RequestMapping("/display/{productid}")
	public String displayProduct(@PathVariable("productid") int productid, ModelMap map)
	{
		Product product=new Product();
		product.setProductid(productid);
		List<String> images=displayImage(productid);
		map.addAttribute("product",productDAO.displayProductById(product));
		map.addAttribute("images",images);
		return "displayproduct";
	}

	
	@RequestMapping("/delete/{productid}")
	public String deleteProduct(@PathVariable("productid") int productid)
	{
		Product p=new Product();
		p.setProductid(productid);
		productDAO.deleteProduct(p);
		return "redirect:/product/display";
	}
	
	@RequestMapping("/edit/{productid}")
	public String editProduct(@PathVariable("productid") int productid,ModelMap map)
	{
		Product p=new Product();
		p.setProductid(productid);
		map.addAttribute("p",productDAO.displayProductById(p));
		return "addproduct";
	}
	
	@RequestMapping("/update")
	public String editProduct(@ModelAttribute("p") Product p)
	{
		productDAO.updateProduct(p);
		return "redirect:/product/display";
	}
}
