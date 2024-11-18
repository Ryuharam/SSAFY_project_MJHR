package com.mjhr.project.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mjhr.project.book.dto.Book;
import com.mjhr.project.book.service.BookService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="Book",description = "도서")
@RestController
@RequestMapping("/book")
public class BookController {
	
	private final BookService service;
	
	public BookController(@Qualifier("bookServiceImpl") BookService service) {
		this.service = service;
	}
	
	@Operation(summary = "도서 전체 조회", description = "도서 전체 목록을 조회합니다.")
	@GetMapping()
	public ResponseEntity<List<Book>> getAllBook(){
		List<Book> list = service.getAllBook();
		return new ResponseEntity<List<Book>>(list, list==null?HttpStatus.NOT_FOUND:HttpStatus.OK);
	}
	
	// isbn에 해당하는 도서 조회
	@Operation(summary = "isbn에 해당하는 도서 조회", description = "isbn에 해당하는 도서를 조회합니다.")
	@GetMapping({"/{isbn}"})
	public ResponseEntity<Book> getBook(@PathVariable("isbn") String isbn){
		Book book = service.getBookByIsbn(isbn);
		return new ResponseEntity<Book>(book, book==null?HttpStatus.NOT_FOUND:HttpStatus.OK);
	}
	
	// 도서 검색
	
	
	
	@Operation(summary = "도서 등록", description = "도서 등록")
	@PostMapping()
	public ResponseEntity<String> registBook(@RequestBody Book book){
		System.out.println("Controller 확인");
		System.out.println(book.toString());
		if(service.createBook(book)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@Operation(summary = "도서 삭제", description = "도서 삭제")
	@DeleteMapping("/{isbn}")
	public ResponseEntity<String> deleteBook(@PathVariable("isbn") String isbn){
		if(service.removeBook(isbn)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			
		}
	}
	
	// 도서 수정
	@Operation(summary = "도서 수정", description = "도서 수정")
	@PutMapping()
	public ResponseEntity<String> modifyBook(@RequestBody Book book){
		if(service.modifyBook(book)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
}
