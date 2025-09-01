package com.edcapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {
	    "com.edcapplication.model",
	    "com.empoweredge.model"
	})
public class EdcapplicationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EdcapplicationServiceApplication.class, args);
	}

}
