package com.faiz.learn.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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

	public Book getBookWith(int id) {
		Optional<Book> book = bookRepo.findById(id);
		return book != null ? book.get() : null;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Book save(Book book) {

		Author author = authorService.saveAuthor(book.getAuthor());

		Book savedBook = null;
		if (author != null)
			savedBook = bookRepo.save(book);

		return savedBook;
	}

	public void deleteById(int id) {
		bookRepo.deleteById(id);
	}

	// Completable Future Example

	public CompletableFuture<Book> getBookWithIdForCompletableFuture(int id) {
		LOGGER.info("Executing Thread Name in book Service: " + Thread.currentThread().getName() + " @ " + new Date());
		return CompletableFuture.completedFuture(getBookWith(id));
	}

}
