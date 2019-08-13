package com.archetype.springcloud.gateway.filter;/**
 * 类名称：ErrorFilter<br>
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
 *@description: 错误处理过滤器
 *@author: KYG
 *@create: 2019-08-12 13:42
 */
@Slf4j
@Component
public class ErrorFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "error";
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
        LOGGER.info("ErrorFilter has been executed!!!");
        return null;
    }
}