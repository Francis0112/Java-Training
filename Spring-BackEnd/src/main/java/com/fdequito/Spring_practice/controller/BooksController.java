package com.fdequito.Spring_practice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fdequito.Spring_practice.model.Books;
import com.fdequito.Spring_practice.services.BookService;

@RestController
@RequestMapping("/api/books")
public class BooksController {

	private BookService bookService;

	public BooksController(BookService bookService) {
		super();
		this.bookService = bookService;
	}
	
	//build create Books REST API
	@PostMapping()
	public ResponseEntity<Books> saveBook(@RequestBody Books books){
		return new ResponseEntity<Books>(bookService.saveBook(books), HttpStatus.CREATED);
	}
	
	//get all books REST API
	@GetMapping()
	public List<Books> getAllBooks(){
		return bookService.getAllBooks();
	}
	
	//get Books by id REST API
	//localhost:8080/api/books/1
	@GetMapping("{id}")
	public ResponseEntity<Books> getBooksById(@PathVariable("id") long id){
		return new ResponseEntity<Books>(bookService.getBooksById(id), HttpStatus.OK);
	}
	
	
	//Update Books Rest API
	//localhost:8080/api/books/1
	@PutMapping("{id}")
	public ResponseEntity<Books> updateBooks(@PathVariable("id") long id, @RequestBody Books books){
		return new ResponseEntity<Books>(bookService.updateBooks(books, id), HttpStatus.OK);
	}
	
	//Delete Books REST API
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteBooks(@PathVariable("id") long id){
		//delete books from db
		bookService.deleteBooks(id);
		return new ResponseEntity<String>("the book have been deleted.", HttpStatus.OK);
	}
	
	
	
}
