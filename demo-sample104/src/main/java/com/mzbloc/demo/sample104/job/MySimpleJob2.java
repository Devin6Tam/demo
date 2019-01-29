package com.mzbloc.demo.sample104.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.mzbloc.elasticJob.annotation.ElasticJobConf;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by tanxw on 2019/1/28.
 */
@ElasticJobConf(name = "mySimpleJob2")
@Component
public class MySimpleJob2 implements SimpleJob{

    @Override
    public void execute(ShardingContext shardingContext) {
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
