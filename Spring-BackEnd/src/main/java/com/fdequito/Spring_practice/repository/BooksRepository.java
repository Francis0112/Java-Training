package com.fdequito.Spring_practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fdequito.Spring_practice.model.Books;

public interface BooksRepository extends JpaRepository<Books, Long> {

}
