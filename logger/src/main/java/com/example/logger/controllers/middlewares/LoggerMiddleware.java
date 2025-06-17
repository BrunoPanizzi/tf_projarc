package com.example.logger.controllers.middlewares;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.example.logger.controllers.ApprovedQuotationController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class LoggerMiddleware implements HandlerInterceptor {
    private static final Logger logger = LogManager.getLogger(ApprovedQuotationController.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        logger.info("Request: " + request.getMethod() + " " + request.getRequestURI());
        return true;
    }
}
