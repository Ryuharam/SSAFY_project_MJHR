package com.ssafit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafit.model.dto.Review;
import com.ssafit.service.ReviewService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;




@Tag(name = "Review", description = "리뷰 기능")
@RestController
@RequestMapping("/review")
public class ReviewController {
	
	@Autowired
	ReviewService reviewService;
	
	// 특정 비디오의 리뷰 목록 조회
	@Operation(summary = "리뷰 목록 조회", description = "비디오의 리뷰 목록을 조회합니다.")
	@GetMapping("/{videoId}")
	public ResponseEntity<List<Review>> getReviewList(@PathVariable("videoId") int videoId) {
		List<Review> list = reviewService.getVideoReviews(videoId);
		if(list != null && !list.isEmpty()) {
			return new ResponseEntity<List<Review>>(list, HttpStatus.OK);
		}
		return new ResponseEntity<>(list,list==null?HttpStatus.NOT_FOUND:HttpStatus.OK);
	}
	
	// 리뷰 등록
	@Operation(summary = "리뷰 등록", description = "리뷰를 등록합니다.")
	@PostMapping
	public ResponseEntity<?> registReview(@RequestBody Review review) {
		int result = reviewService.createReview(review);
		return new ResponseEntity<>(result,result==1?HttpStatus.CREATED:HttpStatus.BAD_REQUEST);
	}
	
	// 리뷰 수정
	@Operation(summary = "리뷰 수정", description = "리뷰를 수정합니다.")
	@PutMapping("/{reviewId}")
	public ResponseEntity<?> updateReview(@PathVariable("reviewId") int reviewId, @RequestBody Review review) {
		review.setReviewId(reviewId);
		int result = reviewService.modifyReview(review);
		return new ResponseEntity<>(result, result==1?HttpStatus.OK:HttpStatus.BAD_REQUEST);
	}
	
	// 리뷰 삭제
	@Operation(summary = "리뷰 삭제", description = "리뷰를 삭제합니다.")
	@DeleteMapping("/{reviewId}")
	public ResponseEntity<?> removeReview(@PathVariable("reviewId")int reviewId){
		int result = reviewService.deleteReview(reviewId);
		return new ResponseEntity<>(result, result==1?HttpStatus.OK:HttpStatus.BAD_REQUEST);
	}
	
	// 리뷰 상세
	@Operation(summary = "리뷰 상세", description = "리뷰의 상세 정보를 확인합니다.")
	@GetMapping("/{videoId}/{reviewId}")
	public ResponseEntity<Review> getMethodName(@PathVariable("videoId")int videoId ,@PathVariable("reviewId") int reviewId) {
		Review review = reviewService.getVideoReview(reviewId);
		System.out.println(review.toString());
		return new ResponseEntity<Review>(review, HttpStatus.OK);
	}
	
	
}