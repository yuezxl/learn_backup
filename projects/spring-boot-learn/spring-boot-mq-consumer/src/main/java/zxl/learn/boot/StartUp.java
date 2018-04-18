package zxl.learn.boot;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import zxl.learn.boot.config.WebConfig;
import zxl.learn.boot.mysocket.CounterHandler;

@SpringBootApplication
@Import({ WebConfig.class})
@PropertySource({ "classpath:boot-config.properties",  "classpath:mq.properties" })
@ImportResource({ "classpath:spring/spring-base.xml" })
@EnableWebSocket
public class StartUp implements WebSocketConfigurer{
	@Bean
	public Queue getQueue() {
		return new ActiveMQQueue("sample.queue");
	}
	
	public static void main(String[] args) {
		SpringApplication.run(StartUp.class, args);
	}
	
    /**
     * 注册WebSocket处理类
     *
     * @param webSocketHandlerRegistry
     */
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        //支持websocket 的 connection，指定counterHandler处理路径为/counter 的长连接请求
        webSocketHandlerRegistry.addHandler(counterHandler(), "/counter")
                //添加WebSocket握手请求的拦截器.
                .addInterceptors(new CounterHandler.CountHandshakeInterceptor()).setAllowedOrigins("*");
        
        //不支持websocket的connenction,采用sockjs
        webSocketHandlerRegistry.addHandler(counterHandler(), "/sockjs/counter")
                //添加WebSocket握手请求的拦截器.
                .addInterceptors(new CounterHandler.CountHandshakeInterceptor()).withSockJS();
    }

    @Bean
    public CounterHandler counterHandler() {
        return new CounterHandler();
    }

}
