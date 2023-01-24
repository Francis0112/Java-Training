package com.fdequito.BooksManagementSystem;

public class Sam extends Shape {
	
	
	@Override
	double getArea() {
		// TODO Auto-generated method stub
		int b = 12;
		int c = 10;
		int a=b+c;
		return a;
	}

	@Override
	public String toString() {
		return "Sam [getArea()=" + getArea() + "]";
	}	
}

