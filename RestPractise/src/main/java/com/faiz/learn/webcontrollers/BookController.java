package com.faiz.learn.webcontrollers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.faiz.learn.model.Book;
import com.faiz.learn.model.Message;
import com.faiz.learn.service.BookService;

import exception.UserNotFoundException;

@RestController
public class BookController {

	@Autowired
	private BookService service;

	@GetMapping(path = "/message")
	public Message getMessage() {
		return new Message("Hello World");
	}

	@GetMapping(path = "/message/{name}")
	public Message getMessageWithName(@PathVariable String name) {
		return new Message(String.format("Hello World : %s ", name));
	}

	@GetMapping(path = "/books")
	public List<Book> getAllBooks() {
		return service.getBooks();
	}

	@GetMapping(path = "/books/{id}")
	public Book getAllBooks(@PathVariable int id) {
		Book retrievedBook = service.getBookWith(id);
		if (retrievedBook == null) {
			throw new UserNotFoundException("Book id " + id + " not exists.");
		}
		return retrievedBook;
	}
	

	@PostMapping(path = "/books")
	public ResponseEntity<Object> savebook(@RequestBody Book book) {

		Book savedBook = service.save(book);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedBook.getBookId()).toUri();

		return ResponseEntity.created(location).build();

	}

}
