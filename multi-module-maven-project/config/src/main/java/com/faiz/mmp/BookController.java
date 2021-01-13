package com.faiz.mmp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faiz.mmp.models.Book;
import com.faiz.mmp.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping("/books")
	public List<Book> getAllBooks() {
		return bookService.getAllBooks();

	}

	@GetMapping("/saveBooks")
	public String saveBooks() {
		return bookService.saveBooks();
	}

}
