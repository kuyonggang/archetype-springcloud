package com.archetype.springcloud.consumer.service;

import com.archetype.common.api.IHelloService;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;

/**
 * fallback: 定义容错的处理类，当调用远程接口失败或超时时，会调用对应接口的容错逻辑，fallback指定的类必须实现@FeignClient标记的接口
 * 在使用fallback属性时，需要使用@Component注解，保证fallback类被Spring容器扫描到
 */
@FeignClient(value = "service-provider",fallback = MyFallback.class)
@Service
public interface HelloBackgroundService extends IHelloService {

}
