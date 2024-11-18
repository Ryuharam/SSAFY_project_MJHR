package com.mjhr.project.book.dto;

public class BookLike {
	
	private int bookLikeId;
	private String userId;
	private String isbn;
	public int getBookLikeId() {
		return bookLikeId;
	}
	public void setBookLikeId(int bookLikeId) {
		this.bookLikeId = bookLikeId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	@Override
	public String toString() {
		return "BookLike [bookLikeId=" + bookLikeId + ", userId=" + userId + ", isbn=" + isbn + "]";
	}
	
	

}
