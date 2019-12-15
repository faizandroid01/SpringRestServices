package com.faiz.learn.webcontrollers;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.faiz.learn.model.Message;

@RestController
public class MessageController {

	@Autowired
	private MessageSource messageSource;

	@GetMapping(path = "/message")
	public Message getMessage() {
		return new Message("Hello World");
	}

	@GetMapping(path = "/message/{name}")
	public Message getMessageWithName(@PathVariable String name) {
		return new Message(String.format("Hello World : %s ", name));
	}

	@GetMapping(path = "/message-internationalized")
	public String getMessageInternationalized(
			@RequestHeader(name = "Accept-Language", required = false) Locale locale) {

		return messageSource.getMessage("good.morning.message", null, locale);

	}

}
