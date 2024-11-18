package com.ssafit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import com.ssafit.model.dto.*;
import com.ssafit.service.VideoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(name = "Home", description = "메인 화면")
@RestController
@RequestMapping("/main")
public class HomeController {
	
	@Autowired
	VideoService videoService;
	
	@Operation(summary = "인기동영상 TOP 10 조회", description = "인기동영상 TOP 10의 정보를 조회합니다.")
    @GetMapping("")
    public ResponseEntity<?> list() {
		List<Video> popularVideos = videoService.getPopularVideos(10);
    	return ResponseEntity.ok(popularVideos);
    }
}