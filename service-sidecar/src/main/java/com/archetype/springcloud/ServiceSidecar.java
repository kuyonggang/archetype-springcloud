package com.archetype.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;

/**
 * 使用Sidecar整合非JVM微服务。
 *
 */
@SpringBootApplication
@EnableSidecar
public class ServiceSidecar
{
    public static void main( String[] args )
    {
        SpringApplication.run(ServiceSidecar.class);
    }
}
