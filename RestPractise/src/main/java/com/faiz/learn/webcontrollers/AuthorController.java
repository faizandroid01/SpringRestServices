package com.faiz.learn.webcontrollers;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.faiz.learn.entity.Author;
import com.faiz.learn.exception.ResourceNotFoundException;
import com.faiz.learn.service.AuthorService;

@RestController
public class AuthorController {

	private static Logger LOGGER = Logger.getLogger(AuthorController.class);

	@Autowired
	private AuthorService authorService;

	@GetMapping(path = "/authors")
	public List<Author> getAllAuthors() {
		return authorService.getAllAuthors();
	}

	@GetMapping(path = "/author/{bookId}")
	public Author getBookWith(@PathVariable int bookId) {
		Author retrievedAuthor = authorService.getAuthor(bookId);
		if (retrievedAuthor == null) {
			throw new ResourceNotFoundException("Book id " + bookId + " not exists.");
		}

		return retrievedAuthor;
	}
	
	

}
