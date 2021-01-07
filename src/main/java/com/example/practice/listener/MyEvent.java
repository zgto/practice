package com.example.practice.listener;

import com.example.practice.entity.User;
import org.springframework.context.ApplicationEvent;

/**
 * 自定义事件
 * @author zhangtao
 * @data 2021/1/7 - 11:40
 */
public class MyEvent extends ApplicationEvent {

    private User user;

    public MyEvent(Object source,User user) {
        super(source);
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
