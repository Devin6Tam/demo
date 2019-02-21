package com.mzbloc.demo.sample106.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 区域信息实体类
 * Created by tanxw on 2016/12/9.
 */
@Table(name = "area")
public class Area implements Serializable {
    @Id
    @Column(name="id")
    private Integer id;
    @Column(name="code")
    private Integer code;
    @Column(name="name")
    private String name;
    @Column(name="type")
    private String type;
    @Column(name="parentCode")
    private Integer parentCode;

    @Transient
    private List<Area> sonAreaList = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getParentCode() {
        return parentCode;
    }

    public void setParentCode(Integer parentCode) {
        this.parentCode = parentCode;
    }

    @Transient
    public List<Area> getSonAreaList() {
        return sonAreaList;
    }

    @Transient
    public void setSonAreaList(List<Area> sonAreaList) {
        this.sonAreaList = sonAreaList;
    }
}
