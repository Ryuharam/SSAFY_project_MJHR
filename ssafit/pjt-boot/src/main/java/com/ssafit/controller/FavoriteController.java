package com.ssafit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafit.model.dto.Video;
import com.ssafit.service.FavoriteService;
import com.ssafit.service.VideoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



@Tag(name = "Favorite", description = "찜하기 기능")
@RestController
@RequestMapping("/favorite")
public class FavoriteController {
	
	@Autowired
	FavoriteService favoriteService;
	
	// 즐겨 찾기 추가
	@Operation(summary = "즐겨찾기 추가", description = "영상을 즐겨찾기에 추가합니다.")
	@PostMapping("/add/{userId}/{videoId}")
	public ResponseEntity<?> postMethodName(@PathVariable("userId") String userId, @PathVariable("videoId") int videoId) {
		int result = favoriteService.addToFavorites(userId, videoId);
		return new ResponseEntity<>(result, result==1?HttpStatus.OK:HttpStatus.BAD_REQUEST);
	}
	
	// 즐겨 찾기 삭제
	@Operation(summary = "즐겨찾기 삭제", description = "즐겨찾기에서 영상을 삭제합니다.")
	@DeleteMapping("/delete/{userId}/{videoId}")
	public ResponseEntity<?> deleteFavorite(@PathVariable("userId") String userId, @PathVariable("videoId") int videoId){
		int result = favoriteService.removeFromFavorites(userId, videoId);
		return new ResponseEntity<>(result, result==1?HttpStatus.OK:HttpStatus.BAD_REQUEST);
	}
	
	// 사용자의 즐겨찾기 목록 조회
	@Operation(summary = "즐겨찾기 조회", description = "사용자의 즐겨찾기 목록을 조회합니다.")
	@GetMapping("/{userId}")
	public ResponseEntity<List<Integer>> getMethodName(@RequestParam("userId") String userId) {
		List<Integer> list = favoriteService.getUserFavoriteVideos(userId);
		
		if(list != null && !list.isEmpty()) {
			return new ResponseEntity<List<Integer>>(list, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(list==null?HttpStatus.NOT_FOUND:HttpStatus.OK);
	}
	
	
	// 즐겨찾기 여부 확인
	@Operation(summary = "즐겨찾기 여부", description = "해당 영상을 즐겨찾기 했는지 확인합니다.")
	@GetMapping("/check/{userId}/{videoId}")
	public ResponseEntity<Boolean> isFavorite(@PathVariable("userId") String userId, @PathVariable("videoId") int videoId){
		boolean result = favoriteService.checkIfVideoIsFavorited(userId, videoId);
		return new ResponseEntity<>(result,HttpStatus.OK);
	}
	
}