package com.ssafit.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FavoriteDao {
	void addFavorite(String userId, int videoId);

	void removeFavorite(String userId, int videoId);

	List<Integer> selectFavoriteVideos(String userId);

	boolean isFavorite(String userId, int videoId);
}