package com.mjhr.project.jwt;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
	//비밀키 필요
	private String key = "SSAFY_mjhr_project_JavaTrack_SecretKey";
	private SecretKey secretKey = Keys.hmacShaKeyFor(key.getBytes(StandardCharsets.UTF_8));

	
	//토큰 생성시 다양한 데이터를 저장할 수 있음(dto or map)
	public String createToken(String name) {
		//유효기간 결정
		Date exp = new Date(System.currentTimeMillis()+1000*60*60); //유효기간 1시간
		return Jwts.builder().header().add("typ", "JWT").and()
				.claim("name", name).expiration(exp)
				.signWith(secretKey).compact();
				
	}
	
	//유효성 검증
	public Jws<Claims> validate(String token){
		return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token);
	}
	
	
}
