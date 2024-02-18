package com.example.weather.client;

import com.example.weather.config.OpenWeatherClientConfig;
import com.example.weather.dto.OpenWeatherApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="weather-client", url="http://api.openweathermap.org/", configuration = OpenWeatherClientConfig.class)
public interface OpenWeatherClient {
    @RequestMapping(method = RequestMethod.GET, value = "data/2.5/weather?units=imperial&zip={zip}&appid={apiKey}", consumes = "application/json")
    OpenWeatherApiResponse getWeatherByZip(@RequestParam("zip") String zip, @RequestParam("apiKey") String apiKey);
}
