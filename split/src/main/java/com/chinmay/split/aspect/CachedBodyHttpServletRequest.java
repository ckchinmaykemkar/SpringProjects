package com.chinmay.split.aspect;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class CachedBodyHttpServletRequest extends HttpServletRequestWrapper {
    private final String cachedBody;

    public CachedBodyHttpServletRequest(HttpServletRequest request) throws IOException {
        super(request);
        cachedBody = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
    }

    public String getBody() {
        return cachedBody;
    }
}