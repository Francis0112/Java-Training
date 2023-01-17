package com.fdequito.BooksManagementSystem.Controller;

import java.awt.print.Book;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.fdequito.BooksManagementSystem.Entity.Books;
import com.fdequito.BooksManagementSystem.Service.BookService;

@Controller
public class BookController {

	private BookService bookService;

	public BookController(BookService bookService) {
		super();
		this.bookService = bookService;
	}
	
	// handler method to handle list books and return mode view
	
	@GetMapping("/books")
	public String bookList(Model model) {
		model.addAttribute("book_obj",bookService.getAllBooks());
		return "index";
	}
	
	@GetMapping("books/edit/{id}")
	public String editBookForm(@PathVariable Long id, Model model) {
		model.addAttribute("book_obj", bookService.getBookbyID(id));
		return "editBook";
	}
	
	
	@GetMapping("/books/{id}")
	public String deleteBook(@PathVariable long id) {
		bookService.deleteBookByID(id);
		return "redirect:/books";
	}
	
	@PostMapping("/books/{id}")
	public String updateBook(@PathVariable Long id, @ModelAttribute("book_obj") Books books, Model model) {
		//get the book from the database by id
		Books pulled_book = bookService.getBookbyID(id);
		pulled_book.setId(id);
		pulled_book.setTitle(books.getTitle());
		pulled_book.setAuthor(books.getAuthor());
		pulled_book.setOrigin(books.getOrigin());
		pulled_book.setDesc(books.getDesc());
		pulled_book.setYear(books.getYear());
		
		//save updated book object
		bookService.editBook(pulled_book);
		return "redirect:/books";
	}
	
	@GetMapping("/books/new")
	public String addBookForm(Model model) {
		//create variable object to hold addnewbook.html form data
		Book book = new Book();
		//book_obj is the variable to hold html data and pass it to book variable
		model.addAttribute("book_obj", book);
		return "addnewbook";
	}
	
	@PostMapping("/books")
	public String saveBook(@ModelAttribute("book_obj") Books books) {
		bookService.saveBook(books);
		return "redirect:/books";
	}
}
