package com.mzbloc.demo.sample106.service;

import com.github.pagehelper.PageInfo;
import com.mzbloc.demo.sample106.model.Area;
import com.mzbloc.springboot.mybatis.common.service.IBaseService;

import java.util.List;

/**
 * Created by tanxw on 2019/2/22.
 */
public interface IAreaService extends IBaseService<Area>{

    List<Area> getAreaList();

    PageInfo<Area> getAreaByPage(int pageNum, int pageSize);
}
