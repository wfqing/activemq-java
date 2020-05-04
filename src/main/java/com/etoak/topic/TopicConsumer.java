package com.etoak.topic;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;

public class TopicConsumer {
	public static void main(String[] args) throws JMSException {
		ConnectionFactory factory = new ActiveMQConnectionFactory(null, null, "tcp://localhost:61616");
		Connection connection = factory.createConnection();
		connection.start();
		
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Topic topic = session.createTopic("topic");
		MessageConsumer consumer = session.createConsumer(topic);
		consumer.setMessageListener(msg->{
			if(msg instanceof MapMessage) {
				MapMessage mapMsg = (MapMessage)msg;
				try {
					System.out.println(mapMsg.getString("name")+ ":" + mapMsg.getInt("age"));
				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		
		
	}
}
