package com.archetype.springcloud.gateway;

import com.archetype.springcloud.gateway.filter.PostFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;


/**
 *

/**
 * Spring Cloud提供了Zuul组件来实现API Gateway
 * 使用@EnableZuulProxy来开启Zuul的支持，如果你不想使用Zuul提供的Filter和反向代理的功能的话，此处可以使用@EnableZuulServer注解
 *
 * 修改记录:
 *
 * @author YoungerKu  2018/5/5
 */
@SpringCloudApplication
@EnableZuulProxy
public class ServiceGatewayApp
{
    @Bean
    public PostFilter accessFilter() {
        return new PostFilter();
    }

    public static void main( String[] args )
    {
        SpringApplication.run(ServiceGatewayApp.class,args);
    }
}
