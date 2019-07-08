package com.mzbloc.demo.sample108.person.model;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;

/**
 * @author tanxw
 * @date 2019/7/2
 */
public abstract class BaseModel implements Serializable {

    public BaseModel() {

    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE, false);
    }
}

