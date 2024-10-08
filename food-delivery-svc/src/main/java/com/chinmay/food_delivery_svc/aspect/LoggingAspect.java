package com.chinmay.food_delivery_svc.aspect;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.util.ContentCachingRequestWrapper;

import java.nio.charset.StandardCharsets;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LogManager.getLogger(LoggingAspect.class);

    @Around("execution(* com.chinmay.food_delivery_svc.controller.*.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        // Get the current HTTP request
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes != null ? attributes.getRequest() : null;
        if (request instanceof ContentCachingRequestWrapper) {
            ContentCachingRequestWrapper wrappedRequest = (ContentCachingRequestWrapper) request;

            // Log details from the HttpServletRequest
            logger.info("HTTP Method: " + wrappedRequest.getMethod());
            logger.info("Request URI: " + wrappedRequest.getRequestURI());
            logger.info("Remote Address: " + wrappedRequest.getRemoteAddr());

            // Log request body
            String requestBody = new String(wrappedRequest.getContentAsByteArray(), StandardCharsets.UTF_8);
            logger.info("Request Body: " + requestBody.toString());

            // Proceed with the method execution
            Object result = joinPoint.proceed();

            // Log response
            logger.info("Exiting method: " + joinPoint.getSignature().getName());
            logger.info("Response: " + (result != null ? result.toString() : "null"));

            return result;
        } else {
            // If request is not an instance of ContentCachingRequestWrapper, proceed normally
            Object result = joinPoint.proceed();
            logger.info("Response: " + (result != null ? result.toString() : "null"));
            return result;
        }
    }
}
