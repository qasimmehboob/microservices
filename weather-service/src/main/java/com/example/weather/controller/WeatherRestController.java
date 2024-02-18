package com.example.weather.controller;

import com.example.weather.dto.OpenWeatherApiResponse;
import com.example.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("openweathermap")
public class WeatherRestController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping
    OpenWeatherApiResponse getWeatherByZip(@RequestParam("zip") String zip) {
        OpenWeatherApiResponse weatherApiResponse = weatherService.getWeatherByZip(zip);
        return weatherApiResponse;
    }
}
