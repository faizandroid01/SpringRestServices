package com.faiz.learn.ResponseModels;

import java.util.List;

import com.faiz.learn.entity.Author;
import com.faiz.learn.entity.Book;

public class FutureModelOfBook {

	Book forBookService;
	List<Integer> forChapterService;
	Author forAuthorService;

	public Book getForBookService() {
		return forBookService;
	}

	public void setForBookService(Book forBookService) {
		this.forBookService = forBookService;
	}

	public List<Integer> getForChapterService() {
		return forChapterService;
	}

	public void setForChapterService(List<Integer> forChapterService) {
		this.forChapterService = forChapterService;
	}

	public Author getForAuthorService() {
		return forAuthorService;
	}

	public void setForAuthorService(Author forAuthorService) {
		this.forAuthorService = forAuthorService;
	}

}
