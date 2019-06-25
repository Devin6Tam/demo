package com.mzbloc.demo.sample107.controller;

import com.mzbloc.demo.sample107.vo.ResponseResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tanxw
 * @date 2019/6/25
 */
@RestController
@RequestMapping("test")
public class TestController {

    @RequestMapping("version")
    public ResponseResult<Object> getVersion(){
        Map<String,Object> modelMap = new HashMap<>(3);
        modelMap.put("project_version","0.0.1");
        modelMap.put("springboot_version","1.4.0-RELEASE");
        modelMap.put("use","docker");
        return new ResponseResult<>(ResponseResult.ResultCode.SUCCESS,"",modelMap);
    }
}
