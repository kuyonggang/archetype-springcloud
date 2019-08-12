package com.archetype.springcloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 服务注册中心Eureka
 */
@EnableEurekaServer
@SpringBootApplication
public class ServiceEurekaApp
{
    public static void main( String[] args )
    {
        SpringApplication.run(ServiceEurekaApp.class);
    }
}
