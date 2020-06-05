package com.faiz.learn.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.jboss.logging.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.faiz.learn.model.Chapters;

@Service
public class ChapterService {

	private static Logger LOGGER = Logger.getLogger(ChapterService.class);

	private static List<Chapters> chapters = new ArrayList<Chapters>();
	static int chapterCount = 3;

	static {

		chapters.add(new Chapters(1, Arrays.asList(1, 2)));
		chapters.add(new Chapters(2, Arrays.asList(3, 4)));
		chapters.add(new Chapters(3, Arrays.asList(5, 6)));
		chapters.add(new Chapters(4, Arrays.asList(7, 8, 9, 10)));

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

	public List<Integer> getChaptersForBookWithCompletableFuture(int bookId) {

		LOGGER.info("Executing Thread Name in Chapter Service : Start" + Thread.currentThread().getName() + " @ "
				+ new Date());

		List<Integer> chapterList = new ArrayList<>();

		for (int i = 0; i < chapters.size(); i++) {
			if (chapters.get(i).getBookId() == bookId)
				chapters.get(i).getChapters().forEach(items -> chapterList.add(items));
		}

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		LOGGER.info("Executing Thread Name in Chapter Service: Stop" + Thread.currentThread().getName() + " @ "
				+ new Date());
		return chapterList;

	}

}
