package com.faiz.learn.model;

import java.util.List;

public class Chapters {

	private int bookId;
	private List<Integer> chapters;

	public Chapters() {
	}

	public Chapters(int bookId, List<Integer> chapters) {
		super();
		this.bookId = bookId;
		this.chapters = chapters;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public List<Integer> getChapters() {
		return chapters;
	}

	public void setChapters(List<Integer> chapters) {
		this.chapters = chapters;
	}

}
