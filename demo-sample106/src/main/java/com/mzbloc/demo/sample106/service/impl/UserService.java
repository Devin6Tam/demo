package com.mzbloc.demo.sample106.service.impl;

import com.fasterxml.jackson.databind.deser.Deserializers;
import com.mzbloc.demo.sample106.dao.UserMapper;
import com.mzbloc.demo.sample106.model.User;
import com.mzbloc.demo.sample106.service.IUserService;
import com.mzbloc.springboot.mybatis.common.service.impl.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by tanxw on 2017/3/30.
 */
@Service
public class UserService extends BaseService<User> implements IUserService{

    @Autowired
    private UserMapper userMapper;

    @Override
//    @Cacheable(value = "common",unless = "#result == null")
    public User getUserInfo(){
        User user = userMapper.findUserInfo();
        //User user=null;
        return user;
    }
}
