package com.ssafit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafit.model.dao.VideoDao;
import com.ssafit.model.dto.Video;

@Service
public class VideoServiceImpl implements VideoService {

	@Autowired
	VideoDao videoDao;

	// 영상 등록
	public int registerVideo(Video video) {
		return videoDao.insertVideo(video);
	}

	// 특정 영상 조회
	public Video getVideoById(int videoId) {
		// videoDao.selectVideo() 호출
		return videoDao.selectVideo(videoId);
	}

	// 전체 영상 목록 조회
	public List<Video> getAllVideos() {
		return videoDao.selectAllVideos();
	}

	// 운동 부위별 영상 조회
	public List<Video> getVideosByBodyPart(String part) {
		return videoDao.selectVideosByPart(part);
	}

	// 인기 영상 조회 (조회수 기준)
	public List<Video> getPopularVideos(int limit) {
		// videoDao.selectTopViewedVideos() 호출
		return videoDao.selectTopViewedVideos(limit);
	}

	// 영상 정보 수정
	public int updateVideoInfo(Video video) {
		return videoDao.updateVideo(video);
	}

	// 영상 삭제
	public int removeVideo(int videoId) {
		return videoDao.deleteVideo(videoId);
	}

	// 조회수 증가
	public int incrementViewCount(int videoId) {
		return videoDao.increaseViewCount(videoId);
	}
}