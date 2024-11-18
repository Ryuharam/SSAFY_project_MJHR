package com.ssafit.service;

import java.util.List;

import com.ssafit.model.dto.Video;

public interface VideoService {

	// 영상 등록
	public void registerVideo(Video video);

	// 특정 영상 조회
	public Video getVideoById(int videoId);

	// 전체 영상 목록 조회
	public List<Video> getAllVideos();

	// 운동 부위별 영상 조회
	public List<Video> getVideosByBodyPart(String part);

	// 인기 영상 조회 (조회수 기준)
	public List<Video> getPopularVideos(int limit);

	// 영상 정보 수정
	public int updateVideoInfo(Video video);

	// 영상 삭제
	public int removeVideo(int videoId);

	// 조회수 증가
	public int incrementViewCount(int videoId);
}