package com.ssafit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafit.service.ReviewService;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Review", description = "리뷰 기능")
@RestController
@RequestMapping("/review")
public class ReviewController {
	
	@Autowired
	ReviewService reviewService;
	
}