package com.example.logging.service.impl;

import com.example.logging.dto.LoggingRequest;
import com.example.logging.dto.LoggingResponse;
import com.example.logging.service.LoggingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LoggingServiceImpl implements LoggingService {

    Logger logger = LoggerFactory.getLogger(LoggingServiceImpl.class);

    @Override
    public LoggingResponse logRequestResponsePayload(LoggingRequest request) {
        logger.info("Logger Service Backend Request/Response: {}", request);
        return new LoggingResponse("SUCCESS", "Successfully saved req_res payload");
    }

    @Override
    public LoggingResponse displayRequestResponsePayload(LoggingRequest request) {
        logger.info("Displaying Logger Request");
        return new LoggingResponse("SUCCESS", "Successfully displayed req_res payload");
    }
}
