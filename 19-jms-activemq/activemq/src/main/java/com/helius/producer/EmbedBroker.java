package com.helius.producer;

import org.apache.activemq.broker.BrokerService;

/**
 * 内嵌activemq
 * @Author jcf
 * @Create 2020-01-31-12:41
 */
public class EmbedBroker {
    public static void main(String[] args) throws Exception {
        BrokerService brokerService = new BrokerService();
        brokerService.setUseJmx(true);
        brokerService.addConnector("tcp://localhost:61616");
        brokerService.start();
    }
}
