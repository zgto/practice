package com.example.practice.jsonConstruct;

import lombok.Data;

/**
 * @author zhangtao
 * @data 2021/1/4 - 17:57
 */
@Data
public class JsonResult<T> {

    private T data;
    private String code;
    private String msg;

    public JsonResult(){
        this.code = "0";
        this.msg = "操作成功!";
    }

    public JsonResult(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public JsonResult(T data){
        this.data = data;
        this.msg = "操作成功!";
        this.code = "0";
    }

    public JsonResult(T data, String msg) {
        this.data = data;
        this.code = "0";
        this.msg = msg;
    }
}
