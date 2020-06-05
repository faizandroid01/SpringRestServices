package com.faiz.learn.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Size;

@Entity
@SequenceGenerator(name = "author_seq", initialValue = 1, allocationSize = 100)
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_seq")
	int bookId;
	@Size(min = 2, message = "Name should have atleast 2 character .")
	String bookName;
	@Size(min = 2)
	String description;

	@OneToOne
	private Author author;

	public Book() {
	}

	public Book(int bookId, String bookName, String description) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.description = description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

}
