package com.archetype.common.api;

import com.archetype.common.model.User;
import org.springframework.web.bind.annotation.*;

public interface IHelloService {

    @GetMapping(value = "/hello1")
    String hello1(@RequestParam("name")String name);

    @GetMapping(value = "/hello2")
    User hello2(@RequestParam("name")String name, @RequestParam("age")Integer age);

    @GetMapping(value = "/hello3")
    String hello3(@RequestBody User user);

    @PostMapping("/user/save")
    String saveUser(User user);
}
