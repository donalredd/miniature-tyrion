package com.receipt.vault.webapp.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.receipt.vault.dao.CategoryRepository;
import com.receipt.vault.model.Category;
import com.receipt.vault.model.Item;

@Controller
@RequestMapping("/imageForm*")
public class ImageUploadController {
	private static final Logger logger = LoggerFactory
			.getLogger(ImageUploadController.class);

	@Autowired
	private CategoryRepository categoryService;

	@RequestMapping(value = "imageupload", method = RequestMethod.POST, headers = "Content-Type=multipart/form-data")
	public String handleFormUpload(
			@RequestParam("description") String description,
			@RequestParam("file") MultipartFile file) {

		if (!file.isEmpty()) {
			byte[] bytes = null;
			try {
				bytes = file.getBytes();
			} catch (IOException e) {
				logger.info("error processing uploaded file", e);
			}
			return "file upload received! Name:[" + description + "] Size:["
					+ bytes.length + "]";
		} else {
			return "file upload failed!";
		}
	}

	@ModelAttribute
	@RequestMapping(method = RequestMethod.GET)
	protected Item getUser(HttpServletRequest request) {
		String userId = request.getParameter("id");
		if ((userId != null) && !userId.equals("")) {
			return new Item();
		} else {
			return new Item();
		}
	}

	@ModelAttribute("categories")
	public Iterable<Category> getStores() {
		return categoryService.findAll();
	}

	@RequestMapping("upload")
	public String handleFormUpload() {

		return "upload";

	}
}
