package com.mjhr.project.review.dao;

import java.util.List;

import com.mjhr.project.review.dto.ReviewLike;

public interface ReviewLikeDao {

	int insertReviewLike(String userId, String reviewId);

	int deleteReviewLike(String userId, String reviewId);

	List<ReviewLike> selectReviewLikes(String userId);

	int selectReviewLikeCount(String userId);

	List<ReviewLike> selectLikeUsers(String reviewId);

	int selectLikeUserCount(String reviewId);

}
