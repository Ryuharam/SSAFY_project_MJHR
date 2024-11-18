package com.ssafit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafit.model.dto.Video;
import com.ssafit.service.VideoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Video", description = "동영상")
@RestController
@RequestMapping("/video")
public class VideoController {

	@Autowired
	private VideoService videoService;

	@Operation(summary = "동영상 등록", description = "운동 영상을 등록합니다.")
	@PostMapping
	public ResponseEntity<Void> registerVideo(@RequestBody Video video) throws Exception {
		videoService.registerVideo(video);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@Operation(summary = "동영상 조회", description = "선택한 운동 영상을 조회합니다.")
	@GetMapping("/{videoId}")
	public ResponseEntity<Video> getVideo(@PathVariable(name = "videoId") int videoId) throws Exception {
		Video video = videoService.getVideoById(videoId);
		System.out.println(video.getVideoId());
		if (video != null) {
			// 조회수 증가
			videoService.incrementViewCount(videoId);
			return new ResponseEntity<>(video, HttpStatus.OK);
		} 
		return new ResponseEntity<>(video, video == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
	}

	@Operation(summary = "전체 영상 목록 조회", description = "전체 영상 목록을 조회합니다.")
	@GetMapping
	public ResponseEntity<List<Video>> getAllVideos() throws Exception {
		List<Video> videos = videoService.getAllVideos();
		return new ResponseEntity<>(videos, videos == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
	}

	@Operation(summary = "운동 부위별 영상 조회", description = "운동 부위별 영상을 조회합니다.")
	@GetMapping("/part/{part}")
	public ResponseEntity<List<Video>> getVideosByBodyPart(@PathVariable(name = "part") String part) throws Exception {
		List<Video> videos = videoService.getVideosByBodyPart(part);
		return new ResponseEntity<>(videos, videos == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
	}

	@Operation(summary = "영상 정보 수정", description = "영상 정보를 수정합니다.")
	@PutMapping("/{videoId}")
	public ResponseEntity<?> updateVideo(@PathVariable(name = "videoId") int videoId, @RequestBody Video video)
			throws Exception {
		video.setVideoId(videoId);
		int result = videoService.updateVideoInfo(video);
		return new ResponseEntity<>(result, result == 1 ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
	}

	@Operation(summary = "영상 삭제", description = "선택한 영상을 삭제합니다.")
	@DeleteMapping("/{videoId}")
	public ResponseEntity<?> removeVideo(@PathVariable(name = "videoId") int videoId) {
		int result = videoService.removeVideo(videoId);
		return new ResponseEntity<>(result, result == 1 ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
	}
}