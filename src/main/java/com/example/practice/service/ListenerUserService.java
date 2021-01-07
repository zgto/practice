package com.example.practice.service;

import com.example.practice.dao.UserMapper;
import com.example.practice.entity.User;
import com.example.practice.listener.MyEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhangtao
 * @data 2021/1/7 - 10:27
 */
@Service
public class ListenerUserService {

    @Autowired
    private UserMapper userMapper;
    @Resource
    private ApplicationContext applicationContext;

    /**
     * 获取用户信息
     * @return
     */
    public List<User> getAllUser() {
        // 实际中会根据具体的业务场景，从数据库中查询对应的信息
        return userMapper.getAll();
    }

    /**
     * 发布事件
     * @return
     */
    public User getUser(){
        User user = new User(123,"adsad","13123");
        MyEvent myEvent = new MyEvent(this,user);
        // 发布事件
        applicationContext.publishEvent(myEvent);
        return user;
    }
}
