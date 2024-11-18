package com.ssafit.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ssafit.model.dto.User;
import com.ssafit.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "User", description = "회원 관리")
@RestController
@RequestMapping("/user")
public class UserController {

   @Autowired
   private UserService userService;

   @Operation(summary = "회원 가입", description = "새로운 회원을 등록합니다.")
   @PostMapping
   public ResponseEntity<Void> registerUser(@RequestBody User user) throws Exception {
       userService.registerUser(user);
       return new ResponseEntity<>(HttpStatus.CREATED);
   }

   @Operation(summary = "회원 정보 조회", description = "회원 ID로 회원 정보를 조회합니다.")
   @GetMapping("/{userId}")
   public ResponseEntity<User> getUserById(@PathVariable(name = "userId") String userId) throws Exception {
       User user = userService.getUserById(userId);
       return new ResponseEntity<>(user, user == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
   }

   @Operation(summary = "이메일로 회원 조회", description = "이메일로 회원 정보를 조회합니다.")
   @GetMapping("/email/{email}")
   public ResponseEntity<User> getUserByEmail(@PathVariable(name = "email") String email) throws Exception {
       User user = userService.getUserByEmail(email);
       return new ResponseEntity<>(user, user == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
   }

   @Operation(summary = "회원 정보 수정", description = "회원 정보를 수정합니다.")
   @PutMapping("/{userId}")
   public ResponseEntity<?> updateUser(@PathVariable(name = "userId") String userId, @RequestBody User user) throws Exception {
       user.setUserId(userId);
       int result = userService.updateUserInfo(user);
       return new ResponseEntity<>(result, result == 1 ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
   }

   @Operation(summary = "회원 탈퇴", description = "회원 정보를 삭제합니다.")
   @DeleteMapping("/{userId}")
   public ResponseEntity<?> withdrawUser(@PathVariable(name = "userId") String userId) throws Exception {
       int result = userService.withdrawUser(userId);
       return new ResponseEntity<>(result, result == 1 ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
   }

   @Operation(summary = "로그인", description = "아이디와 비밀번호로 로그인합니다.")
   @PostMapping("/login")
   public ResponseEntity<User> login(@RequestBody User user) throws Exception {
       User loginUser = userService.loginUser(user.getUserId(), user.getPassword());
       return new ResponseEntity<>(loginUser, loginUser == null ? HttpStatus.UNAUTHORIZED : HttpStatus.OK);
   }
   
   @Operation(summary = "팔로워 목록 조회", description = "특정 회원의 팔로워 목록을 조회합니다.")
   @GetMapping("/{userId}/followers")
   public ResponseEntity<List<String>> getFollowers(@PathVariable(name = "userId") String userId) throws Exception {
       List<String> followers = userService.getFollowersList(userId);
       return new ResponseEntity<>(followers, followers == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
   }

   @Operation(summary = "팔로잉 목록 조회", description = "특정 회원의 팔로잉 목록을 조회합니다.")
   @GetMapping("/{userId}/following")
   public ResponseEntity<List<String>> getFollowing(@PathVariable(name = "userId") String userId) throws Exception {
       List<String> following = userService.getFollowingList(userId);
       return new ResponseEntity<>(following, following == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
   }

   @Operation(summary = "팔로우", description = "다른 회원을 팔로우합니다.")
   @PostMapping("/{followerId}/follow/{followingId}")
   public ResponseEntity<?> followUser(
           @PathVariable(name = "followerId") String followerId,
           @PathVariable(name = "followingId") String followingId) throws Exception {
       int result = userService.followUser(followerId, followingId);
       return new ResponseEntity<>(result, result == 1 ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
   }

   @Operation(summary = "언팔로우", description = "팔로우를 취소합니다.")
   @DeleteMapping("/{followerId}/unfollow/{followingId}")
   public ResponseEntity<?> unfollowUser(
           @PathVariable(name = "followerId") String followerId,
           @PathVariable(name = "followingId") String followingId) throws Exception {
       int result = userService.unfollowUser(followerId, followingId);
       return new ResponseEntity<>(result, result == 1 ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
   }
}