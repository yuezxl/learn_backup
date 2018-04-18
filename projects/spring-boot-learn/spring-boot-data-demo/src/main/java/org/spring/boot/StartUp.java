package org.spring.boot;

import org.spring.boot.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
@PropertySource({"classpath:boot-config.properties", "classpath:important.properties"})
@ImportResource({"classpath:spring/spring-base.xml"})
@Import(value={MyConfig.class})
public class StartUp extends SpringBootServletInitializer{
	public static void main(String[] args) {
		new SpringApplication(StartUp.class).run(args);
	}
}
