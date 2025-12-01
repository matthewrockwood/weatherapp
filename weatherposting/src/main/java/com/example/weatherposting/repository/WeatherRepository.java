package com.example.weatherposting.repository;

import com.example.weatherposting.model.WeatherEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherRepository extends JpaRepository<WeatherEntry,Long> {

}
