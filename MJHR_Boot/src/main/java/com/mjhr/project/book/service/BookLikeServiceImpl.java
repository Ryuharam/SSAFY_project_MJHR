package com.mjhr.project.book.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mjhr.project.book.dao.BookLikeDao;
import com.mjhr.project.book.dto.BookLike;

@Service
public class BookLikeServiceImpl implements BookLikeService {

	private final BookLikeDao dao;

	public BookLikeServiceImpl(BookLikeDao dao) {
		this.dao = dao;
	}

	@Override
	public boolean createBookLike(String userId, String isbn) {
		return dao.insertLike(userId, isbn) == 1;
	}

	@Override
	public boolean removeBookLike(String userId, String isbn) {
		return dao.deleteLike(userId, isbn) == 1;
	}

	@Override
	public List<BookLike> getMyBookLike(String userId) {
		return dao.selectUserLikes(userId);
	}

	@Override
	public List<BookLike> getBookLike(String isbn) {
		return dao.selectBookLikes(isbn);
	}

	@Override
	public int getMyBookLikeCount(String userId) {
		return dao.selectBookCount(userId);
	}

	@Override
	public int getBookLikeCount(String isbn) {
		return dao.selectUserCount(isbn);
	}

}
