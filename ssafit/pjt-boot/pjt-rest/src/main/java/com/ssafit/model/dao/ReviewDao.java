package com.ssafit.model.dao;

import com.ssafit.model.dto.Review;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface ReviewDao {
	void insertReview(Review review);

	List<Review> selectReviewsByVideo(int videoId);

	void updateReview(Review review);

	void deleteReview(int reviewId);
}