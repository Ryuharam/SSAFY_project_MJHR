package com.mjhr.project.review.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mjhr.project.common.dto.SearchCondition;
import com.mjhr.project.review.dao.ReviewDao;
import com.mjhr.project.review.dto.Review;

@Service
public class ReviewServiceImpl implements ReviewService{
	
	
	private final ReviewDao dao;
	
	public ReviewServiceImpl(ReviewDao dao) {
		this.dao = dao;
	}

	@Override
	public List<Review> getAllReview() {
		return dao.selectAll();
	}

	@Override
	public Review getReviewByReviewId(String reviewId) {
		return dao.selectOne(reviewId);
	}

	@Override
	public List<Review> searchReview(SearchCondition condition) {
		return dao.search(condition);
	}

	@Override
	public boolean registReview(Review review) {
		return dao.insertReview(review)==1;
	}

	@Override
	public boolean removeReview(String reviewId) {
		return dao.deleteReview(reviewId)==1;
	}

	@Override
	public boolean modifyReview(Review review) {
		return dao.updateReview(review)==1;
	}

	@Override
	public int getSearchResultCount(SearchCondition condition) {
		return dao.getSearchResultCount(condition);
	}

}
