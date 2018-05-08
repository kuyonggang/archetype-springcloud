package com.archetype.springcloud.consumer.service;

import com.archetype.common.api.IHelloServiceRemoteApi;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "service-provider",fallback = MyFallback.class)
public interface HelloBackgroundService extends IHelloServiceRemoteApi {

    /*@Component
    @Slf4j
    class DefaultFallback{

        public Object fallback(){
            LOGGER.error("请求异常进入断路器！");
            Map<String, Object> params = new HashMap<>();
            params.put("version", "1.0.0");
            params.put("msg", "请求异常进入断路器");
            return params;
        }
    }*/
}
