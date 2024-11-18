package com.ssafit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafit.model.dao.FavoriteDao;

@Service
public class FavoriteServiceImpl implements FavoriteService {

	@Autowired
	FavoriteDao favoriteDao;
	
    // 즐겨찾기 추가
    public int addToFavorites(String userId, int videoId) {
        // favoriteDao.addFavorite() 호출
    	return favoriteDao.addFavorite(userId,videoId);
    }

    // 즐겨찾기 삭제
    public int removeFromFavorites(String userId, int videoId) {
        // favoriteDao.removeFavorite() 호출
    	 return favoriteDao.removeFavorite(userId,videoId);
    }

    // 사용자의 즐겨찾기 영상 목록 조회
    public List<Integer> getUserFavoriteVideos(String userId) {
        // favoriteDao.selectFavoriteVideos() 호출
        return favoriteDao.selectFavoriteVideos(userId);
    }

    // 즐겨찾기 여부 확인
    public boolean checkIfVideoIsFavorited(String userId, int videoId) {
        // favoriteDao.isFavorite() 호출
        return favoriteDao.isFavorite(userId, videoId);
    }
}