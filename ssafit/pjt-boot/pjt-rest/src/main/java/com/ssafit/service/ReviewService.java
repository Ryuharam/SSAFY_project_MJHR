package com.ssafit.service;

import java.util.List;

import com.ssafit.model.dto.Review;

public interface ReviewService {

	// 리뷰 등록
	public void createReview(Review review);
	    
	    // 특정 비디오의 리뷰 목록 조회
	public List<Review> getVideoReviews(int videoId);

	// 리뷰 수정
	public void modifyReview(Review review);

	// 리뷰 삭제
	public void deleteReview(int reviewId);

}
