package com.mjhr.project.book.service;

import java.util.List;

import com.mjhr.project.book.dto.BookLike;

public interface BookLikeService {

	boolean createBookLike(String userId, String isbn);

	boolean removeBookLike(String userId, String isbn);

	List<BookLike> getMyBookLike(String userId);

	List<BookLike> getBookLike(String isbn);

	int getMyBookLikeCount(String userId);

	int getBookLikeCount(String isbn);

	
}
