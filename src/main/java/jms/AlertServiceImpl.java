package jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsOperations;
import org.springframework.jms.support.JmsUtils;

import jms.domain.User;

public class AlertServiceImpl implements AlertService {
	@Autowired
	private JmsOperations jmsTemplate;

	@Override
	public void sendUserAlert(final User user) {
		jmsTemplate.convertAndSend(user);

		// use convertAndSend to skip MessageCreator and use MessageConverter
		// implementation behind the screen
		/*
		 * jmsOperations.send( //create message new MessageCreator() { public
		 * Message createMessage(Session session) throws JMSException { return
		 * session.createObjectMessage(user); } } );
		 */

		// the explicit destination specification can be skipped by configuring
		// it in jmsTemplate @Bean
		/*
		 * jmsOperations.send( //create message new MessageCreator() { public
		 * Message createMessage(Session session) throws JMSException { return
		 * session.createObjectMessage(user); } } );
		 */
	}

	@Override
	public User receiveUserAlert() {
		return (User) jmsTemplate.receiveAndConvert();
	}

}
