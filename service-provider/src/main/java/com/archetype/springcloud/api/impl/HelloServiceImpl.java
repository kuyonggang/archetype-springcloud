package com.archetype.springcloud.api.impl;

import com.archetype.common.api.IHelloService;
import com.archetype.common.model.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.concurrent.TimeUnit;

@RestController
public class HelloServiceImpl implements IHelloService {

    @Override
    public String hello1(String name) {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("hello1...");
        return "hello" + name;
    }

    @Override
    public User hello2(String name, Integer age) {
        System.out.println("hello2...");
        try {
            name= URLDecoder.decode(name,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return new User(name, age);
    }

    @Override
    public String hello3(@RequestBody User user) {
        System.out.println("hello3...");
        if (user == null) {
            return "unKnown";
        }
        return user.toString();
    }
}
