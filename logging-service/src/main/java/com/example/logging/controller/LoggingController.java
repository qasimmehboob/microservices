package com.example.logging.controller;

import com.example.logging.dto.LoggingRequest;
import com.example.logging.dto.LoggingResponse;
import com.example.logging.service.LoggingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

@RestController
@RequestMapping(value = "/payload")
public class LoggingController {

    @Autowired
    private LoggingService loggingService;

    @PostMapping("/log")
    LoggingResponse logRequestResponsePayload(@RequestBody LoggingRequest request) {
        LoggingResponse loggingResponse = loggingService.logRequestResponsePayload(request);
        return loggingResponse;
    }
    @PostMapping("/display")
    LoggingResponse displayRequestResponsePayload(@RequestBody LoggingRequest request) {
        LoggingResponse loggingResponse = loggingService.displayRequestResponsePayload(request);
        return loggingResponse;
    }

}
