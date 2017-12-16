package com.didispace.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by root on 2017/12/13.
 */
@RestController
public class ConsumerController {

    @Autowired
    HelloService helloService;

    @RequestMapping("/feign-consumer/{name}")
    public String helloController(@PathVariable("name") String name) {
        return helloService.Hello(name);
    }
}
