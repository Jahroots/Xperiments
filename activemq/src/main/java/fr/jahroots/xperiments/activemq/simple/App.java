package fr.jahroots.xperiments.activemq.simple;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSubscriber;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTopic;

public class App {
	private static final String brokerURL = "tcp://localhost:61616";

	public static void main(String[] args) throws Exception {
//		producer();
//		consumer();
//		topic();
		new TopicSubscriberBean(brokerURL, "CHAT.DEMO");
	}
	
	public static void topic() throws Exception {
		TopicConnectionFactory topicCF = (TopicConnectionFactory) new ActiveMQConnectionFactory(brokerURL);
		Connection topicCon = topicCF.createConnection();
		topicCon.setClientID("jahrootsId");
		topicCon.start();
		Session topicSession = topicCon.createSession(false, Session.AUTO_ACKNOWLEDGE);
		ActiveMQTopic mqTopic = new ActiveMQTopic("CHAT.DEMO");
		
		TopicSubscriber topicSubscriber = topicSession.createDurableSubscriber(mqTopic, "jahrootsId");
		topicSubscriber.setMessageListener(new MessageListener() {
			
			@Override
			public void onMessage(Message message) {
				try {
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	public static void consumer(){
		Consumer app = new Consumer();
		app.run();
	}
	
	public static void producer() throws Exception{
		ConnectionFactory factory = new ActiveMQConnectionFactory(brokerURL);
		 
        Producer producer = new Producer(factory, "test");
        producer.run();
        producer.close();
	}
}
