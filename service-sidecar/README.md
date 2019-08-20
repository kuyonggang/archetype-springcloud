**_Sidecar的一些端点_**
/ 返回一个测试页面，展示sidecar的常用端点
/hosts/{serviceId} 指定微服务在eureka上的实例列表。
/ping 返回OK字符串
/{serviceId} 由于sidecar整合了zuul，因此使用该将请求转发到service对应的微服务,非JVM微服务可通过这种方式调用注册在Eureka Server上的JVM微服务
可以部署多个Zuul节点即可实现其高可用，sidecar会自动从Eureka Server中查询Zuul Server的列表，并使用Ribbon负载均衡地请求Zuul集群

sidecar可以对Node.js微服务进行代理，如果两者部署在同一台机器上，配置文件只需要添加
sidecar.port=8080
sidecar.health-uri=http://localhost:8080/health
即可。
但如果sidecar与所代理的微服务分开部署，可以采用下门任一种配置：
方式一：
    sidecar.hostname : 微服务的hostname
    sidecar.ip-address : 微服务的ip地址
方式二：
    eureka.instance.hostname=localhost
========================================================================================
