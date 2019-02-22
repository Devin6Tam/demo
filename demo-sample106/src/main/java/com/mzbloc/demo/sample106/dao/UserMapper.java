package com.mzbloc.demo.sample106.dao;

import com.mzbloc.demo.sample106.model.User;
import com.mzbloc.springboot.mybatis.common.mapper.BaseMapper;

import java.util.List;

/**
 * Created by zl on 2015/8/27.
 */
public interface UserMapper extends BaseMapper<User>{

    List<User> queryUser();
}
