package com.mjhr.project.review.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mjhr.project.review.dto.ReviewLike;

@Service
public class ReviewLikeServiceImpl implements ReviewLikeService {

	@Override
	public boolean createReviewLike(String userId, String reviewId) {
		return false;
	}

	@Override
	public boolean removeReviewLike(String userId, String reviewId) {
		return false;
	}

	@Override
	public List<ReviewLike> getMyReviewLike(String userId) {
		return null;
	}

	@Override
	public int getMyReviewLikeCount(String userId) {
		return 0;
	}

	@Override
	public List<ReviewLike> getReviewLikeUsers(String reviewId) {
		return null;
	}

	@Override
	public int getReviewLikeUsersCount(String reviewId) {
		return 0;
	}

}
