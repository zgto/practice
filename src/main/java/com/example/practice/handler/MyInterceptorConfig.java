package com.example.practice.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author zhangtao
 * @data 2021/1/7 - 14:30
 */
@Component
public class MyInterceptorConfig extends WebMvcConfigurationSupport {

    //添加写好的自定义拦截器，设置拦截路径（全部）
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

    //继承此方法，将静态资源放开
    //若继承WebMvcConfigurer,则不用重写此方法也可放开静态资源
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }

}
