package com.mzbloc.demo.sample104.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.mzbloc.elasticJob.annotation.ElasticJobConf;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by tanxw on 2019/1/24.
 */
@ElasticJobConf(name = "testJob", cron = "0/10 * * * * ?",
        shardingItemParameters = "0=0,1=1", description = "简单打印任务")
@Component
public class TestJob implements SimpleJob{

    @Override
    public void execute(ShardingContext shardingContext) {
//        System.out.println(2/0);
        String shardParamter = shardingContext.getShardingParameter();
        System.out.println("分片参数："+shardParamter);
        int value = Integer.parseInt(shardParamter);
        for (int i = 0; i < 100; i++) {
            if (i % 2 == value) {
                String time = new SimpleDateFormat("HH:mm:ss").format(new Date());
                System.out.println(time + ":开始执行简单任务" + i);
            }
        }
    }
}
