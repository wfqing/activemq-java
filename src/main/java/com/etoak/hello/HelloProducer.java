package com.etoak.hello;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class HelloProducer {
	public static void main(String[] args) throws JMSException {
		//创建工厂
		ConnectionFactory factory = new ActiveMQConnectionFactory(null, null, "tcp://localhost:61616");
		//创建Connection,并且调用start方法
		Connection connection = factory.createConnection();
		connection.start();
		//创建session,  第一个参数启用事务， 第二个参数客户端签收消息的方式
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);//手动签收
		//创建队列
		Queue queue = session.createQueue("hello");//队列名
		//创建生产者
		MessageProducer produce = session.createProducer(queue);
		//创建消息
		for(int i = 0; i < 10; i++) {
			TextMessage msg = session.createTextMessage("HEllo activemq" + i);
			//发送消息
			produce.send(msg);
		}

		
		//关闭资源
		produce.close();
		session.close();
		connection.close();
		
		
		
	}
	
}
