package com.circuitbreaker.hotelsservice.controller;

import com.circuitbreaker.hotelsservice.model.Hotel;
import com.circuitbreaker.hotelsservice.service.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private IHotelService service;

    @GetMapping("/")
    public List<Hotel> findHotels(){
        return this.service.findHotels();
    }

    @GetMapping("/find-by-city/{city_id}")
    public List<Hotel> findHotelsByCity(
            @PathVariable("city_id") Long city_id) {
        return this.service.findHotelsByCity(city_id);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createCity(@RequestBody Hotel hotel) {
        this.service.createHotel(hotel);
        return  new ResponseEntity<>(
                "¡The city has been created!",
                HttpStatus.CREATED
        );
    }

}
