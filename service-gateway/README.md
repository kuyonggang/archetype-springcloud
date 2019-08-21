SpringBoot 监控管理模块actuator没有权限的问题解决方法:
SpringBoot 1.5.9 版本加入actuator依赖后，访问/beans 等敏感的信息时候报错，如下

Tue Mar 07 21:18:57 GMT+08:00 2017 
There was an unexpected error (type=Unauthorized, status=401). 
Full authentication is required to access this resource.
**肯定是权限问题了,有两种方式：**
1.关闭权限：application.properties添加配置参数
management.security.enabled=false

2.添加权限（未测试）：
<dependency> 
 <groupId>org.springframework.boot</groupId> 
 <artifactId>spring-boot-starter-security</artifactId>
</dependency>
在property中配置权限

ID	描述	敏感（Sensitive）
autoconfig	显示一个auto-configuration的报告，该报告展示所有auto-configuration候选者及它们被应用或未被应用的原因	true
beans	显示一个应用中所有Spring Beans的完整列表	true
configprops	显示一个所有@ConfigurationProperties的整理列表	true
dump	执行一个线程转储	true
env	暴露来自Spring　ConfigurableEnvironment的属性	true
health	展示应用的健康信息（当使用一个未认证连接访问时显示一个简单的'status'，使用认证连接访问则显示全部信息详情）	false
info	显示任意的应用信息	false
metrics	展示当前应用的'指标'信息	true
mappings	显示一个所有@RequestMapping路径的整理列表	true
shutdown	允许应用以优雅的方式关闭（默认情况下不启用）	true
trace	显示trace信息（默认为最新的一些HTTP请求）	true