package com.spring;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableAsync;


@SpringBootApplication
@EnableAutoConfiguration
@ImportResource({ "classpath:spring/spring-boot.xml" })
@PropertySource({"classpath:spring-boot.properties", "classpath:log4j.properties", "classpath:version.properties"})
@Import(Configure.class)
@ComponentScan({"com"})
@MapperScan(basePackages = { "com.zxl.dao"})
@EnableAsync
public class StartUp extends SpringBootServletInitializer{
	@Override
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder application) {
		return application.sources(StartUp.class);
	}
	
	public static void main(String[] args) {
        SpringApplication.run(StartUp.class, args);
    }
}
