package com.example.weather.dto;

import lombok.Data;

import java.util.List;

@Data
public class OpenWeatherApiResponse {
    private List<WeatherInfo> weather;
    private Main main;
}
