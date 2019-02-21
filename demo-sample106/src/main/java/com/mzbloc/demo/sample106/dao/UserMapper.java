package com.mzbloc.demo.sample106.dao;

import com.mzbloc.demo.sample106.model.User;
import com.mzbloc.springboot.mybatis.common.mapper.BaseMapper;

/**
 * Created by zl on 2015/8/27.
 */
public interface UserMapper extends BaseMapper<User>{

    User findUserInfo();
}
