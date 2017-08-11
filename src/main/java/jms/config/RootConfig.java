package jms.config;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
//there is a "spring" inside
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import jms.AlertService;
import jms.AlertServiceImpl;
import jms.domain.User;

@Configuration
public class RootConfig {
	private final String DESTINATIONAL_NAME_QUEUE = "user.alert.queue"; 
	private final String DESTINATIONAL_NAME_TOPIC = "user.alert.topic"; 
	//this is the default brokerURL, and it can be omitted
	private final String BROKER_URL= "tcp://localhost:61616";
	
	@Bean
	public ConnectionFactory connectionFactory(){
		
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
		factory.setBrokerURL(BROKER_URL);
		return factory;
	}
	
	@Bean
	public Queue queue(){
		return new ActiveMQQueue(DESTINATIONAL_NAME_QUEUE);
	}
	
	@Bean
	public Topic topic(){
		return new ActiveMQTopic(DESTINATIONAL_NAME_TOPIC);
	}
	
	@Bean
	public MessageConverter messageConverter(){
		//return new MappingJackson2MessageConverter();
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		//This cannot be skipped
		converter.setTypeIdPropertyName("User");
        return converter;
	}
	
	@Bean
	public JmsTemplate jmsTemplate(ConnectionFactory connectionFactory, MessageConverter messageConverter){
		JmsTemplate template = new JmsTemplate(connectionFactory);
		template.setDefaultDestination(queue());
		template.setMessageConverter(messageConverter);
		return template;
	}
	
	@Bean
	public AlertService alertService(){
		return new AlertServiceImpl();
	}
}
