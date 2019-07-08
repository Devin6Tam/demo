package com.mzbloc.demo.sample107.controller;

import com.mzbloc.demo.sample107.vo.ResponseResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tanxw
 * @date 2019/6/25
 */
@RestController
public class IndexController {

    @RequestMapping({"","/","/index","/index/"})
    public ResponseResult<Object> index(){
        return new ResponseResult<>(ResponseResult.ResultCode.SUCCESS);
    }
}
