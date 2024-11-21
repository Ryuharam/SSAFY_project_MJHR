package com.mjhr.project.review.service;

import java.util.List;

import com.mjhr.project.review.dto.ReviewComment;

public interface ReviewCommentService {

	List<ReviewComment> getReviewComment(String reviewId);

	List<ReviewComment> getUserComment(String userId);

	boolean createComment(ReviewComment comment);

	boolean modifyComment(ReviewComment comment);

	boolean removeComment(ReviewComment comment);

}
