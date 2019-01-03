package com.mzbloc.demo.sample103;

import com.mzbloc.rabbitmq.constant.RabbitMQQueueConstant;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by tanxw on 2018/12/29.
 */
@Configuration
public class RabbitMQClientConfiguraction {

    @Bean
    public Queue directQueue() {
        // 第一个参数是队列名字， 第二个参数是指是否持久化
        return new Queue(RabbitMQQueueConstant.QUEUE_TEST, true);
    }
}
