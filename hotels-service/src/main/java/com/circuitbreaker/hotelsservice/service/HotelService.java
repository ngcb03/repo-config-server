package com.circuitbreaker.hotelsservice.service;

import com.circuitbreaker.hotelsservice.model.Hotel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelService implements IHotelService {

    private ArrayList<Hotel> listaDeHoteles = new ArrayList<>();

    @Override
    public List<Hotel> findHotels() {
        return this.listaDeHoteles;
    }

    @Override
    public List<Hotel> findHotelsByCity(Long city_id) {
        if(!this.listaDeHoteles.isEmpty()) {
            List<Hotel> listaDeHotelesRes = new ArrayList<>();
            for(Hotel hotel: this.listaDeHoteles) {
                if(hotel.getCity_id() == city_id){
                    listaDeHotelesRes.add(hotel);
                }
            } return listaDeHotelesRes;
        } return null;
    }

    @Override
    public void createHotel(Hotel hotel) {
        this.listaDeHoteles.add(hotel);
    }
}
