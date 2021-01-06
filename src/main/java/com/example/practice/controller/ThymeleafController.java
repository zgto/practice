package com.example.practice.controller;

import com.example.practice.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangtao
 * @data 2021/1/5 - 15:24
 */
@Controller
@RequestMapping(value = "thymeleaf")
public class ThymeleafController {

    @RequestMapping(value = "test404")
    public String test404(){
        return "index";
    }

    @RequestMapping(value = "test500")
    public String test500(){
        int a = 2/0;
        return "index";
    }

    @GetMapping("getBlogger")
    public String getBlogger(Model model){
        User blogger = new User(1,"zt","123");
        User blogger1 = new User(2,"zt2","123456");
        List<User> list = new ArrayList<>();
        list.add(blogger);list.add(blogger1);
        model.addAttribute("list",list);
        return "blogger";
    }
}
