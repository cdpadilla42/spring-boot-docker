package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.persistence.models.Book;
import com.example.persistence.repositories.BookRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/books")
public class BookController {
	
	@Autowired
	private BookRepository bookRepository;

	@GetMapping
	public Iterable<Book> findAll() {
		return bookRepository.findAll();
	}

	@GetMapping("/title/{bookTitle}")	
	public List<Book> findByTitle(@PathVariable String bookTitle) {
		return bookRepository.findByTitle(bookTitle);
	}
	
	@GetMapping("/{id}")
	public Book findOne(@PathVariable Long id) {
		System.out.println(id);
		return bookRepository.findById(id)
			.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND ,"No matching id"));
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public Book create(@RequestBody Book book) {
		return bookRepository.save(book);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		findOne(id);
		bookRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public Book updateBook(@RequestBody Book book, @PathVariable Long id) {
		if (book.getId() != id) {
			throw new BookIdMismatchException("Id's don't match", new Exception());
		}

		bookRepository.findById(id)
			.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND ,"No matching id"));
		
		return bookRepository.save(book);
	}

}
