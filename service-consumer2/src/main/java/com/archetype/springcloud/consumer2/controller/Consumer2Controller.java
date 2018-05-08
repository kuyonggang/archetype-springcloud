package com.archetype.springcloud.consumer2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class Consumer2Controller {

    @RequestMapping(value = "/test")
    public String test1(){
        return "serviceB response...";
    }

    @RequestMapping(value = "/ribbon")
    public String testRibbon(HttpServletRequest request){
        System.out.println("serviceName:service-consumer2，port:" + request.getServerPort());
        return "serviceName:service-consumer2，port:" + request.getServerPort();
    }
}
