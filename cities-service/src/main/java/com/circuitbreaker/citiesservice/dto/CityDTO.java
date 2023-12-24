package com.circuitbreaker.citiesservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityDTO {

    private Long id_city;
    private String name;
    private String continent;
    private String country;
    private String state;
    private List<HotelDTO> listHotels;

}
