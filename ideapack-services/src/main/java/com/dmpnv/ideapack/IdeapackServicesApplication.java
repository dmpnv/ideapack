package com.dmpnv.ideapack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class IdeapackServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(IdeapackServicesApplication.class, args);
	}

}
