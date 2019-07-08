package com.mzbloc.demo.sample107.service;

import org.springframework.stereotype.Service;

/**
 * 自定义端点服务
 *
 * @author tanxw
 * @date 2019/6/26
 */
@Service
public class StatusService {

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
