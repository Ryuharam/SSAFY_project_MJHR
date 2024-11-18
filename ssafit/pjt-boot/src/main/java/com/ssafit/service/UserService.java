package com.ssafit.service;

import java.util.List;

import com.ssafit.model.dto.User;

public interface UserService {
    
    // 회원 가입
    public void registerUser(User user);
    
    // 회원 정보 조회
    public User getUserById(String userId);
    
    // 이메일로 회원 조회
    public User getUserByEmail(String email);
    
    // 회원 정보 수정
    public int updateUserInfo(User user);
    // 회원 탈퇴
    public int withdrawUser(String userId);
    
    // 로그인
    public User loginUser(String userId, String password);

    // 팔로워 목록 조회
    public List<String> getFollowersList(String userId);
    
    // 팔로잉 목록 조회
    public List<String> getFollowingList(String userId);
    // 팔로우 추가
    public int followUser(String followerId, String followingId);
    // 팔로우 취소
    public int unfollowUser(String followerId, String followingId);
}