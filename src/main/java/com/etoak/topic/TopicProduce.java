package com.etoak.topic;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;

public class TopicProduce {

	public static void main(String[] args) throws JMSException {
		//创建ConnectionFactory
				ConnectionFactory factory = new ActiveMQConnectionFactory(null, null, "tcp://localhost:61616");
				//创建Connection 并调用start（）
				Connection conncetion = factory.createConnection();
				conncetion.start();
				//创建session
				Session session = conncetion.createSession(false, Session.AUTO_ACKNOWLEDGE);
				Topic topic = session.createTopic("topic");
				MessageProducer producer = session.createProducer(topic);
				//创建消息
				MapMessage msg = session.createMapMessage();
				msg.setString("name", "张三");
				msg.setInt("age", 20);
				//发送消息
				producer.send(msg);
				//关闭
				producer.close();
				session.close();
				conncetion.close();
				
				

	}

}
