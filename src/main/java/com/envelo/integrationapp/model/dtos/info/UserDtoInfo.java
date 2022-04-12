package com.envelo.integrationapp.model.dtos.info;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDtoInfo {

    private long id;
    private String firstName;
    private String lastName;
}
