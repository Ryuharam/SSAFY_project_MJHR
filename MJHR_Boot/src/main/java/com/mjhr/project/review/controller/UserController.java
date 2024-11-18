package com.mjhr.project.review.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mjhr.project.jwt.JwtUtil;
import com.mjhr.project.user.dto.User;
import com.mjhr.project.user.service.UserService;


@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

	private final UserService userService;
	private final JwtUtil jwtUtil;

//	@Autowired
	public UserController(UserService userService, JwtUtil jwtUtil) {
		this.userService = userService;
		this.jwtUtil = jwtUtil;
	}

	// 사용자 목록 전체 가져오기
	@GetMapping("/user")
	public ResponseEntity<?> userList() {
		List<User> list = userService.getUserList();
		if (list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<User>>(list, HttpStatus.OK);
	}

	// 사용자 회원가입
	@PostMapping("/signup")
	public ResponseEntity<String> write(@RequestBody User user) {
		if (userService.signup(user)) {
			return ResponseEntity.status(HttpStatus.CREATED).body("User added successfully");
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add user");
	}

	// 사용자 로그인
	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login(@RequestBody User user) {
		HttpStatus status = null;
		Map<String, Object> result = new HashMap<>();
		User loginUser = userService.login(user.getUserId(), user.getUserPw());

		System.out.println(loginUser);
		if (loginUser != null) {
			result.put("message", "login 성공");
//			result.put("access-token", jwtUtil.createToken(loginUser.getName()));
			// id도 같이 넘겨주면 번거로운 작업을 할 필요는 없어
			status = HttpStatus.ACCEPTED;
		} else {
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<>(result, status);
	}
}
