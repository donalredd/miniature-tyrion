package com.receipt.vault.rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.web.client.RestTemplate;

import com.receipt.vault.model.User;

@ContextConfiguration("classpath:spring-beans.xml")
public class RestClient extends AbstractTransactionalJUnit4SpringContextTests {

	@Test
	public void testClient() {

		String url = "http://localhost:9090/jsonallusers";
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
		ResponseEntity<User[]> responseEntity = restTemplate.exchange(url,
				HttpMethod.GET, requestEntity, User[].class);

		// convert the array to a list and return it
		List<User> asList = Arrays.asList(responseEntity.getBody());
		for (User user : asList) {
			System.out.println(user.getName());
		}

	}
}
