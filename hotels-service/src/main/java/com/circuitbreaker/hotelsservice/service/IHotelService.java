package com.circuitbreaker.hotelsservice.service;

import com.circuitbreaker.hotelsservice.model.Hotel;

import java.util.List;

public interface IHotelService {

    public List<Hotel> findHotels();
    public List<Hotel> findHotelsByCity(Long city_id);
    public void createHotel(Hotel hotel);

}
