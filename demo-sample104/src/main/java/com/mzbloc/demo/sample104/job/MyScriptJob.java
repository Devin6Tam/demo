package com.mzbloc.demo.sample104.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.mzbloc.elasticJob.annotation.ElasticJobConf;
import org.springframework.stereotype.Component;

/**
 * Created by tanxw on 2019/1/28.
 */
@ElasticJobConf(name="myScriptJob")
@Component
public class MyScriptJob implements SimpleJob{

    @Override
    public void execute(ShardingContext shardingContext) {

    }
}
