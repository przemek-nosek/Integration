package com.envelo.integrationapp.model.dtos.info;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EventPlaceDtoInfo {

    private String city;
    private String street;
    private String streetNumber;
    private String localNumber;
    private String postCode;
}
