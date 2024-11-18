package com.mjhr.project.book.service;

import java.util.List;

import com.mjhr.project.book.dto.Book;

public interface BookService {
	
	// 전체 도서 조회
	List<Book> getAllBook();
	
	// isbn에 해당하는 도서 조회
	Book getBook(String isbn);
	
	// 도서 검색
	
	
	// 도서 등록
	
	// 도서 삭제
	
	// 도서 수정
}
