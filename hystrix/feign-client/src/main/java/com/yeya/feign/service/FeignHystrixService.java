package com.yeya.feign.service;

import org.springframework.stereotype.Service;

@Service
public class FeignHystrixService implements FeignService{
    @Override
    public String helloCallBack() {
        return "service error!";
    }
}
