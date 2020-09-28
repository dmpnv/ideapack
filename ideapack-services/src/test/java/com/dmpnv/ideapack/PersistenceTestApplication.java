package com.dmpnv.ideapack;

import com.dmpnv.ideapack.services.IdeapackServices;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ActiveProfiles;

@TestConfiguration
@ComponentScan(basePackages = {
		"com.dmpnv.ideapack.api",
		"com.dmpnv.ideapack.model",
		"com.dmpnv.ideapack.persistence"},
		excludeFilters={
				@ComponentScan.Filter(type=FilterType.ASSIGNABLE_TYPE, value=IdeapackServicesApplication.class),
				@ComponentScan.Filter(type=FilterType.ASSIGNABLE_TYPE, value= IdeapackServices.class)})
@PropertySource("file:/opt/ideapack-persistenceTest.properties")
public class PersistenceTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersistenceTestApplication.class, args);
	}

}
