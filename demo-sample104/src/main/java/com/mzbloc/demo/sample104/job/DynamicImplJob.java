package com.mzbloc.demo.sample104.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;

/**
 * Created by tanxw on 2019/2/19.
 */
public class DynamicImplJob implements SimpleJob{

    @Override
    public void execute(ShardingContext shardingContext) {
        switch (shardingContext.getShardingItem()){
            case 0:
                System.out.println("doing sharding 0...job name is "+shardingContext.getJobName());
                // do something by sharding item 0
                break;
            case 1:
                System.out.println("doing sharding 1...job name is "+shardingContext.getJobName());
                // do something by sharding item 1
                break;
        }
    }
}
