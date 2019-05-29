package com.mzbloc.demo.sample106.consumer;


import com.mzbloc.springboot.redis.annotation.RedisMessageListener;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

/**
 * Created by tanxw on 2019/2/22.
 */
@RedisMessageListener(topics = {"userData"})
public class UserMessageListener2 implements MessageListener {

    /**
     * 订阅接收发布者的消息
     */
    @Override
    public void onMessage(Message message, byte[] pattern) {
        if("userData".equals(new String(message.getChannel()))) {
            // 缓存消息是序列化的，需要反序列化。然而new String()可以反序列化，但静态方法valueOf()不可以
            System.out.println(new String(pattern) + "主题发布：" + new String(message.getBody()));
        }
    }
}
