package com.mjhr.project.review.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mjhr.project.user.dto.User;
import com.mjhr.project.user.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping("") // 사용자 정보 등록
	public ResponseEntity<String> addUser(@RequestBody User user) {
		boolean result = service.addUser(user);
		return result ? ResponseEntity.status(HttpStatus.CREATED).body("User added successfully")
				: ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add user");
	}

	@GetMapping("") // 사용자 전체 정보 조회
	public ResponseEntity<List<User>> getAllusers() {
		List<User> list = service.getAllUsers();
		if (list != null & list.size() != 0) {
			return ResponseEntity.status(HttpStatus.OK).body(list);
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@GetMapping("/{id}") // 사용자 개인 정보 조회
	public ResponseEntity<User> getUserById(@PathVariable("id") int id) {
		User user = service.getUserById(id);
		return user != null ? ResponseEntity.status(HttpStatus.OK).body(user)
				: ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@PutMapping("/{id}") // 사용자 개인 정보 수정
	public ResponseEntity<String> updateUser(@RequestBody User user, @PathVariable("id") int id) {
		boolean result = service.updateUser(id, user);
		return result ? ResponseEntity.status(HttpStatus.OK).body("User updated sucessfully")
				: ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update user");
	}

	@DeleteMapping("/{id}") // 사용자 개인 정보 삭제
	public ResponseEntity<String> deleteUser(@PathVariable("id") int id) {
		boolean result = service.deleteUser(id);
		return result ? ResponseEntity.status(HttpStatus.OK).body("User deleted successfully")
				: ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete user");
	}
}
