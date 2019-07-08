package com.mzbloc.demo.sample107;

import com.mzbloc.demo.sample107.endpoint.StatusEndpoint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.endpoint.Endpoint;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoSample107Application {

	public static void main(String[] args) {
		SpringApplication.run(DemoSample107Application.class, args);
	}

	@Bean
	public Endpoint<String> status(){
		return new StatusEndpoint();
	}

}
