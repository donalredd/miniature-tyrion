package com.receipt.vault.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.receipt.vault.service.StoreService;

@Controller
public class StoreController {

	@Autowired
	StoreService storeService;

	@RequestMapping("/stores*")
	public String execute(ModelMap model) {
		model.addAttribute("storelist", storeService.findAll());
		return "storeList";
	}

	 
}
