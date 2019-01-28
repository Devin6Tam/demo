package com.mzbloc.demo.sample104.controller;

import com.mzbloc.elasticJob.dynamic.bean.MyJob;
import com.mzbloc.elasticJob.dynamic.service.MyJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tanxw on 2019/1/24.
 */
@RestController
public class JobController {

    @Autowired
    private MyJobService jobService;


    /**
     * 获取某动态注册的任务详情信息
     * @throws Exception
     */
    @GetMapping("/job/detail/{jobName}")
    public Object jobDetail(@PathVariable(value = "jobName")String jobName) {
        Map<String, Object> result = new HashMap<>();
        result.put("status", true);
        try {
            result.put("message","查询成功");
            result.put("data",jobService.getJobDetail(jobName));
        } catch (Exception e) {
            result.put("status", false);
            result.put("message", e.getMessage());
        }
        return result;
    }

    /**
     * 添加动态任务（适用于脚本逻辑已存在的情况，只是动态添加了触发的时间）
     * @param job	任务信息
     * @return
     */
    @PostMapping("/job/add")
    public Object addJob(@RequestBody MyJob job) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("status", true);

        if (!StringUtils.hasText(job.getJobName())) {
            result.put("status", false);
            result.put("message", "name not null");
            return result;
        }

        if (!StringUtils.hasText(job.getCron())) {
            result.put("status", false);
            result.put("message", "cron not null");
            return result;
        }

        if (!StringUtils.hasText(job.getJobType())) {
            result.put("status", false);
            result.put("message", "getJobType not null");
            return result;
        }

        if ("ScriptJob".equals(job.getJobType())) {
            if (!StringUtils.hasText(job.getScriptCommandLine())) {
                result.put("status", false);
                result.put("message", "scriptCommandLine not null");
                return result;
            }
        } else {
            if (!StringUtils.hasText(job.getJobClass())) {
                result.put("status", false);
                result.put("message", "jobClass not null");
                return result;
            }
        }

        try {
            jobService.addJob(job);
        } catch (Exception e) {
            result.put("status", false);
            result.put("message", e.getMessage());
        }
        return result;
    }

    /**
     * 删除动态注册的任务（只删除注册中心中的任务信息）
     * @param jobName	任务名称
     * @throws Exception
     */
    @GetMapping("/job/remove")
    public Object removeJob(String jobName) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("status", true);
        try {
            jobService.removeJob(jobName);
        } catch (Exception e) {
            result.put("status", false);
            result.put("message", e.getMessage());
        }
        return result;
    }
}
