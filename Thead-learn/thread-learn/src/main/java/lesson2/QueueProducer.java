package lesson2;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//Queue（点对点）方式  生产者Produce
public class QueueProducer {
	private static Logger logger = LoggerFactory.getLogger(QueueProducer.class);
	public static String user = ActiveMQConnection.DEFAULT_USER;
	public static String pwd = ActiveMQConnection.DEFAULT_PASSWORD;
	public static String url = "tcp://localhost:61616";
	
	public static void main(String[] args) throws JMSException {
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(user, pwd, url);
		
		Connection connect = connectionFactory.createConnection();
		
		connect.start();
		
		logger.info("Connection is starting...");
		
		Session session = connect.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
		Queue destination = session.createQueue("example.A");
		MessageProducer producer = session.createProducer(destination);
		sendMessage(session, producer);
		session.commit(); 
		connect.close();  
	    System.out.println("send text ok.");  
	}
	
	public static void sendMessage(Session session, MessageProducer producer) throws JMSException {
		for(int i = 1; i < 106; i++) {
			TextMessage message = session.createTextMessage("ActiveMQ 生产消息" + i);
			System.out.println("发送消息：ActiveMQ 生产消息" + i);
			producer.send(message);
		}
		
	}
}
