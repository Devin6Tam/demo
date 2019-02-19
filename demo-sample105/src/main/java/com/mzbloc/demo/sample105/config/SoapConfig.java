package com.mzbloc.demo.sample105.config;

import com.mzbloc.demo.sample105.interceptor.AuthInInterceptor;
import com.mzbloc.springboot.cxf.soap.config.SoapProperties;
import com.mzbloc.springboot.cxf.soap.config.SoapServlet;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.interceptor.Interceptor;
import org.apache.cxf.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * 自动配置web服务（一次性配置，服务增加无需继续修改配置）
 * Created by tanxw on 2019/1/31.
 */
@Configuration
@EnableConfigurationProperties(SoapProperties.class)
public class SoapConfig {

    @Autowired
    private SoapProperties soapProperties;

    @Bean
    public ServletRegistrationBean dispatcherServlet() {
        SoapServlet soapServlet = new SoapServlet();
        soapServlet.initSoapProperties(soapProperties,inInterceptors(),null);
        return new ServletRegistrationBean(soapServlet,soapProperties.getServerUrl());
    }

    private List<Interceptor<? extends Message>> inInterceptors(){
        List<Interceptor<? extends Message>> list = new ArrayList<>();
        list.add(new AuthInInterceptor());
        return list;
    }

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }
}
