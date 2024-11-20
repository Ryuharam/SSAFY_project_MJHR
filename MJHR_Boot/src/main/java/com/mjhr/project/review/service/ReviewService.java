package com.mjhr.project.review.service;

import java.util.List;

import com.mjhr.project.common.dto.SearchCondition;
import com.mjhr.project.review.dto.Review;

public interface ReviewService {

	List<Review> getAllReview();

	Review getReviewByReviewId(String reviewId);

	List<Review> searchReview(SearchCondition condition);

	boolean registReview(Review review);

	boolean removeReview(String reviewId);

	boolean modifyReview(Review review);


}
