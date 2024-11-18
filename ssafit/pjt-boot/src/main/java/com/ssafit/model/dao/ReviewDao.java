package com.ssafit.model.dao;

import com.ssafit.model.dto.Review;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface ReviewDao {
	int insertReview(Review review);

	List<Review> selectReviewsByVideo(int videoId);

	int updateReview(Review review);

	int deleteReview(int reviewId);

	Review selectReview(int reviewId);
}