package com.example.weather.config;

import com.example.weather.client.LoggingServiceClient;
import com.example.weather.dto.FeignRequest;
import com.example.weather.dto.FeignResponse;
import com.example.weather.dto.LoggingRequest;
import com.example.weather.service.LoggingService;
import feign.Logger;
import feign.Request;
import feign.Response;
import feign.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.nio.charset.Charset;

@Slf4j
public class FeignClientLogger extends Logger {

    @Autowired
    LoggingServiceClient loggingServiceClient;

    @Override
    protected void logRequest(String configKey, Level logLevel, Request request) {
        if (request == null)
            return;
        FeignRequest feignRequest = new FeignRequest();
        feignRequest.setMethod(request.httpMethod().name());
        feignRequest.setUrl(request.url());
        for (String field : request.headers().keySet()) {
            for (String value : request.headers().get(field)) {
                feignRequest.addHeader(field, value);
            }
        }
        if (request.body() != null) {
            feignRequest.setBody(request.body().toString());
        }
        //log.info(feignRequest.toString());
        //loggingService.logBackendRequest(feignRequest);

        LoggingRequest loggingRequest = new LoggingRequest();
        loggingRequest.setRequest(feignRequest.getBody());
        loggingRequest.setUrl(feignRequest.getUrl());
        loggingRequest.setMethodName(feignRequest.getMethod());
        loggingServiceClient.logRequestResponsePayload(loggingRequest);
    }
    @Override
    protected Response logAndRebufferResponse(String configKey, Level logLevel, Response response, long elapsedTime) throws IOException {
        if (response == null)
            return null;

        FeignResponse feignResponse = new FeignResponse();
        int status = response.status();
        feignResponse.setStatus(status);
        feignResponse.setReason((response.reason() != null && logLevel.compareTo(Level.NONE) > 0) ? " " + response.reason() : "");
        feignResponse.setDuration(elapsedTime);
        if (logLevel.compareTo(Level.HEADERS) >= 0) {
            for (String field : response.headers().keySet()) {
                for (String value : response.headers().get(field)) {
                    feignResponse.addHeader(field, value);
                }
            }
            if (response.body() != null && !(status == 204 || status == 205)) {
                byte[] bodyData = Util.toByteArray(response.body().asInputStream());
                if (logLevel.compareTo(Level.FULL) >= 0 && bodyData.length > 0) {
                    feignResponse.setBody(new String(bodyData, Charset.forName("UTF-8")));
                }
                //log.info(feignResponse.toString());
                //loggingService.logBackendResponse(feignResponse);

                LoggingRequest loggingRequest = new LoggingRequest();
                loggingRequest.setResponse(feignResponse.getBody());
                loggingRequest.setStatus(String.valueOf(feignResponse.getStatus()));
                loggingRequest.setTimeTaken(feignResponse.getDuration());
                loggingServiceClient.logRequestResponsePayload(loggingRequest);

                return response.toBuilder().body(bodyData).build();
            } else {
                //log.info(feignResponse.toString());
                //loggingService.logBackendResponse(feignResponse);
                LoggingRequest loggingRequest = new LoggingRequest();
                loggingRequest.setResponse(feignResponse.getBody());
                loggingRequest.setStatus(String.valueOf(feignResponse.getStatus()));
                loggingRequest.setTimeTaken(feignResponse.getDuration());
                loggingServiceClient.logRequestResponsePayload(loggingRequest);
            }
        }

        return response;
    }
    @Override
    protected void log(String s, String s1, Object... objects) {

    }
}
