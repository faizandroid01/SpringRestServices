package com.faiz.learn.webcontrollers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.faiz.learn.model.Message;

@RestController
public class MessageController {

	@GetMapping(path = "/message")
	public Message getMessage() {
		return new Message("Hello World");
	}

	@GetMapping(path = "/message/{name}")
	public Message getMessageWithName(@PathVariable String name) {
		return new Message(String.format("Hello World : %s ", name));
	}

}
