package com.archetype.springcloud.consumer.controller;

import com.archetype.common.model.User;
import com.archetype.springcloud.consumer.service.HelloBackgroundService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
public class HelloController {

    @Autowired
    private HelloBackgroundService helloBackgroundService;

    public String fallbackTest(){
        return "====fallbackTest()====";
    }

    @GetMapping(value = "/ribbonTest")
    public String ribbonTest(HttpServletRequest request){
        System.out.println("Ribbon test，port:" + request.getServerPort());
        return "Ribbon test，port:" + request.getServerPort();
    }

    @GetMapping(value = "/fallbackTest")
    public String fallbackTest(HttpServletRequest request) throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Fallback test，port:" + request.getServerPort());
        return "Fallback test，port:" + request.getServerPort();
    }

    /**
     * 传播安全上下文或者使用spring范围
     * 详细内容请参考https://github.com/Netflix/Hystrix/wiki/Configuration
     *
     * @author YoungerKu  2018/5/7
     * @param
     * @return java.lang.String
     */
    @HystrixCommand(fallbackMethod = "fallbackTest",
            commandProperties = {
                    @HystrixProperty(name="execution.isolation.strategy", value="SEMAPHORE")
            })
    @GetMapping("/getRespByName")
    public String getRespByName(){
        String s = helloBackgroundService.hello1("张三");
        return s;
    }

    @GetMapping("/getUserByNameAge")
    public User getUserByNameAge(){
        User user = null;
        try {
            user  = helloBackgroundService.hello2(URLEncoder.encode("李四", "UTF-8"), 30);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return user;
    }

    @GetMapping("/hello")
    public Map<String, Object> hello() throws InterruptedException {
        StringBuffer sb = new StringBuffer();
        String s1 = helloBackgroundService.hello1("张三");
        sb.append(s1).append("\n");
        User user = null;
        try {
            user = helloBackgroundService.hello2(URLEncoder.encode("李四", "UTF-8"), 30);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        sb.append(user.toString()).append("\n");
        String s3 = helloBackgroundService.hello3(new User("王五", 19));
        sb.append(s3);
        Map<String, Object> ret = new HashMap<>();
        ret.put("show", sb.toString());
        return ret;
    }

}
