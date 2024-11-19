package com.mjhr.project.review.service;

import java.util.List;

import com.mjhr.project.review.dto.Review;

public interface ReviewService {

	List<Review> getAllReview();

	Review getReviewByReviewId(String reviewId);
	

}
