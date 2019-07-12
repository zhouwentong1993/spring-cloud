package com.wentong.springcloudzuul;

import com.wentong.springcloudzuul.filter.MyFilter;
import com.wentong.springcloudzuul.provider.MyFallbackProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class SpringCloudZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudZuulApplication.class, args);
    }

    @Bean
    public MyFilter myFilter() {
        return new MyFilter();
    }

    @Bean
    public MyFallbackProvider myFallbackProvider() {
        return new MyFallbackProvider();
    }

}
