package com.faiz.mmp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faiz.mmp.models.Book;

@RestController
public class HelloController {

	@GetMapping("/")
	public String hello() {
		return "Hello";
	}

}
