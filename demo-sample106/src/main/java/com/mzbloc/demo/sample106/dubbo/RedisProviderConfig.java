package com.mzbloc.demo.sample106.dubbo;

import com.alibaba.dubbo.config.*;
import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by tanxw on 2019/5/21.
 */
@Configuration
@DubboComponentScan("com.mzbloc.demo.sample106") // 扫描 Dubbo 组件
public class RedisProviderConfig {
    /**
     * 当前应用配置
     */
    @Bean(name = "applicationConfig")
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("redis-demo-server");
        return applicationConfig;
    }

    /**
     * 当前连接注册中心配置
     */
    @Bean(name = "registryConfig")
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
//        registryConfig.setAddress("zookeeper://localhost:2181");
        registryConfig.setAddress("redis://192.168.42.26:6379?password=abc123456");
        return registryConfig;
    }

    /**
     * 当前连接注册中心配置
     */
    @Bean(name = "protocolConfig")
    public ProtocolConfig protocolConfig() {
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(20880);
        return protocolConfig;
    }

    /**
     * 当前连接注册中心配置
     */
    @Bean(name = "providerConfig")
    public ProviderConfig providerConfig() {
        ProviderConfig providerConfig = new ProviderConfig();
        providerConfig.setTimeout(10000);
        providerConfig.setThreads(50);
        providerConfig.setThreadpool("fixed");
        providerConfig.setLoadbalance("roundrobin");
        return providerConfig;
    }


    /**
     * 当前连接注册中心配置
     */
    @Bean(name = "providerConfig")
    public ConsumerConfig consumerConfig() {
        ConsumerConfig consumerConfig = new ConsumerConfig();
        consumerConfig.setCheck(false);
        return consumerConfig;
    }
}
