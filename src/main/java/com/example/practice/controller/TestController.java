package com.example.practice.controller;

import com.example.practice.entity.User;
import com.example.practice.jsonConstruct.JsonResult;
import com.example.practice.manageUrl.MicroServiceUrl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangtao
 * @data 2021/1/4 - 16:13
 */
@RestController
@RequestMapping("/test")
public class TestController {

    private final static Logger logger = LoggerFactory.getLogger(TestController.class);

    @Value("${url.orderUrl}")
    private String orderUrl;

    @Autowired
    private MicroServiceUrl microServiceUrl;

    @RequestMapping("/hello")
    public String test(){
        return "111";
    }

    @RequestMapping("/user")
    public JsonResult<User> getUser() {
        User user = new User(1, "倪升武", "123456");
        return new JsonResult<>(user);
    }

    @RequestMapping("/list")
    public JsonResult<List> getUserList() {
        List<User> userList = new ArrayList<>();
        User user1 = new User(1, "倪升武", "123456");
        User user2 = new User(2, "达人课", "123456");
        userList.add(user1);
        userList.add(user2);
        return new JsonResult<>(userList,"操作操作操作成功成功成功");
    }

    @RequestMapping("/map")
    public JsonResult<Map> getMap() {
        Map<String, Object> map = new HashMap<>();
        User user = new User(1, null, null);
        User user1 = new User(2, "qeq", null);
        map.put("作者信息", user);
        map.put("作者信息1", user1);
        map.put("博客地址", null);
        map.put("CSDN地址", "http://blog.itcodai.com");
        map.put("粉丝数量", null);
        return new JsonResult<>(map);
    }

    @RequestMapping("/log")
    public String testLog(){
        logger.debug("=====测试日志debug级别打印====");
        logger.info("=====测试日志info级别打印====");
        logger.warn("=====测试日志warn级别打印====");
        logger.error("=====测试日志error级别打印====");

        // 可以使用占位符打印出一些参数信息
        String str1 = "blog.itcodai.com";
        String str2 = "https://blog.csdn.net/weixin_45896833";
        logger.info("======倪升武的个人博客：{}；我的CSDN博客：{}", str1, str2);
        return "success";
    }

    @RequestMapping("/config")
    public String testConfig(){
        String q = orderUrl;
        logger.error(q);
        return q;
    }

    @RequestMapping("/config1")
    public String testConfig1(){
        String qq = microServiceUrl.getOrderUrl();
        String qqq = microServiceUrl.getUserUrl();
        String qqqq = microServiceUrl.getShoppingUrl();
        logger.error(qq);
        logger.error(qqq);
        logger.error(qqqq);
        return "ess";
    }


}
