package com.mzbloc.demo.sample105.config;

import com.mzbloc.demo.sample105.soap.DemoService;
import com.mzbloc.demo.sample105.soap.DemoServiceImpl;
import com.mzbloc.springboot.cxf.soap.config.SoapProperties;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

/**
 * Created by tanxw on 2019/1/31.
 */
//@Configuration
//@EnableConfigurationProperties(SoapProperties.class)
public class SoapConfig_3 {

    @Autowired
    private SoapProperties soapProperties;

    @Bean
    public ServletRegistrationBean dispatcherServlet() {
        return new ServletRegistrationBean(new CXFServlet(),soapProperties.getServerUrl());
    }

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }

    @Bean
    public DemoService demoService(){
        return new DemoServiceImpl();
    }

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), demoService());
        endpoint.publish("/api");
        return endpoint;
    }
}
