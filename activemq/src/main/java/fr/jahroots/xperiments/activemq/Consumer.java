package fr.jahroots.xperiments.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Consumer implements MessageListener {
	public static String brokerURL = "tcp://localhost:61616";
	private Logger logger = LoggerFactory.getLogger(Consumer.class.getName());
	
//	private ConnectionFactory factory;
	private Connection connection;
	private Session session;
	private MessageConsumer consumer;

	public static void main(String[] args) {
		
	}

	public void run() {
		try {
			final ConnectionFactory factory = new ActiveMQConnectionFactory(brokerURL);
			connection = factory.createConnection();
			connection.start();
			
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Destination destination = session.createQueue("test");
			
			consumer = session.createConsumer(destination);
			consumer.setMessageListener(this);
		} catch (Exception e) {
			logger.error("Error: ", e);
		}
	}

	@Override
	public void onMessage(Message message) {
		try {
			if (message instanceof TextMessage) {
				TextMessage txtMessage = (TextMessage) message;
				logger.info("Message received: " + txtMessage.getText());
			} else {
				logger.info("Invalid message received.");
			}
		} catch (JMSException e) {
			logger.error("Error onMessage: ", e);
		}
	}

}
