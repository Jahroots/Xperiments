package fr.jahroots.xperiments.activemq.commun;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class AppConsumer {
	
	public static void main(String[] args) {
		new ClassPathXmlApplicationContext("classpath:consumer-context.xml");
	}
	
}
