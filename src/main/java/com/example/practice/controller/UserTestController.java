package com.example.practice.controller;

import com.example.practice.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.practice.entity.User;

import javax.annotation.Resource;

/**
 * @author zhangtao
 * @data 2021/1/6 - 11:28
 */
@RestController
@RequestMapping("/userTest")
public class UserTestController {


    @Resource
    private UserService userService;

    /*@RequestMapping("/getUser/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @RequestMapping("/getUser/{id}/{name}")
    public User getUser(@PathVariable Long id, @PathVariable String name) {
        return userService.getUser(id, name);
    }

    @RequestMapping("/getall")
    public List<User> getAll() {
        return userService.getAll();
    }*/

    @RequestMapping("/getUserByName/{name}")
    public User getUserByName(@PathVariable String name) {
        return userService.getUserByName(name);
    }

}
