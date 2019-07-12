package com.wentong.springcloudconsulproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class SpringCloudConsulProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConsulProducerApplication.class, args);
	}

	@GetMapping("hello/{name}")
	public String sayHello(@PathVariable String name) {
		return "hello" + name + ",I am producer1";
	}
}
