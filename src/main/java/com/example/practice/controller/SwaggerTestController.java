package com.example.practice.controller;

import com.example.practice.entity.SwaggerUser;
import com.example.practice.jsonConstruct.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangtao
 * @data 2021/1/5 - 14:57
 */
@RestController
@RequestMapping("swagger")
@Api(value = "swagger2 在线接口文档")
public class SwaggerTestController {

    @GetMapping("/get/{id}")
    @ApiOperation(value = "根据用户唯一标识获取用户信息")
    public JsonResult<SwaggerUser> getSwaggerUserInfo(
            @PathVariable @ApiParam(value = "用户唯一标识") Long id
    ){
        SwaggerUser user = new SwaggerUser(id,"zt","123456");
        return new JsonResult<>(user);
    }


}
