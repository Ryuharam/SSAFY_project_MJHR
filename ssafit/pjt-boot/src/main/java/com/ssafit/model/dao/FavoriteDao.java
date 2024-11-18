package com.ssafit.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FavoriteDao {
	int addFavorite(@Param("userId") String userId, @Param("videoId") int videoId);

	int removeFavorite(@Param("userId") String userId, @Param("videoId") int videoId);

	List<Integer> selectFavoriteVideos(@Param("userId") String userId);

	boolean isFavorite(@Param("userId") String userId, @Param("videoId") int videoId);
}