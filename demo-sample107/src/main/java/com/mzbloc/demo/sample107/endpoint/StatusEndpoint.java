package com.mzbloc.demo.sample107.endpoint;

import com.mzbloc.demo.sample107.service.StatusService;
import org.springframework.beans.BeansException;
import org.springframework.boot.actuate.endpoint.AbstractEndpoint;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author tanxw
 * @date 2019/6/26
 */
@ConfigurationProperties(prefix = "endpoints.status",ignoreUnknownFields = false)
public class StatusEndpoint extends AbstractEndpoint<String> implements ApplicationContextAware{

    ApplicationContext context;

    public StatusEndpoint(){
        super("status");
    }

    @Override
    public String invoke() {
        StatusService statusService = context.getBean(StatusService.class);

        return "The current status is :"+statusService.getStatus();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
