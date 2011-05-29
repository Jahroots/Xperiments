package fr.jahroots.xperiments.camel.spring;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.apache.activemq.command.ActiveMQTextMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("jmsServiceListener")
public class JmsServiceListener implements MessageListener {
	private static final Logger LOGGER = LoggerFactory.getLogger(JmsServiceListener.class);
	
	@Override
	public void onMessage(Message message) {
		try {
			ActiveMQTextMessage msg = (ActiveMQTextMessage) message;
			LOGGER.info(msg.getText());
		} catch (JMSException e) {
			LOGGER.error("Error onMessage: ", e);
		}
	}
	
}
