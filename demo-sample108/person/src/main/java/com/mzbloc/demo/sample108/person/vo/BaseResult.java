package com.mzbloc.demo.sample108.person.vo;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;

/**
 * @author tanxw
 * @date 2019/6/25
 */
public abstract class BaseResult implements Serializable{

    public BaseResult() {

    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE, false);
    }
}
