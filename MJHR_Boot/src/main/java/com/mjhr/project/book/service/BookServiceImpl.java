package com.mjhr.project.book.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mjhr.project.book.dao.BookDao;
import com.mjhr.project.book.dto.Book;
import com.mjhr.project.common.dto.SearchCondition;

@Service
public class BookServiceImpl implements BookService {

	private BookDao dao;

	private BookServiceImpl(BookDao dao) {
		this.dao = dao;
	}

	@Override
	public List<Book> getAllBooks(int page, int size) {
	    int offset = (page - 1) * size; // 시작 위치 계산
	    return dao.selectAllOrdered(offset, size);
	}
	
	@Override
	public int getTotalBookCount() {
	    return dao.selectTotalBookCount();
	}


	@Override
	public Book getBookByIsbn(String isbn) {
		return dao.select(isbn);
	}

	@Override
	public List<Book> searchBook(SearchCondition condition) {
	    return dao.search(condition);
	}

	@Override
	public int getSearchResultCount(SearchCondition condition) {
	    return dao.getSearchResultCount(condition);
	}

	@Override
	public boolean createBook(Book book) {
		System.out.println(book.toString());
		return dao.insert(book) == 1;
	}

	@Override
	public boolean removeBook(String isbn) {
		System.out.println(isbn);
		return dao.delete(isbn) == 1;
	}

	@Override
	public boolean modifyBook(Book book) {
		System.out.println(book.toString());
		return dao.update(book) == 1;
	}

}
