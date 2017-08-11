package jms;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import jms.AlertService;
import jms.config.RootConfig;
import jms.domain.User;

public class ReceiverTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RootConfig.class);
		AlertService alertService = context.getBean(AlertService.class);
		User userReceived = alertService.receiveUserAlert();
		System.out.println(userReceived);
	}
}
