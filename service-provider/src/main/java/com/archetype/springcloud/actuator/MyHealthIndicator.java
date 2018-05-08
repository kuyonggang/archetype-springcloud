package com.archetype.springcloud.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;

/**
 * 类名称：MyHealthIndicator<br>
 * 类描述：自定义指标 地址栏中访问/health的时候，返回多一个属性："mySpringBootApplication":{"status":"UP","hello":"world"} <br>
 * 创建时间：2018年05月05日<br>
 *
 * @author YoungerKu
 * @version 1.0.0
 */
public class MyHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        return Health.up().withDetail("hello","world").build();
    }
}
