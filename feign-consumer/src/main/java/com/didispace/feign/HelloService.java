package com.didispace.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by root on 2017/12/13.
 */
@FeignClient("hello-service")
public interface HelloService {

    @RequestMapping("/hello/{name}")
    public String Hello(@PathVariable("name") String name);
}
