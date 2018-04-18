package lesson2;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class QueueConsumer {
	
	private static String user = ActiveMQConnection.DEFAULT_USER;
	private static String password = ActiveMQConnection.DEFAULT_PASSWORD;
	private static String url = "tcp://localhost:61616";
	
	public static void main(String[] args) throws JMSException {
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(user, password, url);
		Connection connection = connectionFactory.createConnection();
		connection.start();
		final Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
		
		Queue destination = session.createQueue("example.A");
		MessageConsumer consumer = session.createConsumer(destination);
		
		consumer.setMessageListener(new MessageListener() {
			public void onMessage(Message message) {
				try {
					TextMessage textMessage = (TextMessage)message;
					System.out.println("textMessage:" + textMessage);
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					session.commit();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}
}
