package com.envelo.integrationapp.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest {
    @Size(min = 3, max = 15, message = "Username should be between {min} and {max} characters.")
    private String username;
    @Size(min = 3, max = 15, message = "Password should be between {min} and {max} characters.")
    private String password;
}
