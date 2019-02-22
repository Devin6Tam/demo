package com.mzbloc.demo.sample106.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mzbloc.demo.sample106.dao.AreaMapper;
import com.mzbloc.demo.sample106.model.Area;
import com.mzbloc.demo.sample106.service.IAreaService;
import com.mzbloc.springboot.mybatis.common.service.impl.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Created by tanxw on 2019/2/22.
 */
@Service
public class AreaService extends BaseService<Area> implements IAreaService{

    @Autowired
    private AreaMapper areaMapper;

    @Override
    public Mapper<Area> getMapper() {
        return super.getMapper();
    }

    @Override
    @Cacheable(value = "areaData",unless = "#result == null")
    public List<Area> getAreaList(){
        return areaMapper.getAreaList();
    }

    @Override
    public PageInfo<Area> getAreaByPage(int pageNum, int pageSize){
        List<Area> areaList = this.getAreaList();
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo<>(areaList);
    }
}
