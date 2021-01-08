package com.example.practice;

import com.alibaba.fastjson.JSON;
import com.example.practice.entity.User;
import com.example.practice.service.RedisService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class PracticeApplicationTests {

    @Test
    void contextLoads() {
    }

    private final static Logger logger = LoggerFactory.getLogger(PracticeApplicationTests.class);

    @Resource
    private RedisService redisService;

    @Test
    public void redisContextLoads(){
        redisService.setString("zt","张涛");
        logger.info("我的名字是：{}",redisService.getString("zt"));

        User user = new User("CSDN","121313");
        redisService.setString("user", JSON.toJSONString(user));
        logger.info("用户信息为：{}",redisService.getString("user"));
    }

}
