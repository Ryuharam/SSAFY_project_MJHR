package com.mjhr.project.user.service;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

//	@Override // 사용자 회원가입
//	public boolean registerUser(User user) {
//		return dao.insertUser(user) == 1;
//	}
	
	@Override
	public boolean registerUser(User user) {
	    // 이메일 필드 유효성 검사
	    if (user.getEmail() == null || user.getEmail().trim().isEmpty()) {
	        throw new IllegalArgumentException("이메일은 필수 입력 항목입니다.");
	    }

	    // 다른 필수 필드들의 유효성 검사
	    if (user.getUserId() == null || user.getUserId().trim().isEmpty() ||
	        user.getUserPw() == null || user.getUserPw().trim().isEmpty() ||
	        user.getUserName() == null || user.getUserName().trim().isEmpty()) {
	        throw new IllegalArgumentException("모든 필수 항목을 입력해주세요.");
	    }

	    // 이메일 형식 검사 (간단한 예시)
	    if (!user.getEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
	        throw new IllegalArgumentException("올바른 이메일 형식이 아닙니다.");
	    }

	    // 데이터베이스에 사용자 정보 삽입
	    try {
	        return dao.insertUser(user) == 1;
	    } catch (DataIntegrityViolationException e) {
	        // 데이터베이스 제약 조건 위반 (예: 중복된 이메일)
	        throw new RuntimeException("이미 등록된 이메일입니다.", e);
	    } catch (Exception e) {
	        // 기타 예외 처리
	        throw new RuntimeException("사용자 등록 중 오류가 발생했습니다.", e);
	    }
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
