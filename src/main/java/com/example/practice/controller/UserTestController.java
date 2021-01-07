package com.example.practice.controller;

import com.example.practice.entity.User;
import com.example.practice.service.ListenerUserService;
import com.example.practice.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/**
 * @author zhangtao
 * @data 2021/1/6 - 11:28
 */
@RestController
@RequestMapping("/userTest")
public class UserTestController {


    @Resource
    private UserService userService;
    @Resource
    private ListenerUserService listenerUserService;

    @RequestMapping("/getUser/{id}")
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
    }

    @RequestMapping("/getUserByName/{name}")
    public User getUserByName(@PathVariable String name) {
        return userService.getUserByName(name);
    }

    @GetMapping("/user")
    public List<User> getUser(HttpServletRequest request){
        ServletContext application = request.getServletContext();
        return (List<User>) application.getAttribute("userList");
    }

    /**
     * 使用监听器获取当前在线人数，该方法有bug，修改方法如下：getTotalUser2
     * @param request
     * @return
     */
    @GetMapping("/getTotalUser")
    public String getTotalUser(HttpServletRequest request){
        Integer count = (Integer) request.getSession().getServletContext().getAttribute("count");
        return "当前在线人数："+count;
    }

    @GetMapping("/getTotalUser2")
    public String getTotalUser2(HttpServletRequest request, HttpServletResponse response){
        Cookie cookie;
        try {
            // 把sessionId记录在浏览器中
            cookie = new Cookie("JSESSIONID", URLEncoder.encode(request.getSession().getId(),"utf-8"));
            cookie.setPath("/");
            //设置cookie有效期为2天，设置长一点
            cookie.setMaxAge(48*60*60);
            response.addCookie(cookie);
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        Integer count = (Integer) request.getSession().getServletContext().getAttribute("count");
        return "当前在线人数："+count;
    }

    @GetMapping("/requestInfo")
    public String getRequestInfo(HttpServletRequest request) {
        System.out.println("requestListener中的初始化的name数据：" + request.getAttribute("name"));
        return "success";
    }

    @GetMapping("/publish")
    public User publishEvent() {
        return listenerUserService.getUser();
    }

}
