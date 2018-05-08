package com.archetype.springcloud.consumer.controller;

import com.archetype.common.model.User;
import com.archetype.springcloud.consumer.service.HelloBackgroundService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {

    @Autowired
    private HelloBackgroundService helloBackgroundService;

    @RequestMapping(value = "/ribbon")
    public String testRibbon(HttpServletRequest request){
        System.out.println("serviceName:service-consumer，port:" + request.getServerPort());
        return "serviceName:service-consumer，port:" + request.getServerPort();
    }

    /**
     * 传播安全上下文或者使用spring范围
     * 详细内容请参考https://github.com/Netflix/Hystrix/wiki/Configuration
     *
     * 修改记录:
     *
     * @author YoungerKu  2018/5/7
     * @param
     * @return java.lang.String
     */
    @HystrixCommand(fallbackMethod = "fallbackTest",
            commandProperties = {
                    @HystrixProperty(name="execution.isolation.strategy", value="SEMAPHORE")
            })
    @RequestMapping("/hello-world")
    public String helloWorld(){
        String resp = helloBackgroundService.hello("Jack");
        return resp;
    }

    public String fallbackTest(){
        return "====fallbackTest()====";
    }

    @HystrixCommand(fallbackMethod = "fallbackTest",
            commandProperties = {
                    @HystrixProperty(name="execution.isolation.strategy", value="SEMAPHORE")
            })
    @RequestMapping("/hello-with-name")
    public String helloWithName(){
        String s = helloBackgroundService.hello("张三");
        return s;
    }

    @RequestMapping("/hello-with-nameage")
    public String helloWithNameage(){
        User user = null;
        try {
            user  = helloBackgroundService.hello(URLEncoder.encode("李四", "UTF-8"), 30);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "sddddddddd";
    }

    @RequestMapping("/hello")
    public Map<String, Object> hello() {
        Map<String, Object> ret = new HashMap<>();
        StringBuffer sb = new StringBuffer();
        String s1 = helloBackgroundService.hello("张三");
        sb.append(s1).append("\n");
        User user = null;
        try {
            user = helloBackgroundService.hello(URLEncoder.encode("李四", "UTF-8"), 30);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        sb.append(user.toString()).append("\n");
        String s3 = helloBackgroundService.hello(new User("王五", 19));
        sb.append(s3);
        ret.put("show", sb.toString());
        return ret;
    }
}
