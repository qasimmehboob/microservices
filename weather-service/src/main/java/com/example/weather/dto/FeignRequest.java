package com.example.weather.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class FeignRequest {
    private String method = null;
    private String url = null;
    private List<String> headers = new ArrayList<>();
    private String body = null;

    public void addHeader(String key, String value) {
        headers.add(key + ": " + value);
    }

    @Override
    public String toString() {
        return "{\"type\":\"request\",\"method\":\"" + method + "\",\"url\":\"" + url + "\",\"headers\":" + headers + ",\"body\":" + body + "}";
    }
}
