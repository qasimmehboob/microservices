package com.example.weather.service;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface LoggingService {
    void logFrontendRequest(HttpServletRequest request, Object body);
    void logFrontendResponse(HttpServletRequest request, HttpServletResponse response, Object body);
}
