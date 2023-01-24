package com.fdequito.BooksManagementSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BooksManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooksManagementSystemApplication.class, args);
		Sam sam = new Sam();
		System.out.println(sam.toString());
		System.out.println(sam.name="francis");
	}
}


