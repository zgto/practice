package com.example.practice.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zhangtao
 * @data 2021/1/5 - 14:54
 */
@Data
@ApiModel(value = "用户实体类")
public class SwaggerUser {

    @ApiModelProperty(value = "用户唯一id")
    private Long id;

    @ApiModelProperty(value = "用户姓名")
    private String username;

    @ApiModelProperty(value = "用户密码")
    private String password;

    public SwaggerUser(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
}
