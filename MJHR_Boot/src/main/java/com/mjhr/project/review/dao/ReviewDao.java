package com.mjhr.project.review.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mjhr.project.common.dto.SearchCondition;
import com.mjhr.project.review.dto.Review;

@Mapper
public interface ReviewDao {

	List<Review> selectAll();

	Review selectOne(String reviewId);

	List<Review> search(SearchCondition condition);

	int insertReview(Review review);

	int deleteReview(String reviewId);

	int updateReview(Review review);

	int getSearchResultCount(SearchCondition condition);

}
