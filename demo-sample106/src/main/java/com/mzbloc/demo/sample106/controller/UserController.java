package com.mzbloc.demo.sample106.controller;

import com.alibaba.fastjson.JSONObject;
import com.mzbloc.demo.sample106.model.User;
import com.mzbloc.demo.sample106.service.IUserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * Created by zl on 2015/8/27.
 */
@Controller
public class UserController {

    private Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private IUserService userService;

    @RequestMapping("/getUserInfo")
    @ResponseBody
    public User getUserInfo() {
        User user = userService.getUserInfo();
        if(user!=null){
            System.out.println("user.getName():"+user.getName());
            logger.info("user.getAge():"+user.getAge());
        }
        Example example = new Example(User.class);
        List<User> userList = userService.selectByList(example);

        logger.info("userList:"+ JSONObject.toJSONString(userList));
        return user;
    }
}
