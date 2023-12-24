package com.circuitbreaker.citiesservice.model;

import lombok.Data;

@Data
public class City {

    private Long id_city;
    private String name;
    private String continent;
    private String country;
    private String state;

}
