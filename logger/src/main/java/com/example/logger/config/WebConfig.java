package com.example.logger.config;


import com.example.logger.controllers.middlewares.LoggerMiddleware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private LoggerMiddleware loggerMiddleware;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loggerMiddleware);
    }
}