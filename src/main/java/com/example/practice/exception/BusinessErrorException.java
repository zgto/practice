package com.example.practice.exception;

import com.example.practice.enumm.BusinessMsgEnum;
import lombok.Data;

/**
 * @author zhangtao
 * @data 2021/1/5 - 16:40
 * 自定义业务异常
 */
@Data
public class BusinessErrorException extends RuntimeException {
    /**
     * 异常码
     */
    private String code;
    /**
     * 异常提示信息
     */
    private String message;

    public BusinessErrorException(BusinessMsgEnum businessMsgEnum){
        this.code = businessMsgEnum.getCode();
        this.message = businessMsgEnum.getMsg();
    }
}
