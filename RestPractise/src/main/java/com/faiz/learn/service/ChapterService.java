package com.faiz.learn.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.faiz.learn.model.Chapters;

@Service
public class ChapterService {

	private static List<Chapters> chapters = new ArrayList<Chapters>();
	static int chapterCount = 3;

	static {

		chapters.add(new Chapters(1, Arrays.asList(1, 2)));
		chapters.add(new Chapters(2, Arrays.asList(3, 4)));
		chapters.add(new Chapters(3, Arrays.asList(5, 6)));

	}

	public List<Integer> getChapters(int bookId) {

		List<Integer> chapterList = new ArrayList<>();

		for (int i = 0; i < chapters.size(); i++) {
			if (chapters.get(i).getBookId() == bookId)
				chapters.get(i).getChapters().forEach(items -> chapterList.add(items));
		}
		return chapterList;
	}

	public Chapters createHardcodeChaptersFor(int bookId, List<Integer> chaptersToBeAdded) {

		List<Integer> chaptersList = new ArrayList<Integer>();
		chaptersList = getChapters(bookId);
		chaptersList.addAll(chaptersToBeAdded);

		return new Chapters(bookId, chaptersList);

	}

	public Chapters createChaptersFor(int bookId, Chapters chapters) {
		List<Integer> chaptersList = new ArrayList<Integer>();
		chaptersList = getChapters(bookId);
		chaptersList.addAll(chapters.getChapters());

		return new Chapters(bookId, chaptersList);
	}

}
