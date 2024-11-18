package com.mjhr.project.user.service;

import java.util.List;

import com.mjhr.project.user.dto.User;

public interface UserService {
	//사용자 전체 목록 불러오기
	public List<User> getUserList();
	//사용자 등록하기
	public boolean signup(User user);
	//로그인 하기
	public User login(String id, String password);
	//로그아웃 하기
	public void logoutUser();
//	//사용자 검색
//	User getUserById(int id);
//	//사용자 정보 수정
//	boolean updateUser(int id, User user);
//	//사용자 삭제 
//	boolean deleteUser(int id);
}
