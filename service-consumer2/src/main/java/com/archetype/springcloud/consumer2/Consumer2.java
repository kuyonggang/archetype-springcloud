package com.archetype.springcloud.consumer2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Hello world!
 *
 */
@EnableDiscoveryClient
@SpringBootApplication
public class Consumer2
{
    public static void main( String[] args )
    {
        SpringApplication.run(Consumer2.class,args);
    }
}
