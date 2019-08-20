package com.archetype.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;

/**
 * 使用Sidecar整合非JVM微服务。
 * @EnableSidecar： 这是一个组合注解，它整合了三个注解，分别是@EnableCircuiBreaker，@EnableDiscoveryClient和@EnableZuulProxy
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
