package com.archetype.springcloud.consumer.service;

import com.archetype.common.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 类名称：MyFallback<br>
 * 类描述：<br>
 * 创建时间：2018年05月05日<br>
 *
 * @author YoungerKu
 * @version 1.0.0
 */
@Component
@Slf4j
public class MyFallback implements HelloBackgroundService{
    @Override
    public String hello1(String name) {
        return "My fallback";
    }

    @Override
    public User hello2(String name, Integer age) {
        return new User("小王",199);
    }

    @Override
    public String hello3(User user) {
        return null;
    }

    @Override
    public String saveUser(User user) {
        return null;
    }

    public Object fallback() {
        LOGGER.error("请求异常进入断路器！");
        Map<String, Object> params = new HashMap<>();
        params.put("version", "1.0.0");
        params.put("msg", "请求异常进入断路器");
        return params;
    }
}
