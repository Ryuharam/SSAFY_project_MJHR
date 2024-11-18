package com.mjhr.project.common.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@MapperScan(basePackages = "com.mjhr.project") // 최상위 패키지 지정
@Configuration
public class MybatisConfig {
	
	
}
