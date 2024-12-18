package com.mjhr.project.user.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.mjhr.project.user.dto.User;
import com.mjhr.project.user.dto.UserFile;

@Mapper
public interface UserDao {
	//사용자 전체 목록
	public List<User> selectAllUsers();
	//사용자 등록
	public int insertUser(User user);
	//사용자 조회
	public User selectOne(Map<String, String> info);
	// 사용자 탈퇴
	public int deleteUser(int id);	
	//사용자 닉네임 검색
	public User selectUserByNic(String nic);
	//사용자 파일 경로 저장 
	public int uploadUserFile(UserFile userfile);
	
//	//사용자 정보 수정
//	public boolean updateUser(User user);
}

