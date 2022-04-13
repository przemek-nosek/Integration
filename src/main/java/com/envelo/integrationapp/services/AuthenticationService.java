package com.envelo.integrationapp.services;

import com.envelo.integrationapp.model.dtos.AuthenticationRequest;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationService {

    private final JwtService jwtService;
    private final AppUserService appUserService;
    private final AuthenticationManager authenticationManager;

    public String getAuthenticationToken(AuthenticationRequest authenticationRequest) {

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUsername(), authenticationRequest.getPassword()
            ));
        } catch (BadCredentialsException | InternalAuthenticationServiceException e) {
            throw new RuntimeException("Invalid username or password");
        }

        UserDetails userDetails = appUserService.loadUserByUsername(authenticationRequest.getUsername());

        return jwtService.generateToken(userDetails);
    }
}