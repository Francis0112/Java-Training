package com.fdequito.BooksManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdequito.BooksManagementSystem.Entity.Books;

public interface BookRepository extends JpaRepository<Books, Long> {

}
