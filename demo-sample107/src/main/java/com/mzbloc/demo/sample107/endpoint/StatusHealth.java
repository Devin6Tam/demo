package com.mzbloc.demo.sample107.endpoint;

import com.mzbloc.demo.sample107.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * @author tanxw
 * @date 2019/6/26
 */
@Component
public class StatusHealth implements HealthIndicator{

    @Autowired
    StatusService statusService;

    @Override
    public Health health() {
        String status = statusService.getStatus();
        if(status == null||!status.equals("running")){
            return Health.down().withDetail("Error", "Not Running").build();
        }
        return Health.up().build();
    }
}
