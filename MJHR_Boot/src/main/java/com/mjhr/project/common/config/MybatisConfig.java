package com.mjhr.project.common.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@MapperScan(basePackages = {"com.mjhr.project.user.dao","com.mjhr.project.book.dao", "com.mjhr.project.review.dao"}) // 최상위 패키지 지정X, 직접 다 저장해야한다
@Configuration
public class MybatisConfig {

}
