package com.example.practice.service;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhangtao
 * @data 2021/1/7 - 15:46
 */
@Service
public class RedisService {


    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * set redis: string类型
     * @param key key
     * @param value value
     */
    public void setString(String key,String value){
        ValueOperations<String,String> valueOperations = stringRedisTemplate.opsForValue();
        valueOperations.set(key,value);
    }

    /**
     * get redis: string类型
     * @param key key
     * @return
     */
    public String getString(String key){
        return stringRedisTemplate.opsForValue().get(key);
    }
}
