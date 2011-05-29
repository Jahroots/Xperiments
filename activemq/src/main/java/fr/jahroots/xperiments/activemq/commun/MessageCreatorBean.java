package fr.jahroots.xperiments.activemq.commun;


import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.MessageCreator;

public class MessageCreatorBean implements MessageCreator {

	private static final String DEFAULT_TEXT_MESSAGE = "Default Message";
	private String text;
	
	public MessageCreatorBean() {
		this.text = DEFAULT_TEXT_MESSAGE;
	}
	public MessageCreatorBean(String textMessage) {
		this.text = textMessage;
	}

	@Override
	public Message createMessage(Session session) throws JMSException {
		return session.createTextMessage(text);
	}

}
