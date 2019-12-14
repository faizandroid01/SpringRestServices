package com.faiz.learn.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.faiz.learn.model.Book;

@Service
public class BookService {

	private static List<Book> books = new ArrayList<Book>();
	private static int bookCount = 3;

	static {

		books.add(new Book(1, "Learn with Python", "Dravi Jain"));
		books.add(new Book(2, "Learn with Java", "Pranita Mamgain"));
		books.add(new Book(3, "Learn with C Sharp", "Divya Shukla"));
		books.add(new Book(4, "Learn with C++ ", "Himanshi Verma"));

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

}
