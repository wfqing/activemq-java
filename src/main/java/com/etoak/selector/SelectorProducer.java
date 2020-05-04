package com.etoak.selector;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;



public class SelectorProducer {
	public static void main(String[] args) throws JMSException {
		//创建ConnectionFactory
		ConnectionFactory factory = new ActiveMQConnectionFactory(null, null, "tcp://localhost:61616");
		//创建connection
		Connection connection = factory.createConnection();
		
		connection.start();
		//创建session
		Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);//手动签收
		//创建Destination-》queue
		Queue queue = session.createQueue("selector");
		//创建Message，并设置消息的持久化
		MessageProducer produce = session.createProducer(queue);
		produce.setDeliveryMode(DeliveryMode.PERSISTENT);//设置消息持久化
		//创建消息， 创建选择器
		TextMessage msg = session.createTextMessage("济南易途， 趵突泉北路6号");
		msg.setStringProperty("name", "etoak");
		msg.setIntProperty("age", 11);
		
		TextMessage msg2 = session.createTextMessage("山东易途， 山大路数码港大厦");
		msg2.setStringProperty("name", "etoak");
		msg2.setIntProperty("age", 2);
		//发送消息
		produce.send(msg);
		produce.send(msg2);
		//关闭资源
		produce.close();
		session.close();
		connection.close();
		
		
		
	}
}
