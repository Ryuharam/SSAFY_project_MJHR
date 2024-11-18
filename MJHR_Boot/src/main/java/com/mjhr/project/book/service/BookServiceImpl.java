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
		System.out.println(isbn);
		return dao.select(isbn);
	}

	@Override
	public List<Book> searchBook(SearchCondition condition) {
		System.out.println(condition.toString());
		return dao.search(condition);
	}

	@Override
	public boolean createBook(Book book) {
		System.out.println(book.toString());
		return dao.insert(book)==1;
	}

	@Override
	public boolean removeBook(String isbn) {
		System.out.println(isbn);
		return dao.delete(isbn)==1;
	}

	@Override
	public boolean modifyBook(Book book) {
		System.out.println(book.toString());
		return dao.update(book)==1;
	}


}
