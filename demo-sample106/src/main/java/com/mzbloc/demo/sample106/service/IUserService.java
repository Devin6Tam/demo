package com.mzbloc.demo.sample106.service;


import com.mzbloc.demo.sample106.model.User;
import com.mzbloc.springboot.mybatis.common.service.IBaseService;

import java.util.List;

/**
 * Created by tanxw on 2019/2/20.
 */
public interface IUserService extends IBaseService<User>{

    List<User> getUserList();
}
