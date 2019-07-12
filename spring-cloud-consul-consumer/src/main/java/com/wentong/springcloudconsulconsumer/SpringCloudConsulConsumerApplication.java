package com.wentong.springcloudconsulconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringCloudConsulConsumerApplication {

    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private DiscoveryClient discoveryClient;

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConsulConsumerApplication.class, args);
    }

    @GetMapping("services")
    public Object services() {
        return discoveryClient.getInstances("spring-cloud-consul-producer");
    }

    @GetMapping("discover")
    public String discover() {
        return loadBalancerClient.choose("spring-cloud-consul-producer").getUri().toString();
    }

}
