package com.faiz.learn.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faiz.learn.entity.Author;
import com.faiz.learn.exception.ResourceNotFoundException;
import com.faiz.learn.repo.AuthorRepo;

@Service
public class AuthorService {

	private static Logger LOGGER = Logger.getLogger(AuthorService.class);

	@Autowired
	private AuthorRepo authorRepo;

	@Autowired
	private BookService bookService;

	public Author getAuthor(int bookId) {
		Optional<Author> author = authorRepo.findById(bookId);
		return author != null ? author.get() : null;
	}

	public List<Author> getAllAuthors() {
		return authorRepo.findAll();
	}

	public Author updateAuthor(Author author) {

		if (bookService.getBookWith(author.getBookId()) == null)
			throw new ResourceNotFoundException("Book id " + author.getBookId() + " not exists.");

		return authorRepo.save(author);
	}

	public Author saveAuthor(Author author) {
		return authorRepo.save(author);
	}

	// Completable Future Example
	public CompletableFuture<Author> getBookWithIdForCompletableFuture(int id) {
		LOGGER.info("Executing Thread Name in book Service: " + Thread.currentThread().getName() + " @ " + new Date());
		return CompletableFuture.completedFuture(getAuthor(id));
	}

}
