package com.example.weather.dto;

import lombok.Data;

import java.util.Date;

@Data
public class LoggingRequest {
    private String correlationID;
    private String serviceName;
    private String url;
    private String request;
    private String response;
    private String status;
    private String methodName;
    private Date requestTimeIn;
    private Date requestTimeOut;
    private Long timeTaken;
    private String username;
    private String IpAddress;
    private String callStack;
}
