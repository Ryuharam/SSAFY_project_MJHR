package com.mjhr.project.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mjhr.project.jwt.JwtUtil;
import com.mjhr.project.user.dto.User;
import com.mjhr.project.user.service.UserService;

import io.swagger.v3.oas.annotations.Operation;


@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

	private final UserService userService;
	private final JwtUtil jwtUtil;

	public UserController(UserService userService, JwtUtil jwtUtil) {
		this.userService = userService;
		this.jwtUtil = jwtUtil;
	}

	@Operation(summary = "사용자 목록 전체 조회", description = "사용자 목록 전체 조회")
	@GetMapping("")
	public ResponseEntity<?> userList() {
		System.out.println(userService);
		List<User> list = userService.getUserList();
		if (list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<User>>(list, HttpStatus.OK);
	}

	@Operation(summary = "사용자 회원 가입", description = "사용자 회원 가입")
	@PostMapping("/signup")
	public ResponseEntity<String> write(@RequestBody User user) {
		if (userService.signup(user)) {
			return ResponseEntity.status(HttpStatus.CREATED).body("User added successfully");
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add user");
	}

	@Operation(summary = "사용자 로그인", description = "사용자 로그인")
	@PostMapping("/login")							//user : json 객체 형태로 넘어옴
	public ResponseEntity<Map<String, Object>> login(@RequestBody User user) {
		HttpStatus status = null;
		Map<String, Object> result = new HashMap<>();
		User loginUser = userService.login(user.getUserId(), user.getUserPw());

		System.out.println(loginUser);
		if (loginUser != null) {
			result.put("message", "login 성공");
			result.put("access-token", jwtUtil.createToken(loginUser.getUserId()));
			// id도 같이 넘겨주면 번거로운 작업을 할 필요는 없어
			status = HttpStatus.ACCEPTED;
		} else {
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<>(result, status);
	}
	
	@Operation(summary = "사용자 닉네임 조건 검색", description = "사용자를 닉네임 조건으로 검색")
	@GetMapping("/search/{nic}")
	public ResponseEntity<?> search(@PathVariable("nic") String nic){
		User user = userService.searchUserByNic(nic);
		if(user == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("닉네임에 해당하는 사용자가 없습니다.");
		}
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	
}

