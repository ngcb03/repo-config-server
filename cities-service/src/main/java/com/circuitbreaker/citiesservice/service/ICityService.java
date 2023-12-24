package com.circuitbreaker.citiesservice.service;

import com.circuitbreaker.citiesservice.model.City;
import com.circuitbreaker.citiesservice.dto.CityDTO;

import java.util.List;

public interface ICityService {

    public List<City> findCities();
    public CityDTO findCityWithHotels(String name, String country);
    public void createCity(City city);

}
