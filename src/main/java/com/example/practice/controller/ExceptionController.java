package com.example.practice.controller;

import com.example.practice.enumm.BusinessMsgEnum;
import com.example.practice.exception.BusinessErrorException;
import com.example.practice.jsonConstruct.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhangtao
 * @data 2021/1/5 - 16:08
 */
@RestController
@RequestMapping("/exception")
public class ExceptionController {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionController.class);

    @PostMapping("/test")
    public JsonResult test(@RequestParam("name") String name,@RequestParam("pass") String pass){
        logger.info(name);
        logger.info(pass);
        return new JsonResult();
    }

    @GetMapping("/business")
    public JsonResult testException() {
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            throw new BusinessErrorException(BusinessMsgEnum.PARAMETER_EXCEPTION);
        }
        return new JsonResult();
    }
}
