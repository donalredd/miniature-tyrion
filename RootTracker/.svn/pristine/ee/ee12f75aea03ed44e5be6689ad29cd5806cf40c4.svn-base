package com.receipt.vault.webapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.receipt.vault.model.Item;
import com.receipt.vault.service.ItemService;
import com.receipt.vault.service.UserService;

@Controller
public class ItemController {

	@Autowired
	UserService userService;

	@Autowired
	ItemService itemService;

	@RequestMapping("/items*")
	public String execute(ModelMap model) {
		model.addAttribute("itemList", itemService.findAll());
		return "itemList";
	}

	@RequestMapping("/addItem*")
	public String add(Item item, BindingResult result,
			HttpServletRequest request, ModelMap model) {
		itemService.saveItem(item);
		model.addAttribute("itemList", itemService.findAll());
		return "itemList";
	}
}
