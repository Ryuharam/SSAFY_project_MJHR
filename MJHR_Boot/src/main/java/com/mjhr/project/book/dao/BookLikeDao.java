package com.mjhr.project.book.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mjhr.project.book.dto.BookLike;
import com.mjhr.project.user.dto.User;

@Mapper
public interface BookLikeDao {

	int insertLike(@Param("userId") String userId, @Param("isbn") String isbn);

	int deleteLike(@Param("userId") String userId, @Param("isbn") String isbn);

	List<BookLike> selectUserLikes(String userId);

	List<BookLike> selectBookLikes(String isbn);

	int selectBookCount(String userId);

	int selectUserCount(String isbn);

	boolean existsByUserIdAndIsbn(@Param("userId") String userId, @Param("isbn") String isbn);


}
