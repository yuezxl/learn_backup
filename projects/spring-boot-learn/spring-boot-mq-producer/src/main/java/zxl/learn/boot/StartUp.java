package zxl.learn.boot;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource({ "classpath:boot-config.properties",  "classpath:mq.properties" })
@ImportResource({ "classpath:spring/spring-base.xml" })
public class StartUp {
	@Bean
	public Queue getQueue() {
		return new ActiveMQQueue("sample.queue");
	}
	
	public static void main(String[] args) {
		SpringApplication.run(StartUp.class, args);
	}
}
