package com.mzbloc.demo.sample107.controller;

import com.mzbloc.demo.sample107.service.StatusService;
import com.mzbloc.demo.sample107.vo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tanxw
 * @date 2019/6/26
 */
@RestController
public class EndpointController {

    @Autowired
    StatusService statusService;

    @RequestMapping("/change")
    public ResponseResult<Object> changeStatus(String status){
        statusService.setStatus(status);
        return new ResponseResult<>(ResponseResult.ResultCode.SUCCESS);
    }
}
