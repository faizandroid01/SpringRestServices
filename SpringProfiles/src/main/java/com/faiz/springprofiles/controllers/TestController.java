package com.faiz.springprofiles.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@Value("${spring.message}")
	private String message;

	@GetMapping(value = "/message")
	public String getMessage() {
		return message;
	}

}
