package com.example.practice.service.impl;

import com.example.practice.dao.UserMapper;
import com.example.practice.entity.User;
import com.example.practice.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhangtao
 * @data 2021/1/6 - 10:56
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    /*@Override
    public User getUser(Long id) {
        return userMapper.getUser(id);
    }

    @Override
    public List<User> getAll() {
        return userMapper.getAll();
    }*/

    @Override
    public User getUserByName(String name) {
        return userMapper.getUserByName(name);
    }

    /*@Override
    public User getUser(Long id, String name) {
        return userMapper.getUserByIdAndName(id, name);
    }*/
}