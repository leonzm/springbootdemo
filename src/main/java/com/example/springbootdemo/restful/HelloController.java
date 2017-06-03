package com.example.springbootdemo.restful;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Leon
 * @CreateDate: 2017/6/3
 * @Description:
 * @Version: 1.0.0
 */
@RestController
public class HelloController {

    @Value("${hello.in.chinese}")
    private String chineseHello;
    @Value("${hello.in.english}")
    private String englishHello;

    @RequestMapping("hello")
    public String hello() {
        return "Hello world";
    }

    @RequestMapping("hello1")
    public String helloInChinese() {
        return chineseHello;
    }

    @RequestMapping("hello2")
    public String helloInEnglish() {
        return englishHello;
    }

}
