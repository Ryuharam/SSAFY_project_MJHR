package com.mjhr.project.user.service;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mjhr.project.user.dao.UserDao;
import com.mjhr.project.user.dto.User;
import com.mjhr.project.user.dto.UserFile;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao dao;

	private final String upload_dir = "/경로 설정/";

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
		info.put("userId", id);
		info.put("userPw", password);
		User tmp = dao.selectOne(info);
		return tmp;
	}

	@Override // 로그아웃
	public void logoutUser() {
		// TODO Auto-generated method stub

	}

	@Override // 사용자 닉네임 검색
	public User searchUserByNic(String nic) {
		// TODO Auto-generated method stub
		return dao.selectUserByNic(nic);
	}

	@Override
	public boolean uploadUserFile(String userId, MultipartFile file) throws IOException, IllegalArgumentException {
		// 1. 파일이 비어있는지 확인
		if (file.isEmpty()) {
			throw new IllegalArgumentException("File is empty.");
		}

		// 2. 파일 저장 경로 및 이름 생성
		String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename(); // 고유한 파일 이름 생성
		Path filePath = Paths.get(upload_dir + fileName);

		// 3. 파일 저장
		file.transferTo(filePath.toFile());

		// 4. 데이터베이스에 파일 경로 저장
		UserFile userfile = new UserFile();	// 매개변수로 userId, filePath, fileName?
		int result = dao.uploadUserFile(userfile);

//		// 5. 데이터베이스 작업 실패 확인
//		if (result <= 0) {
//			throw new RuntimeException("No rows affected in the database while saving file information.");
//		}

		return true;
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
