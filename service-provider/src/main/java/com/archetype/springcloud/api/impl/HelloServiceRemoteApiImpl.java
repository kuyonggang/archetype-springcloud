package com.archetype.springcloud.api.impl;

import com.archetype.common.api.IHelloServiceRemoteApi;
import com.archetype.common.model.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@RestController
public class HelloServiceRemoteApiImpl implements IHelloServiceRemoteApi {

    @Override
    public String hello(String name) {
        return "hello" + name;
    }

    @Override
    public User hello(String name, Integer age) {
        try {
            name= URLDecoder.decode(name,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return new User(name, age);
    }

    @Override
    public String hello(@RequestBody User user) {
        if (user == null) {
            return "unKnown";
        }

        return user.toString();
    }
}
