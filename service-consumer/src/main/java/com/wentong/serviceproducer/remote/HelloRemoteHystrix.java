package com.wentong.serviceproducer.remote;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

@Component
public class HelloRemoteHystrix implements HelloRemote {

    @Override
    public String getName(@PathVariable("name") String name) {
        return "fallback name";
    }
}
