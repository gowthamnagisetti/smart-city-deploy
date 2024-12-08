package com.smartcity.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.smartcity.model.City;
import com.smartcity.service.CityService;

@RestController
@RequestMapping("/api/cities")
public class CityController {
    @Autowired
    private CityService cityService;

    @GetMapping
    public List<City> getAllCities() {
        return cityService.getAllCities();
    }

    @PostMapping
    public City saveCity(@RequestBody City city) {
        return cityService.addCity(city);
    }

    @DeleteMapping("/{id}")
    public void deleteCity(@PathVariable Long id) {
        cityService.deleteCity(id);
    }
}
