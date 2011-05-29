package fr.jahroots.xperiments.activemq.commun;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

public class AppProducer {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:producer-context.xml");
		JmsTemplate producer = (JmsTemplate) applicationContext.getBean("producerTemplate");
		producer.send(new MessageCreatorBean());
	}
}
