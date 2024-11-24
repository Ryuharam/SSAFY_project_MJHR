package com.mjhr.project.book.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mjhr.project.book.dto.Book;
import com.mjhr.project.common.dto.SearchCondition;

@Mapper
public interface BookDao {
	
	// 전체 도서 목록 조회 (페이징 적용)
	public List<Book> selectAllOrdered(@Param("offset")int offset,@Param("size") int size);

	// 전체 도서 수 조회
	public int selectTotalBookCount();


	// isbn에 해당하는 도서 조회
	public Book select(String isbn);
	
	// 도서 검색
	public List<Book> search(SearchCondition condition);

	// 검색 결과 총 개수 조회
	public int getSearchResultCount(SearchCondition condition);

	
	// 도서 등록
	public int insert(Book book);
	
	// 도서 삭제
	public int delete(String isbn);
	
	// 도서 수정
	public int update(Book book);

}
