package jms;

import jms.domain.User;

public interface  AlertService {
	void sendUserAlert(User user);
	
	User receiveUserAlert();
}
