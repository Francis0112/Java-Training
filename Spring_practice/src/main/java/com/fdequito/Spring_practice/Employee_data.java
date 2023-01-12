package com.fdequito.Spring_practice;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class Employee_data {

	public List<Employee> emp(){
		return List.of(
				new Employee(1, "francis Dequito", "francisdequito@gmail.com", LocalDate.of(1994, 04, 17), 28)
		);
	}
}