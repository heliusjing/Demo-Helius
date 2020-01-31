package com.helius;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @Author jcf
 * @Create 2020-01-30-19:00
 */
public class SpringConsumer {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext-consumer.xml");
        applicationContext.start();
        //使程序处于阻塞状态
        System.in.read();

    }
}
