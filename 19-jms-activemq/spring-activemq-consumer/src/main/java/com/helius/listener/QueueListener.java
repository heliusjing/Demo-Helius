package com.helius.listener;

import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @Author jcf
 * @Create 2020-01-30-18:55
 */
@Component
public class QueueListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) message;
            try {
                String jmsCorrelationID = textMessage.getJMSCorrelationID();
                System.out.println("jmsCorrelationID = " + jmsCorrelationID);
                String jmsMessageID = textMessage.getJMSMessageID();
                System.out.println("jmsMessageID = " + jmsMessageID);
                System.out.println("queue接口消息" + textMessage.getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
