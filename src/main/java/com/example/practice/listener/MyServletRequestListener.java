package com.example.practice.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

/**
 * @author zhangtao
 * @data 2021/1/7 - 11:27
 * 使用ServletRequestListener获取访问信息
 */
@Component
public class MyServletRequestListener implements ServletRequestListener {

    private final static Logger logger = LoggerFactory.getLogger(MyServletRequestListener.class);

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
        logger.info("session id 为：{}",request.getRequestedSessionId());
        logger.info("request url 为:{}",request.getRequestURI());
        request.setAttribute("name","zt");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        logger.info("request end");
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
        logger.info("request域中保存的name值为：{}",request.getAttribute("name"));
    }
}
