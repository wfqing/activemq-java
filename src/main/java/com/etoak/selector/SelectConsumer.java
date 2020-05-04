package com.etoak.selector;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class SelectConsumer {

	public static void main(String[] args) throws JMSException {
		ConnectionFactory factory = new ActiveMQConnectionFactory(null, null, "tcp://localhost:61616");
		Connection connection = factory.createConnection();
		connection.start();
		
		Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
		Queue queue = session.createQueue("selector");
		
		//创建消费者（消费来源，条件选择）
		MessageConsumer consumer = session.createConsumer(queue, "name='etoak' and age=11");
		consumer.setMessageListener(msg -> {
			if(msg instanceof TextMessage) {
				TextMessage text = (TextMessage)msg;
				try {
					System.out.println(text.getText().toString());
					
					//签收消息,此时队列会删除这条消息
					text.acknowledge();
				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		
		
	}

}
