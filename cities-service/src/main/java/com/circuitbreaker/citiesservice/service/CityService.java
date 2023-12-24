package com.circuitbreaker.citiesservice.service;

import com.circuitbreaker.citiesservice.model.City;
import com.circuitbreaker.citiesservice.dto.CityDTO;
import com.circuitbreaker.citiesservice.dto.HotelDTO;
import com.circuitbreaker.citiesservice.repository.IHotelApiClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityService implements ICityService {

    @Autowired
    private IHotelApiClient hotelApi;

    private List<City> listCities = new ArrayList<>();

    @Override
    public List<City> findCities() {
        return this.listCities;
    }

    @Override
    // 1er parám: nombre servicio donde puede ocurrir falla
    // 2do parám: desviar flujo a método
    @CircuitBreaker(name = "hotels-service", fallbackMethod = "fallbackGetCitiesHotel")
    // reintenta después de un tiempo de haber ocurrido la falla
    // con el servicio nuevamete
    @Retry(name = "hotels-service")
    public CityDTO findCityWithHotels(String name, String country) {

        // buscamos la ciudad solicitada
        City city = this.findCity(name, country);

        // buscamos los hoteles disponibles en esa ciudad a
        // través de la API hacia el servicio hotels
        List<HotelDTO> listHotels =
                this.hotelApi.findCityWithHotels(city.getId_city());

        // causamos excepcion a propósito
        // this.createException();

        // unificamos todos los datos para devolver
        return new CityDTO(
                city.getId_city(),
                city.getName(),
                city.getContinent(),
                city.getCountry(),
                city.getState(),
                listHotels
        );
    }

    public City findCity(String name, String country){
        for(City city: this.listCities){
            if(city.getName().equals(name)
                    && city.getCountry().equals(country)){
                return city;
            }
        } return  null;
    }

    public CityDTO fallbackGetCitiesHotel(Throwable throwable){
        return new CityDTO(
                99999999L,
                "Fallido",
                "Fallido",
                "Fallido",
                "Fallido",
                null);
    }

    public void createException() {
        throw new IllegalArgumentException(
                "Prueba Resilience y Circuit Breaker");
    }

    @Override
    public void createCity(City city) {
        this.listCities.add(city);
    }
}
