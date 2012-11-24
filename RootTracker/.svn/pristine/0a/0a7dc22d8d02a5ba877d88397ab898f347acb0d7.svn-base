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

import com.receipt.vault.model.Store;
import com.receipt.vault.service.StoreService;

@Controller
@RequestMapping("/storeform*")
public class StoreFormController {
	private final Log log = LogFactory.getLog(UserFormController.class);

	@Autowired(required = false)
	Validator validator;

	private MessageSourceAccessor messages;

	@Autowired
	private StoreService storeService;

	@Autowired
	public void setMessages(MessageSource messageSource) {
		messages = new MessageSourceAccessor(messageSource);
	}

	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(Store store, BindingResult result,
			HttpServletRequest request) throws Exception {

		if (request.getParameter("cancel") != null)
			return "redirect:users";

		if (validator != null) { // validator is null during testing
			validator.validate(store, result);

			if (result.hasErrors()) {
				return "userform";
			}
		}

		log.debug("entering 'onSubmit' method...");
		
		if (request.getParameter("delete") != null) {
			storeService.deleteItem(store.getId());
			request.getSession().setAttribute("message",
					getText("user.deleted", store.getName()));
		} else {
			
			storeService.saveStore(store);
			request.getSession().setAttribute("message",
					getText("user.saved", store.getName()));
		}

		return "redirect:stores";
	}

	@ModelAttribute
	@RequestMapping(method = RequestMethod.GET)
	protected Store geStore(HttpServletRequest request) {
		String storeId = request.getParameter("id");
		if ((storeId != null) && !storeId.equals("")) {
			return storeService.findById(Long.valueOf(storeId));
		} else {
			return new Store();
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
