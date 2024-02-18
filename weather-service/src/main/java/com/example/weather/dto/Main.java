package com.example.weather.dto;

import lombok.Data;

@Data
public class Main {
    private Number temp;
    private Number feels_like;
    private Number pressure;
    private Number humidity;
}
