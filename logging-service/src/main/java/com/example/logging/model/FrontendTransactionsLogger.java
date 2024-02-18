package com.example.logging.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FrontendTransactionsLogger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
