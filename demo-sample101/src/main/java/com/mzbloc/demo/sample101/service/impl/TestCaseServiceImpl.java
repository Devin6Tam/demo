package com.mzbloc.demo.sample101.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.mzbloc.demo.sample101.service.TestCaseService;
import com.mzbloc.elasticsearch.entity.ClienteEntity;
import com.mzbloc.elasticsearch.service.ClienteService;
import com.mzbloc.elasticsearch.service.TestService;
import org.springframework.stereotype.Service;

/**
 * Created by tanxw on 2018/12/26.
 */
@Service
public class TestCaseServiceImpl implements TestCaseService{

    @Reference
    private TestService testService;

    @Reference
    private ClienteService clienteService;

    @Override
    public String say(){
        return testService.say();
    }
    @Override
    public ClienteEntity findCliente(String id){
        return clienteService.findCliente(id);
    }
}
