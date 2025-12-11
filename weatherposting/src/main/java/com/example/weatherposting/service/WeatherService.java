package com.example.weatherposting.service;

import com.example.weatherposting.model.WeatherEntry;
import com.example.weatherposting.repository.WeatherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WeatherService {

    private final WeatherRepository repo;

    private final RestTemplate restTemplate;

    @Value("${weather.api.key}")
    private String apiKey;
    @Value("${weather.api.base-url}")
    private String apiURL;


    public Optional<WeatherEntry> addEntry(String city, String msg) {
        String url = apiURL + "?q=" + city + "&appid=" + apiKey + "&units=metric";
        Map<String, Object> response;

        try{
            response = restTemplate.getForObject(url,Map.class);
        } catch (Exception e) {
            return Optional.empty();
        }
        Optional<Map<String, Object>> mainOpt = Optional.ofNullable((Map<String, Object>) response.get("main"));
        //extract temp safely from main using optionals
        Optional<Double> tempOptional = mainOpt
                .map(main -> main.get("temp"))
                .filter(Number.class::isInstance)
                .map(val -> ((Number) val).doubleValue());
        //no temp means something went wrong
        if(tempOptional.isEmpty()) return Optional.empty();
        double temp = tempOptional.get();

        WeatherEntry entry = new WeatherEntry(city,temp, msg, LocalDateTime.now());

        return Optional.of(repo.save(entry));
    }

    public List<WeatherEntry> getEntriesByCity(String city) {
        return null;
    }

    public List<WeatherEntry> getAllEntries() {
        return null;
    }
}
