package com.mjhr.project.book.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mjhr.project.book.dto.Book;
import com.mjhr.project.book.dto.BookLike;
import com.mjhr.project.book.service.BookLikeService;
import com.mjhr.project.user.dto.User;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/booklike")
@Tag(name = "BookLike", description = "도서 좋아요 관리")
public class BookLikeController {

	private final BookLikeService service;

	public BookLikeController(BookLikeService service) {
		this.service = service;
	}

	@Operation(summary = "도서 좋아요", description = "도서 좋아요 등록")
	@PostMapping("/user/{userId}/book/{isbn}")
	public ResponseEntity<?> clickBookLike(@PathVariable("userId") String userId, @PathVariable("isbn") String isbn) {
	    System.out.println("userId : " + userId + " isbn : " + isbn);

	    if (service.createBookLike(userId, isbn)) {
	        return ResponseEntity.ok("좋아요 성공");
	    }
	    return ResponseEntity.status(HttpStatus.CONFLICT).body("이미 좋아요한 상태");
	}


	// 좋아요 취소
	@Operation(summary = "도서 좋아요 취소", description = "도서 좋아요 삭제")
	@DeleteMapping("/user/{userId}/book/{isbn}")
	public ResponseEntity<Integer> clickBookUnlike(@PathVariable("userId") String userId, @PathVariable("isbn") String isbn) {
	    System.out.println("userId : " + userId + ", isbn : " + isbn);

	    if (service.removeBookLike(userId, isbn)) {
	        int updatedLikeCount = service.getBookLikeCount(isbn); // 좋아요 수 재계산
	        return ResponseEntity.ok(updatedLikeCount);
	    }
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(-1); // 실패 시 -1 반환
	}

	
	@Operation(summary = "사용자의 도서 좋아요 여부 확인")
	@GetMapping("/user/{userId}/book/{isbn}")
	public ResponseEntity<Boolean> isBookLikedByUser(
	        @PathVariable("userId") String userId,
	        @PathVariable("isbn") String isbn) {
	    // 좋아요 상태 확인
	    boolean isLiked = service.isBookLikedByUser(userId, isbn);
	    return new ResponseEntity<>(isLiked, HttpStatus.OK);
	}

	

	@Operation(summary = "사용자 좋아요 리스트 조회", description = "사용자가 좋아요한 도서 리스트를 조회합니다")
	@GetMapping("/user/{userId}")
	public ResponseEntity<?> getMyBookLike(@PathVariable("userId") String userId) {
		
		System.out.println("userId : " + userId);

		List<BookLike> myList = service.getMyBookLike(userId);

		if (myList == null || myList.size() == 0) {
			return new ResponseEntity<>("좋아요 한 도서가 없습니다.", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(myList, HttpStatus.OK);
	}

	@Operation(summary = "사용자 좋아요 도서 수 ", description = "사용자가 좋아요 한 도서의 수를 반환합니다.")
	@GetMapping("/user/{userId}/count")
	public ResponseEntity<?> getMyBookLikeCount(@PathVariable("userId") String userId) {

		System.out.println("userId : " + userId);

		int count = service.getMyBookLikeCount(userId);

		if (count == 0) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(count, HttpStatus.OK);
	}

	@Operation(summary = "도서의 좋아요 한 사용자 조회", description = "도서를 좋아요 한 사용자를 조회합니다.")
	@GetMapping("/book/{isbn}/users")
	public ResponseEntity<?> getBookLike(@PathVariable("isbn") String isbn) {

		System.out.println("isbn : " + isbn);

		List<BookLike> bookList = service.getBookLike(isbn);

		if (bookList == null || bookList.size() == 0) {
			return new ResponseEntity<>("도서를 좋아요한 사람이 없습니다", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(bookList, HttpStatus.OK);
	}

	@Operation(summary = " 도서를 좋아요한 사람 수", description = "도서를 좋아요 한 사람 수를 반환합니다.")
	@GetMapping("/book/{isbn}/count")
	public ResponseEntity<?> getBookLikeCount(@PathVariable("isbn") String isbn) {
	    System.out.println("isbn : " + isbn);

	    try {
	        int count = service.getBookLikeCount(isbn);

	        // 좋아요가 없을 경우에도 0 반환
	        return new ResponseEntity<>(count, HttpStatus.OK);
	    } catch (Exception e) {
	        // 예외 발생 시 로그 출력 및 500 에러 반환
	        System.err.println("Error fetching like count: " + e.getMessage());
	        e.printStackTrace();
	        return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}

}
