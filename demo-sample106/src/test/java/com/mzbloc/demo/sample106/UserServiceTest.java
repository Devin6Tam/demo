package com.mzbloc.demo.sample106;

import com.alibaba.fastjson.JSONObject;
import com.mzbloc.demo.sample106.model.User;
import com.mzbloc.demo.sample106.service.IUserService;
import com.mzbloc.springboot.redis.util.ThreadPoolUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by tanxw on 2019/5/16.
 */
public class UserServiceTest extends DemoSample106ApplicationTests{

    @Autowired
    private IUserService userService;

    @Test
    public void getUserList(){
        /**
         * 此测试用例，证明单线程锁
         */
        for(int $j = 0; $j < 5;$j++){
            ThreadPoolUtil.getScheduleLoanPool().submit(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 1000; i ++){
                        List<User> userList = userService.getUserList();
                        System.out.println(Thread.currentThread().getName()+"::"+ JSONObject.toJSONString(userList));
                    }
                }
            });
        }

        while (true){}

    }
}
