package com.lyj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@MapperScan("com.lyj.dao")
//定时器启动
@EnableScheduling
@EnableAsync //开启异步任务
@ComponentScan(basePackages = {"com.lyj.repository"})
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class LyjApplication {

	public static void main(String[] args) {
		SpringApplication.run(LyjApplication.class, args);
	}
}
