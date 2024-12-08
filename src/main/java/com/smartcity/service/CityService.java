package com.smartcity.service;

import com.smartcity.model.City;
import com.smartcity.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    // Add a new city
    public City addCity(City city) {
        return cityRepository.save(city);
    }

    // Get all cities
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    // Get a city by ID
    public City getCityById(Long id) {
        return cityRepository.findById(id).orElseThrow(() -> new RuntimeException("City not found"));
    }

    // Update a city
    public City updateCity(Long id, City updatedCity) {
        City existingCity = getCityById(id);
        existingCity.setName(updatedCity.getName());
        existingCity.setDescription(updatedCity.getDescription());
        existingCity.setInfrastructureDetails(updatedCity.getInfrastructureDetails());
        existingCity.setAmenities(updatedCity.getAmenities());
        return cityRepository.save(existingCity);
    }

    // Delete a city
    public void deleteCity(Long id) {
        cityRepository.deleteById(id);
    }
}
