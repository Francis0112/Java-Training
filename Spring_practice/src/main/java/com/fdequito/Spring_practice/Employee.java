package com.fdequito.Spring_practice;

import java.time.LocalDate;

public class Employee {

	private int id;
	private String name;
	private String email;
	private LocalDate dob;
	private int age;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Employee(int id, String name, String email, LocalDate dob, int age) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.age = age;
	}
	
	

	public Employee(String name, String email, LocalDate dob, int age) {
		super();
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.age = age;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", dob=" + dob + ", age=" + age + "]";
	}
	
	
}
