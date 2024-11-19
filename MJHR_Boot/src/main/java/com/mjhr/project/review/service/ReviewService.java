package com.mjhr.project.review.service;

import java.util.List;

import com.mjhr.project.review.dto.Review;
import com.mjhr.project.review.dto.SearchCondition;

public interface ReviewService {

	List<Review> getAllReview();

	Review getReviewByReviewId(String reviewId);

	List<Review> searchReview(SearchCondition condition);

	boolean registReview(Review review);
	

}
