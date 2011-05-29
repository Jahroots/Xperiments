package fr.jahroots.xperiments.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Producer {
	public static final int MAX_MSG = 1;
	private Logger logger = LoggerFactory.getLogger(Producer.class.getName());
	@SuppressWarnings("unused")
	private ConnectionFactory factory;
	private Connection connection;
	private Session session;
	private MessageProducer producer;
	
	public Producer(ConnectionFactory factory, String queueName)
			throws JMSException {
		this.factory = factory;
		connection = factory.createConnection();
		connection.start();
		session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination destination = session.createQueue(queueName);
		producer = session.createProducer(destination);
	}

	public void run() throws JMSException {
//		for (int i = 0; i < MAX_MSG; i++) {
			logger.info("Creating Message ");
			Message message = session.createTextMessage("Hello World!");
			producer.send(message);
//		}
	}

	public void close() throws JMSException {
		if (connection != null) {
			connection.close();
		}
	}

}
