package com.archetype.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 服务提供者
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ServiceProviderApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(ServiceProviderApplication.class);
    }
}
