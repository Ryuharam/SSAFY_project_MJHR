package com.mjhr.project.review.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mjhr.project.review.service.ReviewLikeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "ReveiwLike", description = "독후감 좋아요")
@RestController
@RequestMapping("/reviewlike")
public class ReviewLikeController {
	
//	private final ReviewLikeService service;
//	
//	public ReviewLikeController(ReviewLikeService service) {
//		this.service = service;
//	}
//
//	@Operation(summary = "독후감 좋아요", description = "독후감 좋아요")
//	@PostMapping("/user/{userId}/review/{reviewId}")
//	public ResponseEntity<?> clickReviewLike(@PathVariable("userId")String userId, @PathVariable("reviewId") String reviewId){
//		
//		System.out.println("userId : "+userId+"reviewId :"+reviewId);
//		
//		if(service.createReviewLike(userId,reviewId)) {
//			return new ResponseEntity<>("좋아요 성공",HttpStatus.OK);
//		}
//		
//		return new ResponseEntity<>("좋아요 실패",HttpStatus.BAD_REQUEST);
//		
//	}
//	
//	@Operation(summary = "독후감 좋아요 취소", description = "독후감 좋아요 취소")
//	@DeleteMapping("/user/{userId}/review/{reviewId}")
//	public ResponseEntity<?> clickReviewUnlike(@PathVariable("userId")String userId, @PathVariable("reviewId") String reviewId){
//		
//		System.out.println("userId : "+userId + " reviewId : "+reviewId);
//		
//		if(service.removeReviewLike(userId,reviewId)) {
//			return new ResponseEntity<>("좋아요 취소 성공",HttpStatus.OK);
//		}
//		
//		return new ResponseEntity<>("좋아요 취소 실패",HttpStatus.BAD_REQUEST);
//		
//	}
	
	
	
}
