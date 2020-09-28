package com.dmpnv.ideapack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("file:/opt/ideapack.properties")
public class IdeapackServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(IdeapackServicesApplication.class, args);
	}

}
