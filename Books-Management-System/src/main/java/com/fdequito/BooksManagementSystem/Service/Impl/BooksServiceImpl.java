package com.fdequito.BooksManagementSystem.Service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fdequito.BooksManagementSystem.Entity.Books;
import com.fdequito.BooksManagementSystem.Repository.BookRepository;
import com.fdequito.BooksManagementSystem.Service.BookService;

@Service
public class BooksServiceImpl implements BookService {
	
	private BookRepository bookRepository;
	
	public BooksServiceImpl(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}

	@Override
	public List<Books> getAllBooks() {
		// TODO Auto-generated method stub
		return bookRepository.findAll();
	}

	@Override
	public Books saveBook(Books books) {
		// TODO Auto-generated method stub
		return bookRepository.save(books);
	}

	@Override
	public Books editBook(Books books) {
		// TODO Auto-generated method stub
		return bookRepository.save(books);
	}

	@Override
	public Books getBookbyID(long id) {
		// TODO Auto-generated method stub
		return bookRepository.findById(id).get();
	}

	@Override
	public void deleteBookByID(long id) {
		// TODO Auto-generated method stub
		bookRepository.deleteById(id);
	}
}
