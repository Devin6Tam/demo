package com.mzbloc.demo.sample106.autoconfig;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.mzbloc.springboot.mybatis.common.mapper.BaseMapper;
import org.springframework.beans.factory.support.BeanNameGenerator;
import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tanxw on 2019/2/20.
 */
@Configuration
@MapperScan(basePackages = "com.mzbloc.demo.sample106.dao",
        markerInterface= BaseMapper.class,nameGenerator= BeanNameGenerator.class)
public class DruidConfig {

    /**
     * 配置druid后台管理的servlet
     *
     * @return
     */
    @Bean
    public ServletRegistrationBean druidServlet() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        Map<String, String> initParams = new HashMap<>();
        initParams.put("loginUsername", "admin");
        initParams.put("loginPassword", "admin");
        initParams.put("allow", "");//默认就是允许所有访问
        initParams.put("deny", "192.168.15.21");//禁止访问的ip
        bean.setInitParameters(initParams);
        return bean;
    }

    /**
     * 配置druid后台管理的filter
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean druidFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        Map<String, String> initParams = new HashMap<>();
        //设置不拦截的路径  /static/*    /druid/*
        initParams.put("exclusions","static/*,/druid/*");
        bean.setInitParameters(initParams);
        //设置filter拦截 那些请求
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }
}
