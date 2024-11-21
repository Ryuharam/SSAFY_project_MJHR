package com.mjhr.project.review.service;

import java.util.List;

import com.mjhr.project.review.dto.ReviewLike;

public interface ReviewLikeService {

	boolean createReviewLike(String userId, String reviewId);

	boolean removeReviewLike(String userId, String reviewId);

	List<ReviewLike> getMyReviewLike(String userId);

	int getMyReviewLikeCount(String userId);

	List<ReviewLike> getReviewLikeUsers(String reviewId);

	int getReviewLikeUsersCount(String reviewId);

}
