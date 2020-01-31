package com.helius;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.*;

/**
 * @Author jcf
 * @Create 2020-01-30-18:14
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-producer.xml")
public class TestProducer {
    //点对点
    @Autowired
    @Qualifier("jmsQueueTemplate")
    private JmsTemplate jmsQueueTemplate;
    //发布订阅模式
    @Autowired
    @Qualifier("jmsTopicTemplate")
    private JmsTemplate jmsTopicTemplate;

    /**
     * 发送TextMessage
     */
    @Test
    public void ptpSender() {
        jmsQueueTemplate.send("spring_queue", new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                //创建文本消息
                TextMessage textMessage = session.createTextMessage("spring test message");
                return textMessage;
            }
        });
        System.out.println("消息发送已完成");
    }

    @Test
    public void psSender() {
        jmsTopicTemplate.send("spring_topic", new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                //创建文本消息
                TextMessage textMessage = session.createTextMessage("spring test message_topic");
                return textMessage;
            }
        });
        System.out.println("消息发送已完成");
    }

    @Test
    public void p2pSender() {
        //获取连接工厂
        ConnectionFactory connectionFactory = jmsQueueTemplate.getConnectionFactory();
        Session session = null;
        try {
            Connection connection = connectionFactory.createConnection();
            // 参数一：是否开启消息事务
            session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);

            MessageProducer producer = session.createProducer(session.createQueue("test.trsaction"));
            //发送10条消息，开启事务后，要么一起成功，要么一起失败
            for (int i = 0; i < 10; i++) {
                if (i == 4) {
                    //出现异常
                    throw new RuntimeException("i cannot equals 4");
                }
                TextMessage textMessage = session.createTextMessage("消息-----" + i);
                producer.send(textMessage);
            }
            //开启事务后，需要手动提交
            session.commit();
        } catch (JMSException e) {
            e.printStackTrace();
            //消息事务回滚
            try {
                session.rollback();
            } catch (JMSException ex) {
                ex.printStackTrace();
            }
        }
    }
}
