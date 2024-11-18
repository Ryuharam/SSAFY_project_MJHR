package com.ssafit.model.dao;

import com.ssafit.model.dto.User;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface UserDao {
	void insertUser(User user);

	User selectUser(String userId);

	User selectUserByEmail(String email);

	int updateUser(User user);

	int deleteUser(String userId);

	User login(@Param("userId") String userId, @Param("password") String password);
	
	List<String> selectFollowers(String userId);

	List<String> selectFollowing(String userId);

	int addFollow(@Param("followerId")String followerId, @Param("followingId")String followingId);

	int removeFollow(@Param("followerId")String followerId, @Param("followingId")String followingId);
}