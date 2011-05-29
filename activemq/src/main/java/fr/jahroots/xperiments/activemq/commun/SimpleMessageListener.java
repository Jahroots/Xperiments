package fr.jahroots.xperiments.activemq.commun;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleMessageListener implements MessageListener{
	private static final Logger logger = LoggerFactory.getLogger(SimpleMessageListener.class);
	
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
			logger.error("Error onMessage: "+ e);
		}
	}

}
