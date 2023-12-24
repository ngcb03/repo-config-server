package com.circuitbreaker.citiesservice.repository;


import com.circuitbreaker.citiesservice.dto.HotelDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

// mismo nombre de la app de eureka
// así ya no es necesario configurar la url
@FeignClient (name = "hotels-service")
public interface IHotelApiClient {

    @GetMapping("/hotels/find-by-city/{city_id}")
    List<HotelDTO> findCityWithHotels(@PathVariable("city_id") Long city_id);

}
