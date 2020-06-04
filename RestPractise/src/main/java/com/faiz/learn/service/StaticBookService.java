package com.faiz.learn.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.faiz.learn.entity.Book;
import com.faiz.learn.repo.BookRepo;

@Service
public class StaticBookService {

	private static Logger LOGGER = Logger.getLogger(StaticBookService.class);

	private static List<Book> books = new ArrayList<Book>();
	private static int bookCount = 4;

	static {

		books.add(new Book(1, "Learn with Python", "For Python"));
		books.add(new Book(2, "Learn with Java", "For Java"));
		books.add(new Book(3, "Learn with C Sharp", "For C Sharp"));
		books.add(new Book(4, "Learn with C++ ", "For C++"));

	}

	public List<Book> getBooks() {

		return books;

	}

	public Book getBookWith(int id) {

		for (Book book : books) {
			if (book.getBookId() == id) {
				return book;
			}
		}
		return null;

	}

	public Book save(Book book) {
		if (book.getBookId() == 0) {
			book.setBookId(++bookCount);
		}

		books.add(book);
		return book;
	}

	public Book deleteById(int id) {

		Iterator<Book> iter = books.iterator();

		while (iter.hasNext()) {
			Book book = iter.next();
			if (book.getBookId() == id) {
				iter.remove();
				return book;
			}
		}

		return null;

	}

	// Completable Future Example

	@Async
	public CompletableFuture<Book> getBookWithIdForCompletableFuture(int id) {

		LOGGER.info("Executing Thread Name in book Service: " + Thread.currentThread().getName() + " @ " + new Date());

		Book foundedBook = null;

		for (Book book : books) {
			if (book.getBookId() == id) {
				foundedBook = book;
			}
		}

		return CompletableFuture.completedFuture(foundedBook);
	}

}
