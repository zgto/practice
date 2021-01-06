package com.example.practice.config;

import com.example.practice.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhangtao
 * @data 2021/1/4 - 16:52
 */
@Configuration
public class BeanConfig {

    @Conditional({WindowCondition.class})
    @Bean(name = "bill")
    public User user1(){
        return new User(1,"Bill","11");
    }

    @Conditional({LinuxCondition.class})
    @Bean(name = "Linus")
    public User user2(){
        return new User(2,"Linus","22");
    }
}
