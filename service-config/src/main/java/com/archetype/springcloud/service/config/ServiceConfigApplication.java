package com.archetype.springcloud.service.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @EnableEurekaClient: 注册发现客户端
 * @EnableConfigServer: 开启spring cloud config自动装配
 */
@EnableEurekaClient
@EnableConfigServer
@SpringBootApplication
public class ServiceConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceConfigApplication.class, args);
    }

}
