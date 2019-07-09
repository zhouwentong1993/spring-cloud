package com.wentong.serviceproducer.remote;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "service-producer",fallback = HelloRemoteHystrix.class)
public interface HelloRemote {

    @GetMapping("hello/{name}")
    String getName(@PathVariable("name") String name);

}
