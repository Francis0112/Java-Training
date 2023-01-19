package com.fdequito.BooksManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fdequito.BooksManagementSystem.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	@Query("select u from User u where u.email=:email")
	User findByEmail(@Param("email") String email);
	@Query("select u from User u where u.password=:password")
	User findByPassword(@Param("password") String password);
}
