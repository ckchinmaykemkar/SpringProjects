package com.chinmay.split.config;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.util.ContentCachingRequestWrapper;

import java.io.IOException;

public class RequestCachingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        ContentCachingRequestWrapper wrappedRequest = new ContentCachingRequestWrapper((HttpServletRequest) request);
        chain.doFilter(wrappedRequest, response);
    }

//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        // Initialization code if needed
//    }

    @Override
    public void destroy() {
        // Cleanup code if needed
    }
}