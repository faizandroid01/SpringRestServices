package com.faiz.learn.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.faiz.learn.entity.Author;
import com.faiz.learn.entity.Book;

@Service
public class ParseFromExcelService {

	@Autowired
	private BookService bookService;

	public List<Book> parseCsv(MultipartFile file) throws IOException {
		List<Book> bookList = new ArrayList<Book>();
		Book book = null;
		Author author = null;

		BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()));

		String line;
		while ((line = br.readLine()) != null) {

			String[] data = line.split(",");
			if (data != null) {
				book = new Book();
				author = new Author();

				book.setBookName(data[1] != null ? String.valueOf(data[0]) : null);
				book.setDescription(data[1] != null ? String.valueOf(data[1]) : null);
				author.setAuthorName(data[2] != null ? String.valueOf(data[2]) : null);

				book.setAuthor(author);
			}
			bookList.add(book);
		}

		return bookList;
	}

	public String saveFromMultipleExcels(MultipartFile files[]) throws IOException {

		for (MultipartFile multipartFile : files) {
			for (Book book : parseCsv(multipartFile)) {
				bookService.save(book);
			}
		}

		return "Success";
	}
}
