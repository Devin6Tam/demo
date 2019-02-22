package com.mzbloc.demo.sample106.controller;

import com.alibaba.fastjson.JSONObject;
import com.mzbloc.demo.sample106.model.User;
import com.mzbloc.demo.sample106.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by zl on 2015/8/27.
 */
@Controller
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService userService;

    @RequestMapping("/getUserInfo")
    @ResponseBody
    public List<User> getUserInfo() {
        List<User> userList = userService.getUserList();
        if(!CollectionUtils.isEmpty(userList)){
            String jsonStr = JSONObject.toJSONString(userList);
            System.out.println("userList:"+jsonStr);
            logger.info("userList:{}",jsonStr);
        }
        return userList;
    }
}
