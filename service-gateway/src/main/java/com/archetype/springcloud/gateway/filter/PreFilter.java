package com.archetype.springcloud.gateway.filter;/**
 * 类名称：PreFilter<br>
 * 类描述：<br>
 * 创建时间：2019年08月12日<br>
 *
 * @author YoungerKu
 * @version 1.0.0
 */

import com.netflix.zuul.ZuulFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 *@program: archetype-springcloud
 *@description: 请求被路由之前调用
 *@author: KYG
 *@create: 2019-08-12 13:39
 */
@Slf4j
@Component
public class PreFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
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
        LOGGER.info("PreFilter has been executed!!!");
        return null;
    }
}