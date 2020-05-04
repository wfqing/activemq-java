package com.etoak.hello;

import java.awt.font.TextMeasurer;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;

import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.etoak.listener.MessageListener;

public class HelloConsumer {
///////////////////////////////////////
	//////////////////
	//iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii
	//et用户修改
    ////
//测试git	
	public static void main(String[] args) throws JMSException {
		//创建ConnectionFactory
		ConnectionFactory factory = new ActiveMQConnectionFactory(null, null, "tcp://localhost:61616");
		//创建Connection 并调用start（）
		Connection conncetion = factory.createConnection();
		conncetion.start();
		//创建session
		Session session = conncetion.createSession(false, Session.AUTO_ACKNOWLEDGE);
		//创建Destination 消费者消息的来源
		Queue queue = session.createQueue("hello");
		//创建MessageConsumer
		MessageConsumer consumer = session.createConsumer(queue);
		
		
		//consumer.setMessageListener(new MessageListener());
		
		//使用消费者消费消息
		  //TextMessage message = (TextMessage)consumer.receive();
		  //System.out.println(message.getText().toString());
		
		  
		
		  consumer.setMessageListener(x -> { //如果message属于TextMessage类型 
			  if(x instanceof TextMessage) { 
				  TextMessage text = (TextMessage)x; 
				  try { Thread.sleep(1000L);
		  System.out.println(text.getText().toString()); }catch(Exception e) {
		  e.printStackTrace(); } } });
		
		//关闭资源
		//session.close();
		//conncetion.close();
		//consumer.close();
		

	}

}
