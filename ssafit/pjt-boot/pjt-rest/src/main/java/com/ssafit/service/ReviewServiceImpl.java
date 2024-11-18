package com.ssafit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafit.model.dao.ReviewDao;
import com.ssafit.model.dto.Review;

@Service
public class ReviewServiceImpl implements ReviewService {
	
	@Autowired
	ReviewDao reviewDao;

	// 리뷰 등록
	public void createReview(Review review) {
		// reviewDao.insertReview() 호출
	}

	// 특정 비디오의 리뷰 목록 조회
	public List<Review> getVideoReviews(int videoId) {
		// reviewDao.selectReviewsByVideo() 호출
		return reviewDao.selectReviewsByVideo(videoId);
	}

	// 리뷰 수정
	public void modifyReview(Review review) {
		// reviewDao.updateReview() 호출
	}

	// 리뷰 삭제
	public void deleteReview(int reviewId) {
		// reviewDao.deleteReview() 호출
	}

}
