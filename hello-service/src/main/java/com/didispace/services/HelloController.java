package com.didispace.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by root on 2017/12/9.
 */
@RestController
public class HelloController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/hello/{name}", method = RequestMethod.GET)
    public String Hello(@PathVariable String name) {
        ServiceInstance localServiceInstance = client.getLocalServiceInstance();
        logger.info("/hello/"+name+" server:"+localServiceInstance.getHost()+",serviceId:"+localServiceInstance.getServiceId());
        return String.format("hello %s", name);
    }
}
