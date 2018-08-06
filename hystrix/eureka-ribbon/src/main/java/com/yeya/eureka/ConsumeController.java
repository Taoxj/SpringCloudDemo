package com.yeya.eureka;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumeController {

    @Autowired
    private LoadBalancerClient client;

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "consumerError")
    @GetMapping("/consumer")
    public String consumer() {
        String dc = restTemplate.getForObject("http://eureka-client/hello",String.class);
        return dc;
    }

    public String consumerError(){
        return "consumer error!";
    }
}
