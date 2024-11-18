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
	public int createReview(Review review) {
		// reviewDao.insertReview() 호출
		return reviewDao.insertReview(review);
	}

	// 특정 비디오의 리뷰 목록 조회
	public List<Review> getVideoReviews(int videoId) {
		// reviewDao.selectReviewsByVideo() 호출
		return reviewDao.selectReviewsByVideo(videoId);
	}

	// 리뷰 수정
	public int modifyReview(Review review) {
		// reviewDao.updateReview() 호출
		 return reviewDao.updateReview(review);
	}

	// 리뷰 삭제
	public int deleteReview(int reviewId) {
		// reviewDao.deleteReview() 호출
		 return reviewDao.deleteReview(reviewId);
	}

	@Override
	public Review getVideoReview(int reviewId) {
		System.out.println("서비스 호출");
		return reviewDao.selectReview(reviewId);
	}

}
