package com.mjhr.project.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjhr.project.user.dao.UserDao;
import com.mjhr.project.user.dto.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao dao;

	@Override // 사용자 전체 정보 조회
	public List<User> getUserList() {
		return dao.selectAllUsers();
	}
	
	@Override // 사용자 정보 등록
	public boolean signup(User user) {
		return dao.insertUser(user) == 1; 
	}

	@Override // 로그인
	public User login(String id, String password) {
		Map<String, String> info = new HashMap<>();
		info.put("id", id);
		info.put("password", password);
		User tmp = dao.selectOne(info);
		return tmp;
	}

	@Override // 로그아웃
	public void logoutUser() {
		// TODO Auto-generated method stub

	}


//	@Override // 사용자 개인 정보 조회
//	public User getUserById(int id) {
//		// TODO Auto-generated method stub
//		return dao.selectUserById(id);
//	}
//
//	@Override // 사용자 개인 정보 수정
//	public boolean updateUser(String id, User user) {
//		if (id != user.getUserId())
//			return false;
//		return dao.updateUser(user);
//	}
//
//	@Override // 사용자 개인 정보 삭제
//	public boolean deleteUser(int id) {
//		int result = dao.deleteUser(id);
//		return result == 1;
//	}

}
