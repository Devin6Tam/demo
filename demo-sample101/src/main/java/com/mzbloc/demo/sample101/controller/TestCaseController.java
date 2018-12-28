package com.mzbloc.demo.sample101.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.mzbloc.elasticsearch.entity.ClienteEntity;
import com.mzbloc.elasticsearch.service.ClienteService;
import com.mzbloc.elasticsearch.service.TestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tanxw on 2018/12/26.
 */
@RestController
public class TestCaseController {

    @Reference
    private TestService testService;

    @Reference
    private ClienteService clienteService;


    @RequestMapping("say")
    public String say(){
        return testService.say();
    }

    @RequestMapping("findCliente")
    public ClienteEntity findCliente(String id){
        return clienteService.findCliente(id);
    }
}
