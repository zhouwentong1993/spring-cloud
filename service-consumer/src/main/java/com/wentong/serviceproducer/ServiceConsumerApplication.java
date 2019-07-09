package com.wentong.serviceproducer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wentong.serviceproducer.remote.HelloRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@RestController
@EnableHystrixDashboard
@EnableCircuitBreaker
public class ServiceConsumerApplication {

	@Autowired
	private HelloRemote helloRemote;

	public static void main(String[] args) {
		SpringApplication.run(ServiceConsumerApplication.class, args);
	}

	@GetMapping("hello/{name}")
	@HystrixCommand
	public String getName(@PathVariable String name) {
		return helloRemote.getName(name);
	}


}
