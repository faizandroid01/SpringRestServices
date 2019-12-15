package com.faiz.learn.webcontrollers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.*;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.faiz.learn.exception.ResourceNotFoundException;
import com.faiz.learn.model.Book;
import com.faiz.learn.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping(path = "/books")
	public List<Book> getAllBooks() {
		return bookService.getBooks();
	}

	/*
	 * Representation models The ResourceSupport/Resource/Resources/PagedResources
	 * group of classes never really felt appropriately named. After all, these
	 * types do not actually manifest resources but rather representation models
	 * that can be enriched with hypermedia information and affordances. Here’s how
	 * new names map to the old ones:
	 * 
	 * ResourceSupport is now RepresentationModel
	 * 
	 * Resource is now EntityModel
	 * 
	 * Resources is now CollectionModel
	 * 
	 * PagedResources is now PagedModel
	 * 
	 * Consequently, ResourceAssembler has been renamed to
	 * RepresentationModelAssembler and its methods toResource(…) and toResources(…)
	 * have been renamed to toModel(…) and toCollectionModel(…) respectively. Also
	 * the name changes have been reflected in the classes contained in
	 * TypeReferences.
	 * 
	 * RepresentationModel.getLinks() now exposes a Links instance (over a
	 * List<Link>) as that exposes additional API to concatenate and merge different
	 * Links instances using various strategies. Also it has been turned into a
	 * self-bound generic type to allow the methods that add links to the instance
	 * return the instance itself.
	 * 
	 * The LinkDiscoverer API has been moved to the client package.
	 * 
	 * The LinkBuilder and EntityLinks APIs have been moved to the server package.
	 * 
	 * ControllerLinkBuilder has been moved into server.mvc and deprecated to be
	 * replaced by WebMvcLinkBuilder.
	 * 
	 * RelProvider has been renamed to LinkRelationProvider and returns LinkRelation
	 * instances instead of `String`s.
	 * 
	 * VndError has been moved to the mediatype.vnderror package.
	 */

	/* import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*; */

	@GetMapping(path = "/books/{bookId}")
	public EntityModel<Book> getBookWith(@PathVariable int bookId) {
		Book retrievedBook = bookService.getBookWith(bookId);
		if (retrievedBook == null) {
			throw new ResourceNotFoundException("Book id " + bookId + " not exists.");
		}

		/*
		 * For links relative to main content while fetching some weaker content of the
		 * group
		 */

		EntityModel<Book> resources = new EntityModel<Book>(retrievedBook);
		WebMvcLinkBuilder linkTo = linkTo(methodOn(BookController.class).getAllBooks());
		resources.add(linkTo.withRel("all-books"));
		return resources;
	}

	@PostMapping(path = "/books")
	public ResponseEntity<Object> saveBook(@Valid @RequestBody Book book) {

		Book savedBook = bookService.save(book);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedBook.getBookId()).toUri();

		return ResponseEntity.created(location).build();

	}

	@DeleteMapping(path = "/books/{bookId}")
	public void deleteBookWithId(@PathVariable int bookId) {

		Book book = bookService.deleteById(bookId);
		if (book == null)
			throw new ResourceNotFoundException("Book Id : " + bookId + " not exist .");
	}

}
