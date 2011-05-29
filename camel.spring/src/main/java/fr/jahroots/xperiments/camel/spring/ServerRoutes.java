package fr.jahroots.xperiments.camel.spring;

import org.apache.camel.builder.RouteBuilder;

public class ServerRoutes extends RouteBuilder {

    @Override
    public void configure() throws Exception {
    	from("activemq:topic:CHAT.DEMO").to("jmsServiceListener");
    	
        // route from the numbers queue to our business that is a spring bean registered with the id=multiplier
        // Camel will introspect the multiplier bean and find the best candidate of the method to invoke.
        // You can add annotations etc to help Camel find the method to invoke.
        // As our multiplier bean only have one method its easy for Camel to find the method to use.
        //from("jms:queue:numbers").to("multiplier");

        // Camel has several ways to configure the same routing, we have defined some of them here below

        // as above but with the bean: prefix
        //from("jms:queue:numbers").to("bean:multiplier");

        // beanRef is using explicity bean bindings to lookup the multiplier bean and invoke the multiply method
        //from("jms:queue:numbers").beanRef("multiplier", "multiply");

        // the same as above but expressed as a URI configuration
        //from("activemq:queue:numbers").to("bean:multiplier?methodName=multiply");
    }


}
