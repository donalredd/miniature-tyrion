package com.receipt.vault.webapp.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ItemRestController {
	private static final Logger logger = LoggerFactory.getLogger(ItemRestController.class);

    @RequestMapping(value = "postformdata", method=RequestMethod.POST, headers="Content-Type=multipart/form-data")
    public @ResponseBody String handleFormUpload( @RequestParam("file") MultipartFile file) {

        if (!file.isEmpty()) {
        	byte[] bytes = null;
            try {
				bytes = file.getBytes();
			} catch (IOException e) {
				logger.info("error processing uploaded file", e);
			}
           return "file upload received! Name:[" + "description" + "] Size:[" + bytes.length + "]";
       } else {
    	   return "file upload failed!";
       }
    }
	@RequestMapping(value="sendmessage", method=RequestMethod.POST, headers="Content-Type=text/plain")
	public @ResponseBody String sendMessage(@RequestBody String message) {
		logger.info("String message: " + message);
		return "String message received! Your message: " + message;
	}
}
