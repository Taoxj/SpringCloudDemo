package com.yeya.feign.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yeya.feign.service.FeignService;

@RestController
public class HelloController {

    //注入feignService接口
    @Autowired
    private FeignService feignService;

    @GetMapping(value = "/feignhello")
    public String Hello() {
        return feignService.helloCallBack();
    }
}
