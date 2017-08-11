package jms;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import jms.AlertService;
import jms.config.RootConfig;
import jms.domain.User;

public class SenderTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RootConfig.class);
		AlertService alertService = context.getBean(AlertService.class);
		User userToSend = new User(1L, "riyl", 21);
		for(int i=0;i<10000;i++){
			
		}
		alertService.sendUserAlert(userToSend);
		
		context.close();
	}
}
