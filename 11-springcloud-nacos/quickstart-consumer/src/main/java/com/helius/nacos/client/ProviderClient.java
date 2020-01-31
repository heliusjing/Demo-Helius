package com.helius.nacos.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author jcf
 * @Create 2020-01-15-22:37
 */
@FeignClient(value = "quickstart-provider")
public interface ProviderClient {
    @GetMapping("/service")
    public String service();
}
