package com.mjhr.project.review.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mjhr.project.review.dto.ReviewComment;

@Mapper
public interface ReviewCommentDao {

	List<ReviewComment> selectAllReviewComment(String reviewId);

	List<ReviewComment> selectUserComment(String userId);

	int insertComment(ReviewComment comment);

	int updateComment(ReviewComment comment);

	int deleteComment(ReviewComment comment);

}
