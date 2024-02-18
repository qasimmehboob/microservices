package com.example.weather.service.impl;

import com.example.weather.client.OpenWeatherClient;
import com.example.weather.dto.OpenWeatherApiResponse;
import com.example.weather.service.WeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Value( "${open-weather-api-key}" )
    private String apiKey;

    Logger logger = LoggerFactory.getLogger(WeatherServiceImpl.class);

    @Autowired
    private OpenWeatherClient weatherClient;

    @Override
    public OpenWeatherApiResponse getWeatherByZip(String zip) {
        logger.info("Getting weather for zip = " + zip);
        long startTime = System.currentTimeMillis();
        OpenWeatherApiResponse weatherApiResponse = weatherClient.getWeatherByZip(zip, apiKey);
        long timeTaken = System.currentTimeMillis() - startTime;
        logger.info("Time Taken = " + timeTaken);
        return weatherApiResponse;
    }
}
