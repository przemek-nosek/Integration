package com.envelo.integrationapp.model.entities;

import com.envelo.integrationapp.model.enums.PlaceType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "event_places")
@NoArgsConstructor
@Getter
@Setter
public class EventPlace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private PlaceType placeType;

    private String city;
    private String street;
    private String streetNumber;
    private String localNumber;
    private String postCode;
}
