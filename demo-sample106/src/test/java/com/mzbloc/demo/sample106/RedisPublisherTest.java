package com.mzbloc.demo.sample106;


import com.mzbloc.springboot.redis.service.IRedisService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * Created by tanxw on 2019/2/22.
 */
public class RedisPublisherTest extends DemoSample106ApplicationTests{

    private static Logger logger= LoggerFactory.getLogger(RedisPublisherTest.class);

    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    IRedisService redisService;


    @Test
    public void testRedis(){
        redisService.setValue("name","forezp");
        redisService.setValue("age","11");
        logger.info(redisService.getValue("name"));
        logger.info(redisService.getValue("age"));

        System.out.println("name:"+redisService.getValue("name"));
    }

    @Test
    public void testPublish(){
        redisService.publish("phone","11");
        redisService.leftPush("phone","111");
        String message = redisService.rightPop("phone");
        System.out.println("message:"+message);
    }

    @Test
    public void testPublish2(){
        redisService.publish("phone","11");
        redisService.publish("userData","22");
        redisService.publish("areaData","33");
    }
}
