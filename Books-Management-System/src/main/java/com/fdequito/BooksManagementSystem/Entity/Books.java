package com.fdequito.BooksManagementSystem.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "books_mgt")
public class Books {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "book_title")
	private String title;
	@Column(name = "book_author")
	private String author;
	@Column(name = "book_origin")
	private String origin;
	@Column(name = "book_desc")
	private String desc;
	@Column(name = "book_year")
	private int year;
	
	public Books() {
		
	}

	public Books(String title, String author, String origin, String desc, int year) {
		super();
		this.title = title;
		this.author = author;
		this.origin = origin;
		this.desc = desc;
		this.year = year;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Books [id=" + id + ", title=" + title + ", author=" + author + ", origin=" + origin + ", desc=" + desc
				+ ", year=" + year + "]";
	}
}
