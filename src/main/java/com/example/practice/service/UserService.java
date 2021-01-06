package com.example.practice.service;

import com.example.practice.entity.User;

import java.util.List;

/**
 * @author zhangtao
 * @data 2021/1/6 - 10:55
 */
public interface UserService {

    User getUser(Long id);

    List<User> getAll();

    User getUserByName(String name);

    User getUser(Long id, String name);

}
