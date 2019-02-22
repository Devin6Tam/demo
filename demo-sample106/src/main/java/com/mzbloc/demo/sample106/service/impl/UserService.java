package com.mzbloc.demo.sample106.service.impl;

import com.fasterxml.jackson.databind.deser.Deserializers;
import com.mzbloc.demo.sample106.dao.UserMapper;
import com.mzbloc.demo.sample106.model.User;
import com.mzbloc.demo.sample106.service.IUserService;
import com.mzbloc.springboot.mybatis.common.service.impl.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Created by tanxw on 2017/3/30.
 */
@Service
public class UserService extends BaseService<User> implements IUserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public Mapper<User> getMapper() {
        return super.getMapper();
    }

    @Override
    @Cacheable(value = "userData",unless = "#result == null")
    public List<User> getUserList(){
        return userMapper.queryUser();
    }
}
