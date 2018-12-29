package com.mzbloc.demo.sample102;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(value = {"classpath:/dubbo.xml"})
public class DemoSample102Application {

	public static void main(String[] args) {
		SpringApplication.run(DemoSample102Application.class, args);
	}

}

