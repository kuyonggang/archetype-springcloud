package com.archetype.springcloud.consumer.controller;

import base.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.net.URI;

/**
 * 类名称：HelloControllerTest<br>
 * 类描述：<br>
 * 创建时间：2019年08月14日<br>
 *
 * @author YoungerKu
 * @version 1.0.0
 */
public class HelloControllerTest extends BaseTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void fallbackTest() {
    }

    @Test
    public void ribbonTest(){
        //传参
        String params = "";
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get(URI.create("/ribbonTest"))
                //设置请求头信息
//                .header("Authorization","EMS:BASE:TOKEN:Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ3ZWloYWlfMS1bXCJ3ZWloYWlfZ3JvdXBcIl0iLCJleHAiOjE1NjU3MTg2MDR9.FwXPHAv3I2TqtftuhiKkzahCSsYqabdysKQF_jlmVTw9uMnthxC7OIHzxi2_u_p-gXVkANRzhLLuc0M2WXsNGA")
                //传参
//                .content(params)
                .contentType(MediaType.APPLICATION_JSON_UTF8);
        MvcResult result = null;
        try {
            //发起请求并获取结果
            result = mockMvc.perform(requestBuilder).andReturn();
            String content = result.getResponse().getContentAsString();
            System.out.printf("result=" + content);
//            Assert.assertEquals(0,jsonObject.get("code"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void fallbackTest1() {
    }

    @Test
    public void getRespByName() {
    }

    @Test
    public void getUserByNameAge() {
    }

    @Test
    public void hello() {
    }
}