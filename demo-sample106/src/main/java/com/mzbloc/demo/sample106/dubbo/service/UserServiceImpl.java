package com.mzbloc.demo.sample106.dubbo.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.mzbloc.demo.sample106.dubbo.api.UserService;
import com.mzbloc.demo.sample106.model.User;
import com.mzbloc.demo.sample106.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by tanxw on 2019/5/21.
 */
@Service(interfaceClass = UserService.class)
public class UserServiceImpl implements UserService{

    @Autowired
    IUserService userService;


    @Override
    public List<User> getUserList() {
        return userService.getUserList();
    }
}
