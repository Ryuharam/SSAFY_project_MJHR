package com.mjhr.project.book.dao;

import java.util.List;

import com.mjhr.project.book.dto.BookLike;

public interface BookLikeDao {

	int insertLike(String userId, String isbn);

	int deleteLike(String userId, String isbn);

	List<BookLike> selectUserLikes(String userId);

	List<BookLike> selectBookLikes(String isbn);

	int selectBookCount(String userId);

	int selectUserCount(String isbn);


}
