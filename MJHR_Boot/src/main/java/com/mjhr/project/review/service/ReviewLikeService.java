package com.mjhr.project.review.service;

public interface ReviewLikeService {

	boolean createReviewLike(String userId, String reviewId);

	boolean removeReviewLike(String userId, String reviewId);

}
