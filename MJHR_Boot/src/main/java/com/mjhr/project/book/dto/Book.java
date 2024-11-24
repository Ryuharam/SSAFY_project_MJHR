package com.mjhr.project.book.dto;

import java.time.LocalDate;

public class Book {
	private String isbn;
	private String title;
	private String author;
	private String publisher;
	private String image;
	private LocalDate pubdate;

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
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

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public LocalDate getPubdate() {
		return pubdate;
	}

	public void setPubdate(LocalDate pubdate) {
		this.pubdate = pubdate;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", author=" + author + ", publisher=" + publisher
				+ ", image=" + image + ", pubdate=" + pubdate + "]";
	}

}
