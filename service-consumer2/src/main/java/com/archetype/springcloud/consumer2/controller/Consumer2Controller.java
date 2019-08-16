package com.archetype.springcloud.consumer2.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

//允许跨域访问
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class Consumer2Controller {

    @Autowired
    private RestTemplate restTemplate;

    public String fallbackTest(){
        return "====Consumer2 fallbackTest()====";
    }

    @HystrixCommand(fallbackMethod = "fallbackTest",
            commandProperties = {
                    @HystrixProperty(name="execution.isolation.strategy", value="SEMAPHORE")
            })
    @RequestMapping(value = "/test")
    public String test1(){
        String result = null;
        try {
            Map params = new HashMap();
            params.put("name","kuyonggang");
            params.put("age",23);
            result = restTemplate.getForObject("http://service-provider/hello3",String.class,params);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "/ribbon")
    public String testRibbon(HttpServletRequest request){
        System.out.println("serviceName:service-consumer2，port:" + request.getServerPort());
        return "serviceName:service-consumer2，port:" + request.getServerPort();
    }
}
