package com.receipt.vault.webapp.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.receipt.vault.model.Test;

public class TestRest {

	public static void main(String args[]) {

		// The URL for making the GET request
		final String url = "http://localhost:9090/test";

		// Set the Accept header for "application/json"
		HttpHeaders requestHeaders = new HttpHeaders();
		List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
		acceptableMediaTypes.add(MediaType.APPLICATION_JSON);
		requestHeaders.setAccept(acceptableMediaTypes);

		// Populate the headers in an HttpEntity object to use for the request
		HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);

		// Create a new RestTemplate instance
		RestTemplate restTemplate = new RestTemplate();

		// Perform the HTTP GET request
		ResponseEntity<Test[]> responseEntity = restTemplate.exchange(url,
				HttpMethod.GET, requestEntity, Test[].class);

		// convert the array to a list and return it
		List<Test> asList = Arrays.asList(responseEntity.getBody());
		for (Test state : asList) {
			System.out.println(state.getName());
		}
	}

}
