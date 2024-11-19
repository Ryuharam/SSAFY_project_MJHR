package com.mjhr.project.review.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mjhr.project.review.dto.Review;
import com.mjhr.project.review.dto.SearchCondition;
import com.mjhr.project.review.service.ReviewService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestParam;


@Tag(name = "Review", description = "독후감")
@RestController
@RequestMapping("/review")
public class ReviewController {
	
	@Autowired
	private final ReviewService service;
	
	public ReviewController(ReviewService service) {
		this.service = service;
	}
	
	@Operation(summary = "전체 리뷰 조회", description = "리뷰 전체 목록을 조회합니다")
	@GetMapping("")
	public ResponseEntity<?> getAllReview(){
		List<Review> list = service.getAllReview();
		if(list==null || list.size()==0) {
			return new ResponseEntity<>("리뷰를 찾지 못했습니다.", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@Operation(summary = "특정 리뷰 조회", description = "리뷰 상세 페이지를 위한 특정 리뷰 정보를 조회합니다")
	@GetMapping("/{reviewId}")
	public ResponseEntity<?> getReviewByReviewId(@PathVariable("reviewId") String reviewId) {
		Review review = service.getReviewByReviewId(reviewId);
		if(review==null) return new ResponseEntity<>("리뷰를 찾지 못했습니다.", HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(review, HttpStatus.OK);
	}
	
	@Operation(summary = "사용자 독후감 조회", description = "사용자가 작성한 독후감을 조회합니다")
	@GetMapping("/myreview/{userNic}")
	public ResponseEntity<?> getMyReview(@PathVariable("userId") String userId){
		SearchCondition condition = new SearchCondition();
		condition.setKey("user_id");
		condition.setWord(userId);
		return searchReviewByKey(condition);
	}

	@Operation(summary = "도서 독후감 조회", description = "도서에 관련된 독후감을 조회합니다")
	@GetMapping("/book/{isbn}")
	public ResponseEntity<?> getBookReview(@PathVariable("isbn") String isbn){
		SearchCondition condition = new SearchCondition();
		condition.setKey("isbn");
		condition.setWord(isbn);
		return searchReviewByKey(condition);
	}
	
	@Operation(summary = "리뷰 검색", description = "검색 조건에 따라 독후감을 검색합니다")
	@GetMapping("/search")
	public ResponseEntity<?> searchReviewByKey(@ModelAttribute SearchCondition condition){
		List<Review> result = service.searchReview(condition);
		if(result==null || result.size()==0) return new ResponseEntity<>("리뷰를 찾지 못했습니다.", HttpStatus.NOT_FOUND); 
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	// 리뷰 등록
	@Operation(summary = "리뷰 등록", description = "리뷰 작성")
	@PostMapping()
	public ResponseEntity<?> registReview(@ModelAttribute Review review){
		if(service.registReview(review)) return new ResponseEntity<>("등록 성공",HttpStatus.OK);
		return new ResponseEntity<>("등록 실패", HttpStatus.BAD_REQUEST);
	}
	
	// 리뷰 삭제
	@Operation(summary = "리뷰 삭제", description = "리뷰 삭제")
	@DeleteMapping("/delete/{reviewId}")
	public ResponseEntity<?> removeReview(@PathVariable("reviewId") String reviewId){
		return null;
		
	}
	
	// 리뷰 수정

}
