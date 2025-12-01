package com.example.weatherposting.service;

import com.example.weatherposting.model.WeatherEntry;
import com.example.weatherposting.repository.WeatherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WeatherService {

    private final WeatherRepository repo;
    private final RestTemplate restTemplate;

    @Value("${weather.api.key}")
    private String apiKey;
    @Value("${weather.api.base-url}")
    private String apiURL;


    public WeatherEntry addEntry(String city, String msg) {
        //WeatherEntry entry = new WeatherEntry();
        return null;
    }

    public List<WeatherEntry> getEntriesByCity(String city) {
        return null;
    }

    public List<WeatherEntry> getAllEntries() {
        return null;
    }
}
