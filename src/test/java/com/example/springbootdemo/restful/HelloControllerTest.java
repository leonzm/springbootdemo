package com.example.springbootdemo.restful;

import com.example.springbootdemo.SpringbootdemoApplication;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.assertEquals;

/**
 * @Author: Leon
 * @CreateDate: 2017/6/3
 * @Description:
 * @Version: 1.0.0
 */
@RunWith(SpringRunner.class) // 引入对 Junit4 的支持
@ContextConfiguration(classes = SpringbootdemoApplication.class) // 指定 Spring Boot 的启动类
@WebMvcTest // 用户模拟调用 Controller 的接口发起请求
public class HelloControllerTest {

    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
    }

    @Test
    public void testHello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo("Hello world")));

    }

}
