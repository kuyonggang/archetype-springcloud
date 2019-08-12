package com.archetype.springcloud.gateway.provider;

import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 类名称：MyFallbackProvider<br>
 * 类描述：When a circuit for a given route in Zuul is tripped you can provide a fallback response by creating a bean of type ZuulFallbackProvider.
 *  Within this bean you need to specify the route ID (好像是service ID)the fallback is for and provide a ClientHttpResponse to return as a fallback.
 *  Here is a very simple ZuulFallbackProvider implementation.<br>
 * 创建时间：2018年05月05日<br>
 *
 * @author YoungerKu
 * @version 1.0.0
 */
@Component
public class MyFallbackProvider implements ZuulFallbackProvider {

    /**
     * If you would like to provide a default fallback for all routes
     * than you can create a bean of type ZuulFallbackProvider and have the getRoute method return * or null.
     *
     * 修改记录:
     *
     * @author YoungerKu  2018/5/5
     * @param
     * @return java.lang.String
     */
    @Override
    public String getRoute() {
        return "service-consumer1";
    }

    @Override
    public ClientHttpResponse fallbackResponse() {

        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return 200;
            }

            /**
             * 网关向api服务请求时失败了，但是消费者客户端向网关发起的请求是OK的，
             * 不应该把api的404,500等问题抛给客户端
             * 网关和api服务集群对于客户端来说是黑盒子
             */
            @Override
            public String getStatusText() throws IOException {
                return "OK";
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
                JSONObject object = new JSONObject();
                object.put("code",99999);
                object.put("msg","服务暂不可用，请稍候重试！");
                return new ByteArrayInputStream(object.toJSONString().getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                return headers;
            }
        };
    }
}
