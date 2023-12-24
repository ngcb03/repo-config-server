package com.circuitbreaker.citiesservice.dto;

import lombok.Data;

@Data
public class HotelDTO {

    private Long hotel_id;
    private Long city_id;
    private String name;
    private Byte stars_number;
    private String continent;
    private String country;
    private String state;

}
