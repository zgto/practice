package com.example.practice.controller;

import com.example.practice.annotation.UnInterception;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhangtao
 * @data 2021/1/7 - 14:34
 */
@Controller
@RequestMapping("/interceptor")
public class InterceptorController {

    @RequestMapping("/test")
    public String test(){
        return "hello";
    }

    @UnInterception
    @RequestMapping("/test2")
    public String test2(){
        return "hello";
    }
}
