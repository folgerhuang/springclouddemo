package com.didispace.consumers;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by root on 2017/12/12.
 */
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloFallback")
    public String Hello(String name) {
        return  restTemplate.getForEntity("http://HELLO-SERVICE/hello/"+name,String.class).getBody();
    }

    public String helloFallback(String name) {
        return "Error";
    }
}
