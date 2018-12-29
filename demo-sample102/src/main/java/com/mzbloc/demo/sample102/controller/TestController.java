package com.mzbloc.demo.sample102.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.mzbloc.demo.sample102.common.response.ResponseResult;
import com.mzbloc.mongo.api.MgClienteService;
import com.mzbloc.mongo.entity.MgClientEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by tanxw on 2018/12/28.
 */
@RestController
public class TestController {

    private static Logger logger = LoggerFactory.getLogger(TestController.class);

    @Reference
    private MgClienteService mgClienteService;

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public ResponseResult test(String id)
    {
        logger.info("jpa search...");
        MgClientEntity clienteEntity = mgClienteService.findOne(id);
        return new ResponseResult(ResponseResult.SUCCESS,"查询成功！",clienteEntity);
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public Object add(@RequestBody MgClientEntity clienteEntity)
    {
        logger.info("jpa search...");
        mgClienteService.saveCliente(clienteEntity);
        return new ResponseResult(ResponseResult.SUCCESS,"保存成功！");
    }

    @RequestMapping(value = "findByFirstName", method = {RequestMethod.GET,RequestMethod.POST})
    public ResponseResult findByFirstName(String firstName){
        List<MgClientEntity> clienteList = mgClienteService.withQueryFindByFisrtName(firstName);
        return new ResponseResult(ResponseResult.SUCCESS,"查询成功！",clienteList);
    }
}
