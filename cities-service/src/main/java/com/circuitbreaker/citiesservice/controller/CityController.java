package com.circuitbreaker.citiesservice.controller;

import com.circuitbreaker.citiesservice.model.City;
import com.circuitbreaker.citiesservice.dto.CityDTO;
import com.circuitbreaker.citiesservice.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/cities")
public class CityController {
    @Autowired
    private ICityService service;

    @GetMapping("/")
    public List<City> findCities() {
        return this.service.findCities();
    }

    @GetMapping("/find-with-hotels/")
    public CityDTO findCityWithHotels(
            @RequestParam String name,
            @RequestParam String country) {
        return this.service.findCityWithHotels(name, country);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createCity(
            @RequestBody City city) {
        this.service.createCity(city);
        return new ResponseEntity<>(
                "¡The city has been created!",
                HttpStatus.CREATED
        );
    }

}
