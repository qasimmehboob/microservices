package com.example.weather.interceptor;

import com.example.weather.service.impl.WeatherServiceImpl;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class FeignRequestInterceptor implements RequestInterceptor {
    Logger logger = LoggerFactory.getLogger(WeatherServiceImpl.class);
    @Override
    public void apply(RequestTemplate requestTemplate) {
        logger.info("Feign Request Interceptor: " + requestTemplate.url());
    }
}
