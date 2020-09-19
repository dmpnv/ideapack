package com.dmpnv.ideapack.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
public class IdeapackServices {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/")
    public String home() {
        StringBuilder sb = new StringBuilder();
        List<String> services = discoveryClient.getServices();

        for (String name : services) {
            List<ServiceInstance> serviceInstances = discoveryClient.getInstances(name);
            sb.append("service: ").append(name).append("<br />");
            for (ServiceInstance serviceInstance : serviceInstances) {
                String host = serviceInstance.getHost();
                sb.append("  host: ").append(host).append("<br />");
                String instanceId = serviceInstance.getInstanceId();
                sb.append("  instanceId: ").append(instanceId).append("<br />");
                Map<String, String> metadata = serviceInstance.getMetadata();
                sb.append("  metadata: ").append(metadata).append("<br />");
                URI uri = serviceInstance.getUri();
                sb.append("  uri: ").append(uri).append("<br />");
                String serviceId = serviceInstance.getServiceId();
                sb.append("  serviceId: ").append(serviceId).append("<br />");
            }
        }
        return "discoveryClient.description(): " + discoveryClient.description() + "<br />" +
                "services: " + services + "<br />" +
                sb;
    }

}
