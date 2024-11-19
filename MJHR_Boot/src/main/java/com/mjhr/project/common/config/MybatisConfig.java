package com.mjhr.project.common.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@MapperScan(basePackages = { "com.mjhr.project.user.dao", "com.mjhr.project.book.dao", "com.mjhr.project.review.dao" })
																																																												
@Configuration
public class MybatisConfig {

}
