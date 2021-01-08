package com.example.practice.entity;

import lombok.Data;

/**
 * @author zhangtao
 * @data 2021/1/4 - 16:13
 */
@Data
public class User {
    private Integer id;
    private String username;
    private String password;

    public User(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
