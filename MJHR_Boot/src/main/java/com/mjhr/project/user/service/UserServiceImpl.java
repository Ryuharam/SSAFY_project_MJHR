package com.mjhr.project.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mjhr.project.user.dao.UserDao;
import com.mjhr.project.user.dto.User;

public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao dao;

	@Override // 사용자 정보 등록
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		return dao.insertUser(user);
	}

	@Override // 사용자 전체 정보 조회
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return dao.selectAllUsers();
	}

	@Override // 사용자 개인 정보 조회
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return dao.selectUserById(id);
	}

	@Override // 사용자 개인 정보 수정
	public boolean updateUser(int id, User user) {
		if (id != user.getUserId())
			return false;
		return dao.updateUser(user);
	}

	@Override // 사용자 개인 정보 삭제
	public boolean deleteUser(int id) {
		int result = dao.deleteUser(id);
		return result==1;
	}
	
	
	
	

}
