package com.cloud.api.config.web;

import com.cloud.api.controller.ErrorController;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author 成都犀牛
 * @version version 1.0
 * @date 2020/10/7 9:02
 */
@Configuration
public class CustomWebAppConfigurer extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ErrorController()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
}
