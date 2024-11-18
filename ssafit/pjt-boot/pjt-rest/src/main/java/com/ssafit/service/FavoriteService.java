package com.ssafit.service;

import java.util.List;

public interface FavoriteService {

    // 즐겨찾기 추가
    public void addToFavorites(String userId, int videoId);

    // 즐겨찾기 삭제
    public void removeFromFavorites(String userId, int videoId);

    // 사용자의 즐겨찾기 영상 목록 조회
    public List<Integer> getUserFavoriteVideos(String userId);
    
    public boolean checkIfVideoIsFavorited(String userId, int videoId);
}