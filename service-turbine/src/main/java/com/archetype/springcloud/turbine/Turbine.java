package com.archetype.springcloud.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 *@program: archetype-springcloud
 *@description:
 *@author: KYG
 *@create: 2019-08-15 13:54
 */
@EnableTurbine
@SpringBootApplication
public class Turbine {

    public static void main(String[] args) {
        SpringApplication.run(Turbine.class);
    }
}