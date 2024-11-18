package com.ssafit.model.dao;

import com.ssafit.model.dto.Video;
import java.util.List;

public interface VideoDao {
	void insertVideo(Video video);

	Video selectVideo(int videoId);

	List<Video> selectAllVideos();

	List<Video> selectVideosByPart(String part);

	List<Video> selectTopViewedVideos(int limit);

	int updateVideo(Video video);

	int deleteVideo(int videoId);

	int increaseViewCount(int videoId);
}
