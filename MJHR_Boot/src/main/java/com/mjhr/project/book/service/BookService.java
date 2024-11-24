package com.mjhr.project.book.service;

import java.util.List;

import com.mjhr.project.book.dto.Book;
import com.mjhr.project.common.dto.SearchCondition;

public interface BookService {
	
	
	// isbn에 해당하는 도서 조회
	Book getBookByIsbn(String isbn);
	
	// 도서 검색
	List<Book> searchBook(SearchCondition condition);
	
	// 도서 등록
	boolean createBook(Book book);
	
	// 도서 삭제
	boolean removeBook(String isbn);
	
	// 도서 수정
	boolean modifyBook(Book book);

	List<Book> getAllBooks(int page, int size);

	int getTotalBookCount();

	int getSearchResultCount(SearchCondition condition);
}
