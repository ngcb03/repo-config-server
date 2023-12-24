package com.circuitbreaker.hotelsservice.model;

import lombok.Data;

@Data
public class Hotel {

    private Long hotel_id;
    private Long city_id;
    private String name;
    private Byte stars_number;
    private String continent;
    private String country;
    private String state;

}
