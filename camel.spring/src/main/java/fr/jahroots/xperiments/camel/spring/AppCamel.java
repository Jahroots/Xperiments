package fr.jahroots.xperiments.camel.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppCamel {
	
	public static void main(String[] args) {
//		DefaultCamelContext camelContext = new DefaultCamelContext();
		new ClassPathXmlApplicationContext("classpath:META-INF/spring/camel-context.xml");
	}

}
