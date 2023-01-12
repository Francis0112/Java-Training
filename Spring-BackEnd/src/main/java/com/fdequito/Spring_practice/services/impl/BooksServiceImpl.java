package com.fdequito.Spring_practice.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fdequito.Spring_practice.exception.ResourcesNotFound_404;
import com.fdequito.Spring_practice.model.Books;
import com.fdequito.Spring_practice.repository.BooksRepository;
import com.fdequito.Spring_practice.services.BookService;

@Service
public class BooksServiceImpl implements BookService {

	private BooksRepository booksRepository;
	
	public BooksServiceImpl(BooksRepository booksRepository) {
		super();
		this.booksRepository = booksRepository;
	}

	@Override
	public Books saveBook(Books books) {
		// TODO Auto-generated method stub
		return booksRepository.save(books);
	}
	
	@Override
	public List<Books> getAllBooks() {
		// TODO Auto-generated method stub
		return booksRepository.findAll();
	}

	@Override
	public Books getBooksById(long id) {
		// TODO Auto-generated method stub
		Optional<Books> book = booksRepository.findById(id);
		if (book.isPresent()) {
			return book.get();
		}
		else {
			throw new ResourcesNotFound_404("Books", "id", id);
		}
	}

	@Override
	public Books updateBooks(Books books, long id) {
		// TODO Auto-generated method stub
		//Check if the book exists or not
		Books old_book = booksRepository.findById(id).orElseThrow(()-> new ResourcesNotFound_404("Books", "id", id));
		old_book.setTitle(books.getTitle());
		old_book.setAuthor(books.getAuthor());
		old_book.setYear(books.getYear());
		booksRepository.save(old_book);
		return old_book;
	}

	@Override
	public void deleteBooks(long id) {
		// TODO Auto-generated method stub
		booksRepository.findById(id).orElseThrow(()-> new ResourcesNotFound_404("Books", "id", id));
		booksRepository.deleteById(id);
	}
}
