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
import org.springframework.web.bind.annotation.RestController;

import com.mjhr.project.book.dto.Book;
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

	@Operation(summary = "도서 전체 조회", description = "도서 전체 목록을 조회합니다.")
	@GetMapping()
	public ResponseEntity<List<Book>> getAllBook() {
		List<Book> list = service.getAllBook();
		return new ResponseEntity<List<Book>>(list, list == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
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
	public ResponseEntity<?> searchBook(@ModelAttribute SearchCondition getCondition) {
		
		System.out.println(getCondition);
		
	    // 검증 및 기본값 설정
	    String key = getCondition.getKey();
	    if (!"title".equals(key) && !"author".equals(key) && !"publisher".equals(key) ) {
	        return new ResponseEntity<>("key 값은 title, author, publisher만 가능합니다.", HttpStatus.BAD_REQUEST);
	    }

	    String orderBy = getCondition.getOrderBy();
	    if (orderBy == null || (!"title".equals(orderBy) && !"author".equals(orderBy))) {
	        return new ResponseEntity<>("orderBy 값은 'title' 또는 'author'만 가능합니다.", HttpStatus.BAD_REQUEST);
	    }

	    String orderDir = getCondition.getOrderDir();
	    if (orderDir == null || (!"ASC".equalsIgnoreCase(orderDir) && !"DESC".equalsIgnoreCase(orderDir))) {
	        orderDir = "ASC"; // 기본값 설정
	    }

	    // 검색 조건 객체 생성 및 설정
	    SearchCondition condition = new SearchCondition();
	    condition.setKey(key);
	    condition.setWord(getCondition.getWord());
	    condition.setOrderBy(orderBy);
	    condition.setOrderDir(orderDir);

	    // 서비스 호출
	    List<Book> result = service.searchBook(condition);

	    if (result == null || result.isEmpty()) {
	        return new ResponseEntity<>("검색 결과가 없습니다.", HttpStatus.NOT_FOUND);
	    }

	    return new ResponseEntity<>(result, HttpStatus.OK);
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
		
		if(modifyBook.getTitle()!=null) book.setTitle(modifyBook.getTitle());
		if(modifyBook.getAuthor()!=null) book.setAuthor(modifyBook.getAuthor());
		if(modifyBook.getPublisher()!=null) book.setPublisher(modifyBook.getPublisher());
		if(modifyBook.getBookImg()!=null) book.setBookImg(modifyBook.getBookImg());
		if(modifyBook.getPublicationDate()!=null) book.setPublicationDate(modifyBook.getPublicationDate());
		
		if (service.modifyBook(book)) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

}
