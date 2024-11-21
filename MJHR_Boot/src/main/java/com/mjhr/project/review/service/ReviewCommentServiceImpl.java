package com.mjhr.project.review.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mjhr.project.review.dao.ReviewCommentDao;
import com.mjhr.project.review.dto.ReviewComment;

@Service
public class ReviewCommentServiceImpl implements ReviewCommentService{
	
	private final ReviewCommentDao dao;
	
	public ReviewCommentServiceImpl(ReviewCommentDao dao) {
		this.dao = dao;
	}

	@Override
	public List<ReviewComment> getReviewComment(String reviewId) {
		return dao.selectAllReviewComment(reviewId);
	}

	@Override
	public List<ReviewComment> getUserComment(String userId) {
		return dao.selectUserComment(userId);
	}

	@Override
	public boolean createComment(ReviewComment comment) {
		return dao.insertComment(comment)==1;
	}

	@Override
	public boolean modifyComment(ReviewComment comment) {
		return dao.updateComment(comment)==1;
	}

	@Override
	public boolean removeComment(ReviewComment comment) {
		return dao.deleteComment(comment)==1;
	}

}
