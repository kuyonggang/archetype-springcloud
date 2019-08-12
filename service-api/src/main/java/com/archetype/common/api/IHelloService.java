package com.archetype.common.api;

import com.archetype.common.model.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

public interface IHelloService {

    @RequestMapping(value = "/hello1",method = RequestMethod.GET)
    public String hello1(@RequestParam("name")String name);

    @RequestMapping(value = "/hello2",method = RequestMethod.GET)
    public User hello2(@RequestParam("name")String name, @RequestParam("age")Integer age);

    @RequestMapping(value = "/hello3",method = RequestMethod.POST)
    public String hello3(@RequestBody User user);

}
