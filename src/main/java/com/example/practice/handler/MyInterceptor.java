package com.example.practice.handler;

import com.example.practice.annotation.UnInterception;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 自定义拦截器
 * @author zhangtao
 * @data 2021/1/7 - 14:19
 */
public class MyInterceptor implements HandlerInterceptor {
    private final static Logger logger = LoggerFactory.getLogger(MyInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        String methodName = method.getName();
        logger.info("===拦截到了方法:{},在该方法执行之前执行",methodName);

        UnInterception unInterception = method.getAnnotation(UnInterception.class);
        if (null != unInterception){
            return true;
        }

        String token = request.getParameter("token");
        if (null == token || "".equals(token)){
            logger.info("用户未登陆，无权限执行，请登陆后重试");
            return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("执行完方法之后执行，但此时还没进行视图渲染");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info("整个请求都处理完毕，DispatcherServlet也渲染了对应视图，此时可以做一些清理工作了");
    }
}
