package com.example.practice.manageUrl;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author zhangtao
 * @data 2021/1/5 - 11:17
 */
@Data
@Component
@ConfigurationProperties(prefix = "url")
public class MicroServiceUrl {
    private String orderUrl;
    private String userUrl;
    private String shoppingUrl;

}
