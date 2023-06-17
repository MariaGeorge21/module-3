package com.example.pro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/client")
public class ProductClient {
	
	@Autowired
	RestTemplate template;

	@GetMapping

		public String testMethod() {
		String url="http://localhost:8090/product/api.1.0/retrieve/4";
		String result=template.getForObject(url, String.class);
			return "working...." + result;
		}
	
	}

