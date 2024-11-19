package com.mjhr.project.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.mjhr.project.user.interceptor.JwtInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private JwtInterceptor jwtInterceptor;

    @Autowired
    private Environment environment;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String activeProfile = environment.getProperty("spring.profiles.active", "default");
        boolean isDevelopment = "dev".equals(activeProfile);

        if (isDevelopment) {
            registry.addInterceptor(jwtInterceptor)
                .addPathPatterns("/**") // 모든 경로
                .excludePathPatterns("/**"); // 개발 환경에서는 모든 경로 제외
            System.out.println("JWT Interceptor: Development mode, JWT 검증 제외됨.");
        } else {
            registry.addInterceptor(jwtInterceptor)
                .addPathPatterns("/**") // 모든 요청에 대해 인터셉터 적용
                .excludePathPatterns(
                    "/user/**", // 사용자 관련 요청 제외
                    "/swagger-ui/**", // Swagger 관련 요청 제외
                    "/v3/api-docs/**" // OpenAPI 문서 관련 요청 제외
                );
            System.out.println("JWT Interceptor: Production mode, 일부 경로에서 JWT 검증 제외됨.");
        }

        // 현재 설정 상태를 로그로 확인
        System.out.println("현재 활성화된 프로필: " + activeProfile);
    }
}
