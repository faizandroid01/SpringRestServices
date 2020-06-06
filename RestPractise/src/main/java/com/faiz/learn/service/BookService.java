package com.faiz.learn.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.faiz.learn.entity.Author;
import com.faiz.learn.entity.Book;
import com.faiz.learn.repo.BookRepo;

@Service
public class BookService {

	private static Logger LOGGER = Logger.getLogger(BookService.class);

	@Autowired
	private BookRepo bookRepo;

	@Autowired
	private AuthorService authorService;

	public List<Book> getBooks() {
		return bookRepo.findAll();
	}

	public Book getBookWith(int bookId) {
		Optional<Book> book = bookRepo.findById(bookId);
		return book != null ? book.get() : null;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Book save(Book book) {

		Book savedBook = null;
		savedBook = bookRepo.save(book);

		if (savedBook != null)
			authorService.saveAuthor(book.getAuthor());

		return savedBook;
	}

	public void deleteById(int id) {
		bookRepo.deleteById(id);
	}

	public Book getBookWithIdForCompletableFuture(int id) {

		LOGGER.info("Executing Thread Name in book Service: Start " + Thread.currentThread().getName() + " @ "
				+ new Date());

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LOGGER.info(
				"Executing Thread Name in book Service: Stop " + Thread.currentThread().getName() + " @ " + new Date());

		return getBookWith(id);
	}

}
