package com.receipt.vault.webapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.receipt.vault.dao.CategoryRepository;
import com.receipt.vault.model.Category;

@Controller
@RequestMapping("/categoryform*")
public class CategoryFormController {
	private final Log log = LogFactory.getLog(UserFormController.class);

	@Autowired(required = false)
	Validator validator;

	private MessageSourceAccessor messages;

	@Autowired
	private CategoryRepository categoryService;

	@Autowired
	public void setMessages(MessageSource messageSource) {
		messages = new MessageSourceAccessor(messageSource);
	}

	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(Category category, BindingResult result,
			HttpServletRequest request) throws Exception {

		if (request.getParameter("cancel") != null)
			return "redirect:catgoryList";

		if (validator != null) { // validator is null during testing
			validator.validate(category, result);

			if (result.hasErrors()) {
				return "categoryForm";
			}
		}

		log.debug("entering 'onSubmit' method...");
		
		if (request.getParameter("delete") != null) {
			categoryService.delete(category.getId());
			request.getSession().setAttribute("message",
					getText("user.deleted", category.getName()));
		} else {
			categoryService.save(category);
			request.getSession().setAttribute("message",
					getText("user.saved", category.getName()));
		}

		return "redirect:categories";
	}

	@ModelAttribute
	@RequestMapping(method = RequestMethod.GET)
	protected Category getUser(HttpServletRequest request) {
		String categoryId = request.getParameter("id");
		if ((categoryId != null) && !categoryId.equals("")) {
			return categoryService.findById(Long.valueOf(categoryId));
		} else {
			return new Category();
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
