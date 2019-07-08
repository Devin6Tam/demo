package com.mzbloc.demo.sample108.some.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * some 控制器
 *
 * @author tanxw
 * @date 2019/6/27
 */
@RestController
public class SomeController {

    @Value("${my.message}") //1
    private String message;

    @RequestMapping(value = "/getsome")
    public String getsome(){
        return message;
    }
}
