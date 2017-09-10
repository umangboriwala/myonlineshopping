package com.umang.myonlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.umang.myonlineshoppingbackend.dao.CategoryDAO;
import com.umang.myonlineshoppingbackend.dto.Category;

@Controller
public class PageController {

	@Autowired
	private CategoryDAO categoryDAO;

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		// mv.addObject("greeting", "Welcome to Spring MVC");
		mv.addObject("title", "Home");

		// passing list of categories
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickHome", true);
		return mv;
	}

	@RequestMapping(value = "/about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		// mv.addObject("greeting", "Welcome to Spring MVC");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);
		return mv;
	}

	@RequestMapping(value = "/contact")
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		// mv.addObject("greeting", "Welcome to Spring MVC");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact", true);
		return mv;
	}

	// Method to load all the products and based on category id
	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All Products");
		//passing list of categories 
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickAllProducts", true);
		return mv;
	}

	@RequestMapping(value = "/show/category/{id}/products")
		public ModelAndView showCategoryProducts(@PathVariable("id")int id) {
			ModelAndView mv = new ModelAndView("page");
			
			//categoryDAO to fetch single category
			Category category = null;
			
			category = categoryDAO.get(id);
			mv.addObject("title", category.getName());
			
			//passing list of categories 
			mv.addObject("categories", categoryDAO.list());
			//passing the single category object
			mv.addObject("category", category);
			mv.addObject("userClickCategoryProducts", true);
			return mv;
		}
	
	//RequestParam example
	/*@RequestMapping(value = "/test")
	public ModelAndView test(@RequestParam(value="greeting", required=false)String greeting) {
		if(greeting == null)
		{
			//assigning default greetings
			greeting = "This is default greetings";
		}
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting", greeting); 
		return mv;
	}*/
	
	//pathVariable example
	/*@RequestMapping(value = "/test/{greeting}")
	public ModelAndView test(@PathVariable("greeting")String greeting) {
		if(greeting == null)
		{
			//assigning default greetings
			greeting = "This is default greetings";
		}
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting", greeting);
		return mv;
	}*/
}
