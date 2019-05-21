package com.mzbloc.demo.sample106.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

/**
 * Created by tanxw on 2019/2/22.
 */
@Component
public class UserMessageListener {

    private static final Logger logger = LoggerFactory.getLogger(UserMessageListener.class);

    public void receiveMessage(String message) {
        logger.info("Received <{}>",message);
    }
}
