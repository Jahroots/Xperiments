package fr.jahroots.xperiments.activemq.simple;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSubscriber;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.apache.activemq.command.ActiveMQTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TopicSubscriberBean implements MessageListener{
	private static final Logger LOGGER = LoggerFactory.getLogger(TopicSubscriberBean.class);
	private static final String CLIENT_ID = TopicSubscriberBean.class.getSimpleName();
	protected TopicConnectionFactory topicCF;
	protected Connection topicCon;
	private String brokerURL;
	private Session topicSession;
	private ActiveMQTopic mqTopic;
	private TopicSubscriber topicSubscriber;
	
	public TopicSubscriberBean(String brokerURL, String topicName) {
		this.brokerURL = brokerURL;
		mqTopic = new ActiveMQTopic(topicName);
		initialization();
	}
	
	private void initialization() {
		this.topicCF = new ActiveMQConnectionFactory(brokerURL);
		
		try {
			topicCon = topicCF.createConnection();
			topicCon.setClientID(CLIENT_ID);
			topicCon.start();
			
			topicSession = topicCon.createSession(false, Session.AUTO_ACKNOWLEDGE);
			
			topicSubscriber = topicSession.createDurableSubscriber(mqTopic, CLIENT_ID);
			topicSubscriber.setMessageListener(this);
		} catch (JMSException e) {
			LOGGER.error("Error when creating connection:" , e);
		}
		
	}

	@Override
	public void onMessage(Message message) {
		try {
			LOGGER.info("New message on " + mqTopic.getTopicName());
			ActiveMQTextMessage msg = (ActiveMQTextMessage) message;
			LOGGER.info(msg.getText());
		} catch (JMSException e) {
			LOGGER.error("Error onMessage: ", e);
		}
	}
	
	public void stop(){
		try {
			topicCon.stop();
		} catch (JMSException e) {
			LOGGER.error("Error on closing connection: ", e);
		}
	}

}
