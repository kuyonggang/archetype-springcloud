package com.archetype.springcloud.consumer.controller;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RefreshScope:以这种方式注释的bean可以在运行时刷新
 * 并且使用它们的任何组件将在下一个方法调用上获得一个新实例
 * 完全初始化所有依赖项
 *
 *@author: KYG
 *@create: 2019-08-14 12:28
 */
@RestController
@RefreshScope
@RequestMapping("/config")
public class ConsumerConfigController
{
//    @Value("${hello}")
    private String hello;

    @GetMapping("/hello")
    public String configHello(){
        System.out.println(this.hello);
        return this.hello;
    }
}