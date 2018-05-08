package com.archetype.common.api;

import com.archetype.common.model.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//@RequestMapping("hello-service-remote")
public interface IHelloServiceRemoteApi {

    @RequestMapping(value = "/hello1",method = RequestMethod.GET)
    public String hello(@RequestParam("name")String name);

    @RequestMapping(value = "/hello2",method = RequestMethod.GET)
    public User hello(@RequestParam("name")String name, @RequestParam("age")Integer age);

    @RequestMapping(value = "/hello3",method = RequestMethod.POST)
    public String hello(@RequestBody User user);

}
