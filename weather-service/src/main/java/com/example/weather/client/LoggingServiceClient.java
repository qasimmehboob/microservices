package com.example.weather.client;

import com.example.weather.dto.LoggingRequest;
import com.example.weather.dto.LoggingResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "LOGGING-SERVICE")
public interface LoggingServiceClient {

    @PostMapping("/api/v1/logging/payload/display")
    LoggingResponse displayRequestResponsePayload(@RequestBody LoggingRequest request);

    @PostMapping("/api/v1/logging/payload/log")
    LoggingResponse logRequestResponsePayload(@RequestBody LoggingRequest request);
}
