package com.example.springbootdemo.restful;

import com.example.springbootdemo.exception.MyException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    // 触发统一异常处理，返回到 error.html
    @RequestMapping(value = "hello-error-html", method = RequestMethod.GET)
    public String helloError() throws Exception {
        throw new Exception("发生错误");
    }

    // 触发统一异常处理，返回异常相关的 json
    @RequestMapping(value = "hello-error-json", method = RequestMethod.GET)
    public String json() throws MyException {
        throw new MyException("发生错误2");
    }

}
