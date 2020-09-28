package com.dmpnv.ideapack;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@EnableDiscoveryClient
@ConditionalOnProperty(name = "cloud.enabled", value = "true")
public class CloudConfig {
}
