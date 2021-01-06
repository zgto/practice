package com.example.practice.dao;

import com.example.practice.entity.User;

/**
 * @author zhangtao
 * @data 2021/1/6 - 10:43
 */
public interface UserMapper {
    // 使用xml方式
    User getUserByName(String username);

    /*@Select("select * from user where id = #{id}")
    @Results({
            @Result(property = "username", column = "user_name"),
            @Result(property = "password", column = "password")
    })
    User getUser(Long id);

    @Select("select * from user where id = #{id} and user_name=#{name}")
    User getUserByIdAndName(@Param("id") Long id, @Param("name") String username);

    @Select("select * from user")
    List<User> getAll();*/
}
