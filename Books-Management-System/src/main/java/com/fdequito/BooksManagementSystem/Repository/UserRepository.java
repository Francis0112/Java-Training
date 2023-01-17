package com.fdequito.BooksManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdequito.BooksManagementSystem.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
