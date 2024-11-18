package com.ssafit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafit.model.dao.UserDao;
import com.ssafit.model.dto.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	// 회원 가입
	public void registerUser(User user) {
		// userDao.insertUser() 호출
	}

	// 회원 정보 조회
	public User getUserById(String userId) {
		// userDao.selectUser() 호출
		return userDao.selectUser(userId);
	}

	// 이메일로 회원 조회
	public User getUserByEmail(String email) {
		// userDao.selectUserByEmail() 호출
		return userDao.selectUserByEmail(email);
	}

	// 회원 정보 수정
	public int updateUserInfo(User user) {
		return userDao.updateUser(user);
	}

	// 회원 탈퇴
	public int withdrawUser(String userId) {
		return userDao.deleteUser(userId);
	}

	// 로그인
	public User loginUser(String userId, String password) {
		// userDao.login() 호출
		return userDao.login(userId, password);
	}

	// 팔로워 목록 조회
	public List<String> getFollowersList(String userId) {
		// userDao.selectFollowers() 호출
		return userDao.selectFollowers(userId);
	}

	// 팔로잉 목록 조회
	public List<String> getFollowingList(String userId) {
		// userDao.selectFollowing() 호출
		return userDao.selectFollowing(userId);
	}

	// 팔로우 추가
	public int followUser(String followerId, String followingId) {
		return userDao.addFollow(followerId, followingId);
	}

	// 팔로우 취소
	public int unfollowUser(String followerId, String followingId) {
		return userDao.removeFollow(followerId, followingId);
	}
}