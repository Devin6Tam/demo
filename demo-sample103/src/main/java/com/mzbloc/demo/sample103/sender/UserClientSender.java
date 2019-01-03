package com.mzbloc.demo.sample103.sender;

import com.alibaba.fastjson.JSONObject;
import com.mzbloc.rabbitmq.constant.RabbitMQQueueConstant;
import com.mzbloc.rabbitmq.entity.UserEntity;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by tanxw on 2018/12/29.
 */
@Component
public class UserClientSender{

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendDirectQueue(UserEntity user){
        amqpTemplate.convertAndSend(RabbitMQQueueConstant.QUEUE_TEST,user);
        System.out.println("user:"+ JSONObject.toJSONString(user));
    }
}
