package com.mzbloc.demo.sample101.controller;

import com.mzbloc.demo.sample101.service.TestCaseService;
import com.mzbloc.elasticsearch.entity.ClienteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tanxw on 2018/12/26.
 */
@RestController
public class TestCaseController {

    @Autowired
    private TestCaseService testCaseService;


    @RequestMapping("say")
    public String say(){
        return testCaseService.say();
    }

    @RequestMapping("findCliente")
    public ClienteEntity findCliente(String id){
        return testCaseService.findCliente(id);
    }
}
