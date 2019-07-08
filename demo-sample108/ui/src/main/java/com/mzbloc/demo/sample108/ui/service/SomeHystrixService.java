package com.mzbloc.demo.sample108.ui.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author tanxw
 * @date 2019/6/28
 */
@Service
public class SomeHystrixService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallbackSome")
    public String getSome() {
        return restTemplate.getForObject("http://some/getsome",String.class);
    }

    public String fallbackSome(){
        return "some service模块故障";
    }
}
