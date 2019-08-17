package com.example.layuidemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan(basePackages = {"com.example.layuidemo.dao"})
public class LayuidemoApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(LayuidemoApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO 打包准备
		return builder.sources(this.getClass());
	}

	
}
