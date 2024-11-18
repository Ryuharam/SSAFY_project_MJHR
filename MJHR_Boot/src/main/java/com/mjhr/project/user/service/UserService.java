package com.mjhr.project.user.service;

import java.util.List;

import com.mjhr.project.user.dto.User;

public interface UserService {
	boolean addUser(User user);
	List<User> getAllUsers();
	User getUserById(int id);
	boolean updateUser(int id, User user);
	boolean deleteUser(int id);
}
