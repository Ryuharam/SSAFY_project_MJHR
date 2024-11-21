package com.mjhr.project.review.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mjhr.project.review.dao.ReviewLikeDao;
import com.mjhr.project.review.dto.ReviewLike;

@Service
public class ReviewLikeServiceImpl implements ReviewLikeService {
	
	private final ReviewLikeDao dao;
	
	public ReviewLikeServiceImpl(ReviewLikeDao dao) {
		this.dao = dao;
	}

	@Override
	public boolean createReviewLike(String userId, String reviewId) {
		return dao.insertReviewLike(userId,reviewId)==1;
	}

	@Override
	public boolean removeReviewLike(String userId, String reviewId) {
		return dao.deleteReviewLike(userId,reviewId)==1;
	}

	@Override
	public List<ReviewLike> getMyReviewLike(String userId) {
		return dao.selectReviewLikes(userId);
	}

	@Override
	public int getMyReviewLikeCount(String userId) {
		return dao.selectReviewLikeCount(userId);
	}

	@Override
	public List<ReviewLike> getReviewLikeUsers(String reviewId) {
		return dao.selectLikeUsers(reviewId);
	}

	@Override
	public int getReviewLikeUsersCount(String reviewId) {
		return dao.selectLikeUserCount(reviewId);
	}

}
