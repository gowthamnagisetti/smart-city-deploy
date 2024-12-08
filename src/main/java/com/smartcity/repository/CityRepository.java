package com.smartcity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.smartcity.model.City;

public interface CityRepository extends JpaRepository<City, Long> {
}
