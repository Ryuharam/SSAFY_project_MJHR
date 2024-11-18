package com.mjhr.project.book.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mjhr.project.book.dao.BookDao;
import com.mjhr.project.book.dto.Book;
import com.mjhr.project.book.dto.SearchCondition;

@Service
public class BookServiceImpl implements BookService{
	
	private BookDao dao;
	
	private BookServiceImpl(BookDao dao) {
		this.dao = dao;
	}
	
	public BookService getInstance() {
		return null;
	}

	@Override
	public List<Book> getAllBook() {
		return dao.selectAll();
	}

	@Override
	public Book getBookByIsbn(String isbn) {
		return dao.select(isbn);
	}

	@Override
	public List<Book> searchBook(SearchCondition condition) {
		return null;
	}

	@Override
	public boolean createBook(Book book) {
		return false;
	}

	@Override
	public boolean removeBook(String isbn) {
		return false;
	}

	@Override
	public boolean modifyBook(Book book) {
		return false;
	}


}
