package com.helius.nacos;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;

import java.util.Properties;

/**
 * @Author jcf
 * @Create 2020-01-15-0:15
 */
public class SimpleMain {
    public static void main(String[] args) throws NacosException {
        String dataId = "test.yaml";
        String serverAddr = "127.0.0.1:8848";
        String group = "DEFAULT_GROUP";

        Properties properties = new Properties();
        properties.setProperty("serverAddr", serverAddr);
        ConfigService configService = NacosFactory.createConfigService(properties);
        String config = configService.getConfig(dataId, group, 5000);
        System.out.println("config = " + config);


    }


}
