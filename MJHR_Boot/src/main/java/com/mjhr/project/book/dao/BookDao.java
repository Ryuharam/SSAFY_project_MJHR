package com.mjhr.project.book.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mjhr.project.book.dto.Book;

@Mapper
public interface BookDao {
	
	// 전체 도서 목록 조회
	public List<Book> selectAll();
	
	// isbn에 해당하는 도서 조회
	
	// 도서 검색
	
	// 도서 등록
	
	// 도서 삭제
	
	// 도서 수정

}
