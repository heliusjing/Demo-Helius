package com.helius.nacos.controller;

import com.helius.nacos.client.ProviderClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author jcf
 * @Create 2020-01-15-22:25
 */

@RestController
public class ConsumerController {

    private static final Logger LOG = LoggerFactory.getLogger(ConsumerController.class);

    @Autowired
    private ProviderClient providerClient;

    @GetMapping("/service")
    public String service() {
        LOG.info("consumer invoke");
        String providerResult = providerClient.service();
        return "consumer invoke" + "|" + providerResult;
    }
}
