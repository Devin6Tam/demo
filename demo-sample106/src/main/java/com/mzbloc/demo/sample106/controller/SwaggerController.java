package com.mzbloc.demo.sample106.controller;

import com.mzbloc.demo.sample106.model.User;
import com.mzbloc.demo.sample106.service.IUserService;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zl on 2015/8/27.
 */
@RestController
@RequestMapping(value="/users")
public class SwaggerController {

    @Autowired
    private IUserService userService;

    /**
     *
     * @return
     */
    @ApiOperation(value="Get all users",notes="requires nothing")
    @RequestMapping(method= RequestMethod.GET)
    public List<User> getUsers(){
        List<User> list = userService.selectByList(new Example(User.class));
        return list;
    }

    @ApiOperation(value="Get user with name",notes="requires the name of user")
    @RequestMapping(value="/{name}",method= RequestMethod.GET)
    public User getUserById(@PathVariable String name){
        User user=new User();
        user.setName(name);
        return user;
    }
}
