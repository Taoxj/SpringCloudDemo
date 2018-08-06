package com.yeya.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "eureka-client",fallback = FeignHystrixService.class)
public interface FeignService {

    @GetMapping("/hello")
    String helloCallBack();
}
