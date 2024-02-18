package com.example.weather.service;

import com.example.weather.dto.OpenWeatherApiResponse;

public interface WeatherService {
    OpenWeatherApiResponse getWeatherByZip(String zip);
}
