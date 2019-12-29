package com.faiz.learn.jpa.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

	@GetMapping(value = "/test")
	public String test() {

		return "faiz";
	}

}
