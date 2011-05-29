package fr.jahroots.xperiments.activemq.simple;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;

public class App {
	private static final String brokerURL = "tcp://localhost:61616";

	public static void main(String[] args) throws Exception {
		producer();
//		consumer();
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
