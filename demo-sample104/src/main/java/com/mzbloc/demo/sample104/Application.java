package com.mzbloc.demo.sample104;

import com.mzbloc.elasticJob.annotation.EnableElasticJob;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by tanxw on 2019/1/21.
 */
@SpringBootApplication
@ComponentScan(basePackages={"com.mzbloc.demo","com.mzbloc.elasticJob"})
@EnableElasticJob
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
