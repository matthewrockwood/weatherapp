package com.example.weatherposting.controller;

import com.example.weatherposting.model.WeatherEntry;
import com.example.weatherposting.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/weather")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class WeatherAppController {

    private WeatherService service;
    @PostMapping
    public WeatherEntry postWeather(@RequestParam String city, @RequestParam String msg){
        return service.addEntry(city, msg).orElse(null);
    }
    @GetMapping
    public List<WeatherEntry> getWeather(){
        return service.getAllEntries();
    }
    @GetMapping("/{city}")
    public List<WeatherEntry> getWeather(@PathVariable String city){
        return service.getEntriesByCity(city);
    }
}
