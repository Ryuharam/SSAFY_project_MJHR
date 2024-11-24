package com.mjhr.project.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
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

import com.mjhr.project.book.dto.Book;
import com.mjhr.project.book.dto.PageResponse;
import com.mjhr.project.book.service.BookService;
import com.mjhr.project.common.dto.SearchCondition;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Book", description = "도서")
@RestController
@RequestMapping("/book")
public class BookController {

	private final BookService service;

	public BookController(@Qualifier("bookServiceImpl") BookService service) {
		this.service = service;
	}

	@Operation(summary = "도서 전체 조회", description =  "도서 전체 목록을 페이지 단위로 조회합니다.")
	@GetMapping
	public ResponseEntity<PageResponse<Book>> getAllBooks(
	        @RequestParam(value = "page", defaultValue = "1") int page,
	        @RequestParam(value = "size", defaultValue = "100") int size) {
	    if (page < 1 || size < 1) {
	        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	    }
	    
	    List<Book> books = service.getAllBooks(page, size);
	    int totalItems = service.getTotalBookCount(); // 전체 도서 수 조회
	    int totalPages = (int) Math.ceil((double) totalItems / size);

	    PageResponse<Book> response = new PageResponse<>(books, page, size, totalPages, totalItems);
	    return new ResponseEntity<>(response, HttpStatus.OK);
	}


	// isbn에 해당하는 도서 조회
	@Operation(summary = "isbn에 해당하는 도서 조회", description = "isbn에 해당하는 도서를 조회합니다.")
	@GetMapping({ "/{isbn}" })
	public ResponseEntity<Book> getBook(@PathVariable("isbn") String isbn) {
		Book book = service.getBookByIsbn(isbn);
		return new ResponseEntity<Book>(book, book == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
	}

	// 도서 검색
	@Operation(summary = "도서 검색", description = "도서 검색, key는 title, author, publisher만 가능")
	@GetMapping("/search")
	public ResponseEntity<PageResponse<Book>> searchBook(@ModelAttribute SearchCondition getCondition,
	                                                     @RequestParam(value = "page", defaultValue = "1") int page,
	                                                     @RequestParam(value = "size", defaultValue = "100") int size) {

	    if (page < 1 || size < 1) {
	        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	    }

	    // 검증 및 기본값 설정
	    String key = getCondition.getKey();
	    if (!"title".equals(key) && !"author".equals(key) && !"publisher".equals(key)) {
	        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	    }

	    String orderBy = getCondition.getOrderBy();
	    if (orderBy == null || (!"title".equals(orderBy) && !"author".equals(orderBy))) {
	        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	    }

	    String orderDir = getCondition.getOrderDir();
	    if (orderDir == null || (!"ASC".equalsIgnoreCase(orderDir) && !"DESC".equalsIgnoreCase(orderDir))) {
	        orderDir = "ASC"; // 기본값
	    }

	    // 검색 조건 설정
	    getCondition.setOrderBy(orderBy);
	    getCondition.setOrderDir(orderDir);
	    getCondition.setOffset((page - 1) * size); // 시작 위치 계산
	    getCondition.setSize(size); // 페이지 크기 설정

	    // 서비스 호출
	    List<Book> result = service.searchBook(getCondition);
	    int totalItems = service.getSearchResultCount(getCondition); // 검색 결과 총 개수
	    int totalPages = (int) Math.ceil((double) totalItems / size);

	    PageResponse<Book> response = new PageResponse<>(result, page, size, totalPages, totalItems);

	    return new ResponseEntity<>(response, HttpStatus.OK);
	}


	@Operation(summary = "도서 등록", description = "도서 등록")
	@PostMapping()
	public ResponseEntity<String> registBook(@ModelAttribute Book book) {
		System.out.println("Controller 확인");
		System.out.println(book.toString());
		if (service.createBook(book)) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@Operation(summary = "도서 삭제", description = "도서 삭제")
	@DeleteMapping("/{isbn}")
	public ResponseEntity<String> deleteBook(@PathVariable("isbn") String isbn) {
		if (service.removeBook(isbn)) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}
	}

	// 도서 수정
	@Operation(summary = "도서 수정", description = "도서 수정")
	@PutMapping()
	public ResponseEntity<String> modifyBook(@ModelAttribute Book modifyBook) {
		System.out.println(modifyBook.getIsbn());

		Book book = service.getBookByIsbn(modifyBook.getIsbn());

		System.out.println(book);

		if (modifyBook.getTitle() != null)
			book.setTitle(modifyBook.getTitle());
		if (modifyBook.getAuthor() != null)
			book.setAuthor(modifyBook.getAuthor());
		if (modifyBook.getPublisher() != null)
			book.setPublisher(modifyBook.getPublisher());
		if (modifyBook.getImage() != null)
			book.setImage(modifyBook.getImage());
		if (modifyBook.getPubdate() != null)
			book.setPubdate(modifyBook.getPubdate());

		if (service.modifyBook(book)) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

}
