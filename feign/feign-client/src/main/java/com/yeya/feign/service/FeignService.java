package com.yeya.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("eureka-client")
public interface FeignService {

    @GetMapping("/hello")
    String helloCallBack();
}
