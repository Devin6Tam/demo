package com.mzbloc.demo.sample106.model;

import lombok.Data;

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
@Data
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
}
