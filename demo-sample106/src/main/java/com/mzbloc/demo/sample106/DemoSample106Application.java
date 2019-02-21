package com.mzbloc.demo.sample106;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoSample106Application {

	private static Logger logger = LoggerFactory.getLogger(DemoSample106Application.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoSample106Application.class, args);
		logger.info("SpringBoot Start Success");
	}

}
