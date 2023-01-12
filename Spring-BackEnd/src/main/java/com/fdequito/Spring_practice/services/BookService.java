package com.fdequito.Spring_practice.services;

import java.util.List;

import com.fdequito.Spring_practice.model.Books;

public interface BookService {
	Books saveBook(Books books);
	List<Books> getAllBooks();
	Books getBooksById(long id);
	Books updateBooks(Books books, long id);
	void deleteBooks(long id);
	
}
