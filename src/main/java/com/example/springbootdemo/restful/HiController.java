package com.example.springbootdemo.restful;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: Leon
 * @CreateDate: 2017/6/3
 * @Description:
 * @Version: 1.0.0
 */
@Controller
@EnableAutoConfiguration
public class HiController {

    @RequestMapping("/hi")
    @ResponseBody
    String hi() {
        return "Hi";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(HiController.class, args);
    }

}
