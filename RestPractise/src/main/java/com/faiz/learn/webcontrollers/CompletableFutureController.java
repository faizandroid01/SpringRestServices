package com.faiz.learn.webcontrollers;

import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.faiz.learn.ResponseModels.FutureModelOfBook;
import com.faiz.learn.entity.Author;
import com.faiz.learn.entity.Book;
import com.faiz.learn.service.AuthorService;
import com.faiz.learn.service.BookService;
import com.faiz.learn.service.ChapterService;

@RestController
public class CompletableFutureController {

	private static Logger LOGGER = Logger.getLogger(CompletableFutureController.class);

	@Autowired
	private BookService bookService;

	@Autowired
	private ChapterService chapterService;

	@Autowired
	private AuthorService authorService;

	@GetMapping(path = "/exampleOfCompletableFuture")
	public Object exampleOfCompletableFuture() throws InterruptedException, ExecutionException {

		CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "India");
		CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "is");
		CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> "a country");

		// to execute all future task
		// return type will be null
		CompletableFuture<Void> cf = CompletableFuture.allOf(future1, future2, future3);
		LOGGER.info("combinedFuture with allOf " + cf);

		// to get the data from future
		String dataFromFuture1 = future1.get();
		LOGGER.info("dataFromFuture1 " + dataFromFuture1);

		// can check if future is completed or not
		LOGGER.info("Is future1 completed :" + future1.isDone());

		// get The combined result of all Futures

		String dataCombined = Stream.of(future1, future2, future3).map(CompletableFuture::join)
				.collect(Collectors.joining(" "));

		LOGGER.info("combined data from all futures : " + dataCombined);

		return dataCombined;

	}

	@GetMapping(path = "/bookDetailsWithCompletableFuture/{bookId}")
	public FutureModelOfBook getBookDetailsWithCompletableFuture(@PathVariable("bookId") int bookId)
			throws InterruptedException, ExecutionException {

		LOGGER.info(
				"Executing Thread Name In Controller : Start " + Thread.currentThread().getName() + " @ " + new Date());

//		CompletableFuture<Book> future1 =  bookService.getBookWithIdForCompletableFuture(bookId);
//		CompletableFuture<List<Integer>> future2 =  chapterService.getChaptersForBookWithCompletableFuture(bookId);
//		CompletableFuture<Author> future3 =authorService.getAuthorForCompletableFuture(bookId);

		CompletableFuture<Book> future1 = CompletableFuture
				.supplyAsync(() -> bookService.getBookWithIdForCompletableFuture(bookId));
		CompletableFuture<List<Integer>> future2 = CompletableFuture
				.supplyAsync(() -> chapterService.getChaptersForBookWithCompletableFuture(bookId));
		CompletableFuture<Author> future3 = CompletableFuture
				.supplyAsync(() -> authorService.getAuthorForCompletableFuture(bookId));

		CompletableFuture<Void> headFuture = CompletableFuture.allOf(future1, future2);
		LOGGER.info("Executing Thread Name In Controller: before HeadFututre Get" + Thread.currentThread().getName()
				+ " @ " + new Date());

		headFuture.get();
		LOGGER.info("Executing Thread Name In Controller: after HeadFututre Get" + Thread.currentThread().getName()
				+ " @ " + new Date());

		FutureModelOfBook response = new FutureModelOfBook();
		if (future1.isDone() && future2.isDone() && future3.isDone()) {

			response.setForBookService(future1.get());
			response.setForChapterService(future2.get());
			response.setForAuthorService(future3.get());

		}

		LOGGER.info(
				"Executing Thread Name In Controller: Stop " + Thread.currentThread().getName() + " @ " + new Date());

		return response;
	}

}
