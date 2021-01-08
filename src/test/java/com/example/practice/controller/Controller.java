package com.example.practice.controller;

import com.alibaba.fastjson.JSON;
import com.example.practice.config.BeanConfig;
import com.example.practice.entity.User;
import com.example.practice.service.RedisService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author zhangtao
 * @data 2021/1/4 - 16:55
 */
public class Controller {

    AnnotationConfigApplicationContext configApplicationContext
            = new AnnotationConfigApplicationContext(BeanConfig.class);

    private final static Logger logger = LoggerFactory.getLogger(Controller.class);

    @Resource
    private RedisService redisService;

    //测试@condition注解
    @Test
    public void test1(){
        String osName = configApplicationContext.getEnvironment().getProperty("os.name");
        System.out.println("当前系统为：" + osName);
        Map<String, User> map = configApplicationContext.getBeansOfType(User.class);
        System.out.println(map);
    }

    @Test
    public void redisContextLoads(){
        redisService.setString("zt","张涛");
        logger.info("我的名字是：",redisService.getString("zt"));

        User user = new User("CSDN","121313");
        redisService.setString("user", JSON.toJSONString(user));
        logger.info("用户信息为：{}",redisService.getString("user"));
    }
}
