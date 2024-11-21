package com.mjhr.project.review.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mjhr.project.review.dto.ReviewComment;
import com.mjhr.project.review.service.ReviewCommentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@Tag(name = "ReviewComment", description = "독후감의 댓글")
@RequestMapping("/reviewcomment")
@RestController
public class ReviewCommentController {

	private final ReviewCommentService service;

	public ReviewCommentController(ReviewCommentService service) {
		this.service = service;
	}

	@Operation(summary = "독후감댓글조회", description = "해당 독후감의 댓글목록을 조회합니다")
	@GetMapping("/{reviewId}")
	public ResponseEntity<?> getReviewComment(@PathVariable("reviewId") String reviewId) {

		System.out.println(reviewId);

		List<ReviewComment> result = service.getReviewComment(reviewId);

		if (result == null) {
			return new ResponseEntity<>("실패", HttpStatus.NOT_FOUND);
		} else if (result.size() == 0) {
			return new ResponseEntity<>("댓글이 없습니다", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(result, HttpStatus.OK);

	}

	@Operation(summary = "사용자댓글조회", description = "사용자가 작성한 댓글을 조회합니다")
	@GetMapping("/user/{userId}")
	public ResponseEntity<?> getUserComment(@PathVariable("userId") String userId) {
		
		System.out.println(userId);
		
		List<ReviewComment> result = service.getUserComment(userId);

		if (result == null) {
			return new ResponseEntity<>("실패", HttpStatus.NOT_FOUND);
		} else if (result.size() == 0) {
			return new ResponseEntity<>("댓글이 없습니다", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@Operation(summary = "독후감댓글작성", description = "해당 독후감에 댓글을 작성합니다")
	@PostMapping("/{reviewId}")
	public ResponseEntity<?> createComment(@ModelAttribute ReviewComment comment) {
		
		System.out.println(comment);
		
		if(service.createComment(comment)) {
			return new ResponseEntity<>("작성 성공",HttpStatus.OK);
		}
		return new ResponseEntity<>("실패", HttpStatus.BAD_REQUEST);
	}

	@Operation(summary = "댓글 수정", description = "해당 댓글을 수정합니다")
	@PutMapping("{reviewId}/update")
	public ResponseEntity<?> modifyComment(@ModelAttribute ReviewComment comment) {
		
		System.out.println(comment);
		
		if(service.modifyComment(comment)) {
			return new ResponseEntity<>("수정 성공",HttpStatus.OK);
		}

		return new ResponseEntity<>("실패", HttpStatus.BAD_REQUEST);
	}

	@Operation(summary = "댓글 삭제", description = "해당 댓글을 삭제합니다")
	@DeleteMapping("/{reviewId}/delete")
	public ResponseEntity<?> removeComment(@ModelAttribute ReviewComment comment) {
		
		System.out.println(comment);
		
		if(service.removeComment(comment)) {
			return new ResponseEntity<>("삭제 성공",HttpStatus.OK);
		}
		
		return new ResponseEntity<>("실패", HttpStatus.BAD_REQUEST);
	}

}
