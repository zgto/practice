package com.example.practice.listener;

import com.example.practice.entity.User;
import com.example.practice.service.ListenerUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import java.util.List;

/**
 * @author zhangtao
 * @data 2021/1/7 - 10:22
 */
@Component
public class MyServletContextListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        //先获取到application上下文
        ApplicationContext applicationContext = contextRefreshedEvent.getApplicationContext();
        //获取对应的Service
        ListenerUserService listenerUserService = applicationContext.getBean(ListenerUserService.class);
        List<User> userList = listenerUserService.getAllUser();
        //获取application域对象，将查到的信息放到application域中
        ServletContext application = applicationContext.getBean(ServletContext.class);
        application.setAttribute("userList",userList);

    }
}
