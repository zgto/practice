package com.example.practice.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author zhangtao
 * @data 2021/1/7 - 10:45
 * 使用HttpSessionListener统计在线用户数的监听器
 */
@Component
public class MyHttpSessionListener implements HttpSessionListener {

    private final static Logger logger = LoggerFactory.getLogger(MyHttpSessionListener.class);

    /**
     * 记录在线的用户数量
     */
    public Integer count = 0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        logger.info("新用户上线了");
        count++;
        se.getSession().getServletContext().setAttribute("count",count);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        logger.info("用户下线了");
        count--;
        se.getSession().getServletContext().setAttribute("count",count);
    }
}
