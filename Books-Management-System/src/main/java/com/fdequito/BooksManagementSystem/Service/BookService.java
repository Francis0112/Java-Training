package com.fdequito.BooksManagementSystem.Service;

import java.util.List;

import com.fdequito.BooksManagementSystem.Entity.Books;

public interface BookService {
	
	List<Books> getAllBooks();
	Books saveBook(Books books);
	Books editBook(Books books);
	Books getBookbyID(long id);
	void deleteBookByID(long id);
}
