package com.ssafit.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@MapperScan("com.ssafit.model.dao")
@Configuration
public class MybatisConfig {

}
