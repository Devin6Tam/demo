package com.mzbloc.demo.sample106;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
//@ImportResource({"classpath:dubbo.xml"})
public class DemoSample106Application {

	private static Logger logger = LoggerFactory.getLogger(DemoSample106Application.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoSample106Application.class, args);
		try {
			//阻塞作用，否则会由于不是web项目，执行main方法后立即停止服务。
			System.in.read();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("SpringBoot Start Success");
	}

}
