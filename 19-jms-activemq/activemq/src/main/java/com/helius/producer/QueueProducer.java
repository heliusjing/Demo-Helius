package com.helius.producer;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @Author jcf
 * @Create 2020-01-30-12:22
 */
public class QueueProducer {
    public static void main(String[] args) throws JMSException {
        ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://47.100.246.223:61616");
        Connection connection = factory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue("queue01");
        MessageProducer producer = session.createProducer(queue);
        TextMessage textMessage = session.createTextMessage("test message3");
        //消息持久化
//        producer.setDeliveryMode(DeliveryMode.PERSISTENT);
//        过期时间
//        textMessage.setJMSExpiration(1000);
        // 目的地，一般不这么写
//        textMessage.setJMSDestination(new ActiveMQQueue("queue01"));
        //消息持久化
//        textMessage.setJMSDeliveryMode(DeliveryMode.NON_PERSISTENT);
        // 消息优先级，默认4,5-9加急消息，0-4普通消息，只保证加急消息优先于普通消息发送
//        textMessage.setJMSPriority(5);
        //消息ID，唯一标志，可用来保证幂等性
//        textMessage.setJMSMessageID("cc123456");

        /**
         * 消息体：5种消息格式
         * 消息属性：自定义消息属性
         */
//        textMessage.setStringProperty("cc","vip");
        producer.send(textMessage);
        System.out.println("消息发送完成");
        //关闭资源
        producer.close();
        session.close();
        connection.close();
    }
}
