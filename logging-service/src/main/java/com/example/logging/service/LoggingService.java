package com.example.logging.service;

import com.example.logging.dto.LoggingRequest;
import com.example.logging.dto.LoggingResponse;

public interface LoggingService {
    LoggingResponse logRequestResponsePayload(LoggingRequest request);
    LoggingResponse displayRequestResponsePayload(LoggingRequest request);
}
