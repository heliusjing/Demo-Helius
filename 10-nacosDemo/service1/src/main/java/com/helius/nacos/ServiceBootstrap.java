package com.helius.nacos;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author jcf
 * @Create 2020-01-15-20:27
 */
@SpringBootApplication
@RestController
public class ServiceBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(ServiceBootstrap.class,args);
    }

    @Value("${common.name}")
    private String config1;

    @GetMapping(value = "/configs")
    public String getConfig1() {
        return config1;
    }
}
