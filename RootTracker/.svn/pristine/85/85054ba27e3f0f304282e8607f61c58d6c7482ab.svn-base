package com.receipt.vault.webapp.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.receipt.vault.model.Category;
import com.receipt.vault.model.Item;
import com.receipt.vault.model.Store;
import com.receipt.vault.service.CategoryService;
import com.receipt.vault.service.ItemService;
import com.receipt.vault.service.StoreService;

@Controller
@RequestMapping("/itemform*")
public class ItemFormController {
	private final Log log = LogFactory.getLog(ItemFormController.class);

	@Autowired(required = false)
	Validator validator;

	private ItemService itemService;
	
	private CategoryService categoryService;
	
	private StoreService storeService;
	
	@Autowired
	public void setStoreService(StoreService storeService) {
		this.storeService = storeService;
	}

	@Autowired
	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}

	@Autowired
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	private MessageSourceAccessor messages;

	@Autowired
	public void setMessages(MessageSource messageSource) {
		messages = new MessageSourceAccessor(messageSource);
	}

	/**
	 * Set up a custom property editor for converting Longs
	 * 
	 * @param binder
	 *            the default databinder
	 */
	@InitBinder
	public void initBinder(ServletRequestDataBinder binder) {
		// convert java.util.Date
		SimpleDateFormat dateFormat = new SimpleDateFormat( getText("date.format"));
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, null, new CustomDateEditor( dateFormat, true));
		// convert java.lang.Long
		binder.registerCustomEditor(Long.class, null, new CustomNumberEditor(Long.class, null, true));
	}

	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(Item item, BindingResult result,
			HttpServletRequest request) throws Exception {

		if (request.getParameter("cancel") != null)
			return "redirect:users";

		if (validator != null) { // validator is null during testing
			validator.validate(item, result);

			if (result.hasErrors()) {
				return "itemForm";
			}
		}

		log.debug("entering 'onSubmit' method...");

		if (request.getParameter("delete") != null) {
			itemService.deleteItem(Long.valueOf(item.getId()));
			request.getSession().setAttribute("message", getText("item.deleted", item.getName()));
		} else {
			request.getSession().setAttribute("message", getText("item.saved", item.getName()));
		}

		return "redirect:items";
	}

	@ModelAttribute("categories")
	public Iterable<Category> getCategories() {
		return categoryService.findAll();
	}
	

	@ModelAttribute("stores")
	public Iterable<Store> getStores() {
		return storeService.findAll();
	}
	
	@ModelAttribute
	@RequestMapping(method = RequestMethod.GET)
	protected Item getItem(HttpServletRequest request) {
		String itemId = request.getParameter("id");
		if ((itemId != null) && !itemId.equals("")) {
			
			return itemService.findById(Long.valueOf(itemId));
			
		} else {
			return new Item();
		}
	}

	/**
	 * Convenience method for getting a i18n key's value.
	 * 
	 * @param msgKey
	 *            the i18n key to lookup
	 * @return the message for the key
	 */
	public String getText(String msgKey) {
		return messages.getMessage(msgKey);
	}

	/**
	 * Convenient method for getting a i18n key's value with a single string
	 * argument.
	 * 
	 * @param msgKey
	 *            the i18n key to lookup
	 * @param arg
	 *            arguments to substitute into key's value
	 * @return the message for the key
	 */
	public String getText(String msgKey, String arg) {
		return getText(msgKey, new Object[] { arg });
	}

	/**
	 * Convenience method for getting a i18n key's value with arguments.
	 * 
	 * @param msgKey
	 *            the i18n key to lookup
	 * @param args
	 *            arguments to substitute into key's value
	 * @return the message for the key
	 */
	public String getText(String msgKey, Object[] args) {
		return messages.getMessage(msgKey, args);
	}
}
