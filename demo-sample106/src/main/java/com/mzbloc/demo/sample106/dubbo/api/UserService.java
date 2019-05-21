package com.mzbloc.demo.sample106.dubbo.api;

import com.mzbloc.demo.sample106.model.User;

import java.util.List;

/**
 * Created by tanxw on 2019/5/21.
 */
public interface UserService {
    List<User> getUserList();
}
