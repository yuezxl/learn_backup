package zxl.learn.boot.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
	@JmsListener(destination = "sample.queue")
	public void reciveQueue(String text) {
		System.out.println("-->" + text);
	}
 }
