package com.archetype.springcloud.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 *@program: archetype-springcloud
 *@description: 请求被路由之后调用
 *@author: KYG
 *@create: 2019-08-12 13:40
 */
@Slf4j
@Component
public class RoutingFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "routing";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        LOGGER.info("RoutingFilter has been executed!!!");
        return null;
    }
}