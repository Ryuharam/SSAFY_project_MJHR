package com.mjhr.project.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.mjhr.project.user.interceptor.JwtInterceptor;


@Configuration
public class WebConfig implements WebMvcConfigurer{
	
	@Autowired
	private JwtInterceptor jwtInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(jwtInterceptor).addPathPatterns("/**") //모든 요청
		.excludePathPatterns("/api-user/**","/swagger-ui/**","/v3/api-docs/**"); //회원가입하는데 로그인 상태?
	}
	
	
	
	
	// 인터셉터 등록 시 사용
	// 예시
//	@Autowired
//	AdminInterceptor adminInterceptor;
//	
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(adminInterceptor).addPathPatterns("/api-user/users");
//	}
	
}
