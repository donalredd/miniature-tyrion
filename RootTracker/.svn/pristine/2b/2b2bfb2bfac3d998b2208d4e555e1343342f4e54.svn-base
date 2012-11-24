package com.receipt.vault.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.receipt.vault.service.CategoryService;

@Controller
public class CategoryController {

	@Autowired
	CategoryService caegoryService;

	@RequestMapping("/categories*")
	public String execute(ModelMap model) {
		model.addAttribute("categoryList", caegoryService.findAll());
		return "categoryList";
	}
	 
}
