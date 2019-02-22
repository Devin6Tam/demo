package com.mzbloc.demo.sample106.controller;

import com.github.pagehelper.PageInfo;
import com.mzbloc.demo.sample106.model.Area;
import com.mzbloc.demo.sample106.service.IAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by tanxw on 2019/2/22.
 */
@RestController
@RequestMapping(value = "area")
public class AreaController {

    @Autowired
    private IAreaService areaService;

    @RequestMapping("info")
    public List<Area> areaList(){
        return areaService.getAreaList();
    }

    @RequestMapping({"index","/",""})
    public PageInfo<Area> areaList(int pageNum, int pageSize){
        return areaService.getAreaByPage(pageNum,pageSize);
    }

}
