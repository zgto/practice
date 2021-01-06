package com.example.practice.config;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author zhangtao
 * @data 2021/1/4 - 17:19
 * 使用fastjson处理null，将 null 显示为  ""   （有部分显示仍为null）
 */
//@Configuration
public class FastJsonConfig extends WebMvcConfigurationSupport {

    /*@Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters){
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        com.alibaba.fastjson.support.config.FastJsonConfig config = new com.alibaba.fastjson.support.config.FastJsonConfig();
        config.setSerializerFeatures(
                // 保留map空的字段
                SerializerFeature.WriteMapNullValue,
                // 将String类型的null转成""
                SerializerFeature.WriteNullStringAsEmpty,
                // 将Number类型的null转成0
                SerializerFeature.WriteNullNumberAsZero,
                // 将List类型的null转成[]
                SerializerFeature.WriteNullListAsEmpty,
                // 将Boolean类型的null转成false
                SerializerFeature.WriteNullBooleanAsFalse,
                // 避免循环引用
                SerializerFeature.DisableCircularReferenceDetect
        );
        converter.setFastJsonConfig(config);
        converter.setDefaultCharset(Charset.forName("UTF-8"));
        List<MediaType> mediaTypeList = new ArrayList<>();
        // 解决中文乱码问题，相当于在Controller上的@RequestMapping中加了个属性produces = "application/json"
        mediaTypeList.add(MediaType.APPLICATION_JSON);
        converter.setSupportedMediaTypes(mediaTypeList);
        converters.add(converter);
    }*/
}
