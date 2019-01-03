package com.mzbloc.demo.sample103.controller;

import com.alibaba.fastjson.JSONObject;
import com.mzbloc.demo.sample103.common.ResponseResult;
import com.mzbloc.demo.sample103.sender.UserClientSender;
import com.mzbloc.rabbitmq.entity.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tanxw on 2018/12/29.
 */
@RestController
public class TestController {

    private static Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    UserClientSender userClientSender;

    @RequestMapping(value = "sendDirectQueue",method = RequestMethod.POST)
    public Object sendDirectQueue(@RequestBody UserEntity user){
        userClientSender.sendDirectQueue(user);
        logger.info("send user:{}", JSONObject.toJSONString(user));
        return new ResponseResult(ResponseResult.SUCCESS,"成功！");
    }
}
