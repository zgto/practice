package com.example.practice.controller;

import com.example.practice.config.BeanConfig;
import com.example.practice.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

/**
 * @author zhangtao
 * @data 2021/1/4 - 16:55
 */
public class Controller {

    AnnotationConfigApplicationContext configApplicationContext
            = new AnnotationConfigApplicationContext(BeanConfig.class);

    //测试@condition注解
    @Test
    public void test1(){
        String osName = configApplicationContext.getEnvironment().getProperty("os.name");
        System.out.println("当前系统为：" + osName);
        Map<String, User> map = configApplicationContext.getBeansOfType(User.class);
        System.out.println(map);
    }
}
