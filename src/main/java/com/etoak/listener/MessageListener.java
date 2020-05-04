package com.etoak.listener;

import javax.jms.Message;
import javax.jms.TextMessage;

public class MessageListener implements javax.jms.MessageListener {

	@Override
	public void onMessage(Message message) {
		//如果message属于TextMessage类型
		if(message instanceof TextMessage) {
			TextMessage text = (TextMessage)message;
			
			
			try {
				Thread.sleep(1000L);
				System.out.println(text.getText().toString());
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

	}

}
