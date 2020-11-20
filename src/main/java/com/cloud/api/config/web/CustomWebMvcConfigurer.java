package com.cloud.api.config.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 做资源映射
 * @author 成都犀牛
 * @version version 1.0
 * @date 2020/10/31 20:04
 */
@Configuration
public class CustomWebMvcConfigurer implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //和页面有关的静态目录都放在项目的static目录下
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        //第一个是访问路径，第二个是访问第一个路径之后找资源文件的位置
        registry.addResourceHandler("/upload-image/**").addResourceLocations("file:/home/justyou/upload-file/upload-image/");
        //这个是配置本机测试的
//        registry.addResourceHandler("/upload-image/**").addResourceLocations("file:C:\\Users\\HP\\Pictures\\Saved Pictures\\");


    }
}
