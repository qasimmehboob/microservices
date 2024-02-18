package com.example.weather.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class FeignResponse {
    private int status = 0;
    private String reason = null;
    private long duration = 0;
    private List<String> headers = new ArrayList<>();
    private String body = null;

    public void addHeader(String key, String value) {
        headers.add(key + ": " + value);
    }

    @Override
    public String toString() {
        return "{\"type\":\"response\",\"status\":\"" + status + "\",\"duration\":\"" + duration + "\",\"headers\":" + headers + ",\"body\":" + body + ",\"reason\":" + reason + "}";
    }
}
