package com.example.weather.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

public class OpenWeatherClientConfig {
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    Logger feignLogger() {
        return new FeignClientLogger();
    }
}
