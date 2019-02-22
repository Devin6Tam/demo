package com.mzbloc.demo.sample106.dao;

import com.mzbloc.demo.sample106.model.Area;
import com.mzbloc.springboot.mybatis.common.mapper.BaseMapper;

import java.util.List;

/**
 * Created by tanxw on 2019/2/22.
 */
public interface AreaMapper extends BaseMapper<Area>{
    /**
     * 获取区域信息
     * @return
     */
    List<Area> getAreaList();
}
