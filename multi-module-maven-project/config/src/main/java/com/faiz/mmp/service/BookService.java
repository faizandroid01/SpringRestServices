package com.faiz.mmp.service;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faiz.mmp.models.Book;
import com.faiz.mmp.repo.BookRepo;

@Service
public class BookService {

	@Autowired
	private BookRepo bookRepo;

	public String saveBooks() {

		Timestamp timestamp = new Timestamp(System.currentTimeMillis());

		List<Book> books = Arrays.asList(new Book("NATURE OF WORLD", "AGATHA CHRISTIE", timestamp),
				new Book("ROAD NOT TAKEN", "ROBERT FROST", timestamp));
		if (bookRepo.saveAll(books) != null) {
			return "SUCCESS";
		}
		return "FAILURE";
	}

	public List<Book> getAllBooks() {
		return (List<Book>) bookRepo.findAll();
	}

}
