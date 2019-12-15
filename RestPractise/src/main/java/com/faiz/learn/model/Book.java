package com.faiz.learn.model;

import javax.validation.constraints.Size;

public class Book {

	int bookId;
	@Size(min = 2, message = "Name should have atleast 2 character .")
	String bookName;
	@Size(min = 5)
	String BookAuthor;

	public Book() {
	}

	public Book(int bookId, String bookName, String bookAuthor) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		BookAuthor = bookAuthor;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return BookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		BookAuthor = bookAuthor;
	}

}
