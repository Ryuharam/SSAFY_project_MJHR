package com.mjhr.project.user.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.mjhr.project.jwt.JwtUtil;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtInterceptor implements HandlerInterceptor {
	private final String HEADER_Auth = "access-token";
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//option이라는 요청-메서드를 먼저 보냄
		if(request.getMethod().equals("OPTIONS"))
			return true;
		
		
		String token = request.getHeader(HEADER_Auth);
		if(token != null) { //토큰 들어있으면
			jwtUtil.validate(token);
			return true;
		}
		throw new Exception("유효하지 않은 접근");
		
		
	}
	
	
	
	

}

