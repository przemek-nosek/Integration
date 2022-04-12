package com.envelo.integrationapp.model.dtos;

import com.envelo.integrationapp.model.enums.PlaceType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EventPlaceDto {
    private Long id;
    private PlaceType placeType;
    private String city;
    private String street;
    private String streetNumber;
    private String localNumber;
    private String postCode;
}
