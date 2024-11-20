package com.mjhr.project.review.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mjhr.project.review.dto.ReviewLike;
import com.mjhr.project.review.service.ReviewLikeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "ReveiwLike", description = "독후감 좋아요")
@RestController
@RequestMapping("/reviewlike")
public class ReviewLikeController {

	private final ReviewLikeService service;

	public ReviewLikeController(ReviewLikeService service) {
		this.service = service;
	}

	@Operation(summary = "독후감 좋아요", description = "독후감 좋아요")
	@PostMapping("/user/{userId}/review/{reviewId}")
	public ResponseEntity<?> clickReviewLike(@PathVariable("userId") String userId,
			@PathVariable("reviewId") String reviewId) {

		System.out.println("userId : " + userId + "reviewId :" + reviewId);

		if (service.createReviewLike(userId, reviewId)) {
			return new ResponseEntity<>("좋아요 성공", HttpStatus.OK);
		}

		return new ResponseEntity<>("좋아요 실패", HttpStatus.BAD_REQUEST);

	}

	@Operation(summary = "독후감 좋아요 취소", description = "독후감 좋아요 취소")
	@DeleteMapping("/user/{userId}/review/{reviewId}")
	public ResponseEntity<?> clickReviewUnlike(@PathVariable("userId") String userId,
			@PathVariable("reviewId") String reviewId) {

		System.out.println("userId : " + userId + " reviewId : " + reviewId);

		if (service.removeReviewLike(userId, reviewId)) {
			return new ResponseEntity<>("좋아요 취소 성공", HttpStatus.OK);
		}

		return new ResponseEntity<>("좋아요 취소 실패", HttpStatus.BAD_REQUEST);

	}

	@Operation(summary = "사용자 좋아요 조회", description = "사용자가 좋아요한 독후감 reviewId, reviewTitle 반환")
	@GetMapping("/user/{userId}")
	public ResponseEntity<?> getMyReviewLike(@PathVariable("userId") String userId) {
		
		List<ReviewLike> result = service.getMyReviewLike(userId);
		
		if(result == null || result.size() == 0) {
			return new ResponseEntity<>("실패",HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@Operation(summary = "사용자 좋아요 수 조회", description = "사용자가 좋아요 한 독후감 수 반환")
	@GetMapping("/user/{userId}/count")
	public ResponseEntity<?> getMyReviewLikeCount(@PathVariable("userId") String userId) {
		
		int count = service.getMyReviewLikeCount(userId);

		return new ResponseEntity<>(count,HttpStatus.OK);
	}

	@Operation(summary = "독후감 좋아요 조회", description = "독후감을 좋아요한 사용자 userId, userNic 반환")
	@GetMapping("/review/{reviewId}")
	public ResponseEntity<?> getReviewLikeUsers(@PathVariable("reviewId") String reviewId) {
		
		List<ReviewLike> result = service.getReviewLikeUsers(reviewId);
		
		if(result==null || result.size() == 0) {
			return new ResponseEntity<>("실패",HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@Operation(summary = "독후감 좋아요 수 조회", description = "독후감을 좋아요 한 사용자 수 반환")
	@GetMapping("/review/{reviewId}/count")
	public ResponseEntity<?> getReviewLikeUsersCount(@PathVariable("reviewId") String reviewId) {
		
		int count = service.getReviewLikeUsersCount(reviewId);

		return new ResponseEntity<>(count, HttpStatus.OK);
	}

}
