package com.mjhr.project.user.dao;

import java.util.List;

import com.mjhr.project.user.dto.User;

public interface UserDao {
	boolean insertUser(User user);
	List<User> selectAllUsers();
	User selectUserById(int id);
	boolean updateUser(User user);
	int deleteUser(int id);
}
