package com.faiz.learn.webcontrollers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.faiz.learn.exception.ResourceNotFoundException;
import com.faiz.learn.model.Chapters;
import com.faiz.learn.service.BookService;
import com.faiz.learn.service.ChapterService;

@RestController
public class ChaptersController {

	@Autowired
	private BookService bookService;

	@Autowired
	private ChapterService chapterService;

	@GetMapping(value = "/getChapters/{bookId}")
	public List<Integer> getChaptersFor(@PathVariable int bookId) {

		// if (Objects.requireNonNull(bookService.getBookWith(bookId)) == null)
		if (bookService.getBookWith(bookId) == null)
			throw new ResourceNotFoundException("Book id " + bookId + " not exists.");

		List<Integer> chapters = chapterService.getChapters(bookId);

		if (chapters == null || chapters.isEmpty())
			throw new ResourceNotFoundException("Chapters are not added till now ");

		return chapters;

	}

	@PostMapping(value = "/createHCChapters/{bookId}/chapters")
	public Chapters createHardcodeChaptersFor(@PathVariable int bookId) {
		if (bookService.getBookWith(bookId) == null)
			throw new ResourceNotFoundException("Book id " + bookId + " not exists.");

		return chapterService.createHardcodeChaptersFor(bookId, Arrays.asList(7, 8, 9, 10));
	}

	@PostMapping(value = "/createChapters/{bookId}/chapters")
	public Chapters createChaptersFor(@PathVariable int bookId, @RequestBody Chapters chapters) {
		if (bookService.getBookWith(bookId) == null)
			throw new ResourceNotFoundException("Book id " + bookId + " not exists.");

		return chapterService.createChaptersFor(bookId, chapters);
	}

}
