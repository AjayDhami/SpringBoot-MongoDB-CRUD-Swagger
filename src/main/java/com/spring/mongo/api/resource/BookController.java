package com.spring.mongo.api.resource;

import java.util.List;
import java.util.Optional;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.spring.mongo.api.model.Book;
import com.spring.mongo.api.repository.BookRepository;

@RestController
//@RequestMapping("/api")
public class BookController {

	@Autowired
	private BookRepository bookRepository;

	@PostMapping("/addBook")
	@ApiOperation(value = "Save new book to Bookstore", notes = "Add new book to bookstore")
	public String saveBook(@RequestBody Book book) {
		bookRepository.save(book);
		return "Added book with id: " + book.getId();
	}

	@GetMapping("/listBooks")
	@ApiOperation(value = "Find list of books from bookstore", notes = "Provides complete list of books", response = Book.class)
	public List<Book> getBooks() {
		return bookRepository.findAll();
	}

	@GetMapping("/listBooks/{id}")
	@ApiOperation(value = "Find particular Book by ID", notes = "Provides an id to look up specific book from bookstore")
	public Optional<Book> getBook(@PathVariable int id) {
		return bookRepository.findById(id);
	}

	@DeleteMapping("/deleteBook/{id}")
	@ApiOperation(value = "Delete Book by providing ID", notes = "Provides an id to delete specific book from bookstore")
	public String deleteBook(@PathVariable int id) {
		bookRepository.deleteById(id);
		return "Book deleted with id : " + id;
	}
}
