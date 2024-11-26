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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mjhr.project.book.dto.PageResponse;
import com.mjhr.project.common.dto.SearchCondition;
import com.mjhr.project.review.dto.Review;
import com.mjhr.project.review.service.ReviewService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Review", description = "독후감")
@RestController
@RequestMapping("/review")
public class ReviewController {

	@Autowired
	private final ReviewService service;

	public ReviewController(ReviewService service) {
		this.service = service;
	}

	@Operation(summary = "전체 독후감 조회", description = "독후감 전체 목록을 조회합니다")
	@GetMapping("")
	public ResponseEntity<?> getAllReview() {
		List<Review> list = service.getAllReview();
		if (list == null || list.size() == 0) {
			return new ResponseEntity<>("리뷰를 찾지 못했습니다.", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@Operation(summary = "특정 독후감 조회", description = "독후감 상세 페이지를 위한 특정 독후감 정보를 조회합니다")
	@GetMapping("/{reviewId}")
	public ResponseEntity<?> getReviewByReviewId(@PathVariable("reviewId") String reviewId) {
		Review review = service.getReviewByReviewId(reviewId);
		if (review == null)
			return new ResponseEntity<>("리뷰를 찾지 못했습니다.", HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(review, HttpStatus.OK);
	}

	@Operation(summary = "사용자 독후감 조회", description = "사용자가 작성한 독후감을 조회합니다")
	@GetMapping("/myreview/{userId}")
	public ResponseEntity<?> getMyReview(@PathVariable("userId") String userId,
			@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "size", defaultValue = "100") int size) {
		SearchCondition condition = new SearchCondition();
		condition.setKey("user_id");
		condition.setWord(userId.trim());
		return searchReviewByKey(condition, page, size);
	}

	@Operation(summary = "도서 독후감 조회", description = "도서에 관련된 독후감을 조회합니다")
	@GetMapping("/book/{isbn}")
	public ResponseEntity<?> getBookReview(@PathVariable("isbn") String isbn,
			@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "size", defaultValue = "100") int size) {
		SearchCondition condition = new SearchCondition();
		condition.setKey("isbn");
		condition.setWord(isbn);
		return searchReviewByKey(condition, page, size);
	}

	@Operation(summary = "독후감 검색", description = "검색 조건에 따라 독후감을 검색합니다")
	@GetMapping("/search")
	public ResponseEntity<?> searchReviewByKey(@ModelAttribute SearchCondition getCondition,
			@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "size", defaultValue = "100") int size) {

		SearchCondition condition = new SearchCondition();

		if (page < 1 || size < 1) {
			System.out.println("1");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		// 검색 키 검증
		String key = getCondition.getKey();
		if (key == null || key.isEmpty()) {
			key = "review_title"; // 기본값 설정
		}

		// 정렬 키 검증
		String orderBy = getCondition.getOrderBy();
		if (orderBy == null || orderBy.isEmpty()) {
			orderBy = "review_title"; // 기본값 설정
		}

		// 정렬 방향 검증
		String orderDir = getCondition.getOrderDir();
		if (orderDir == null || (!"ASC".equalsIgnoreCase(orderDir) && !"DESC".equalsIgnoreCase(orderDir))) {
			orderDir = "ASC"; // 기본값
		}

		// 검색 조건 설정
		condition.setKey(key);
		condition.setWord(getCondition.getWord() == null ? "" : getCondition.getWord());
		condition.setOrderBy(orderBy);
		condition.setOrderDir(orderDir);
		condition.setOffset((page - 1) * size); // 시작 위치 계산
	    condition.setSize(size); // 페이지 크기 설정

		System.out.println(condition);

		// 검색 수행
		List<Review> result = service.searchReview(condition);
		if (result == null || result.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		int totalItems = service.getSearchResultCount(condition); // 검색 결과 총 개수
	    int totalPages = (int) Math.ceil((double) totalItems / size);

		// 응답 객체 생성
		PageResponse<Review> response = new PageResponse<>(result, page, size, totalPages, totalItems);

		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@Operation(summary = "독후감 등록", description = "독후감 작성")
	@PostMapping()
	public ResponseEntity<?> registReview(@ModelAttribute Review review) {
		System.out.println(review);
		if (service.registReview(review))
			return new ResponseEntity<>("등록 성공", HttpStatus.OK);
		return new ResponseEntity<>("등록 실패", HttpStatus.BAD_REQUEST);
	}

	@Operation(summary = "독후감 삭제", description = "독후감 삭제")
	@DeleteMapping("/delete/{reviewId}")
	public ResponseEntity<?> removeReview(@PathVariable("reviewId") String reviewId) {
		System.out.println(reviewId);
		if (service.removeReview(reviewId))
			return new ResponseEntity<>("삭제 성공", HttpStatus.OK);
		return new ResponseEntity<>("삭제 실패", HttpStatus.BAD_REQUEST);

	}

	@Operation(summary = "독후감 수정", description = "독후감 수정")
	@PutMapping("/update")
	public ResponseEntity<?> modifyReview(@ModelAttribute Review modifyreview) {

		System.out.println(modifyreview);

		Review review = service.getReviewByReviewId(modifyreview.getReviewId());

		System.out.println(review);

		if (modifyreview.getReviewTitle() != null)
			review.setReviewTitle(modifyreview.getReviewTitle());
		if (modifyreview.getReviewContent() != null)
			review.setReviewContent(modifyreview.getReviewContent());

		if (service.modifyReview(review))
			return new ResponseEntity<>("수정 성공", HttpStatus.OK);
		return new ResponseEntity<>("수정 실패", HttpStatus.BAD_REQUEST);
	}

}
