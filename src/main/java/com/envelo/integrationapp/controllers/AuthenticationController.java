package com.envelo.integrationapp.controllers;

import com.envelo.integrationapp.model.dtos.AuthenticationRequest;
import com.envelo.integrationapp.model.dtos.AuthenticationResponse;
import com.envelo.integrationapp.services.AppUserService;
import com.envelo.integrationapp.services.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final AppUserService appUserService;

    @PostMapping
    public AuthenticationResponse getAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) {
        return new AuthenticationResponse(authenticationService.getAuthenticationToken(authenticationRequest));
    }


    @PostMapping("/register")
    public Long saveUserDetails(@Valid @RequestBody AuthenticationRequest authenticationRequest) {
        return appUserService.saveUser(authenticationRequest);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteUserAndAllHisData() {
//        appUserService.deleteUserAndAllHisData();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
