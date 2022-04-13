package com.envelo.integrationapp.services;

import com.envelo.integrationapp.model.dtos.AuthenticationRequest;
import com.envelo.integrationapp.model.entities.AppUser;
import com.envelo.integrationapp.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
@Slf4j
public class AppUserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AppUser appUser = userRepository.findByEmail(email)
                .orElseThrow(() -> {
                    log.error(String.format("Username [%s] not found", email));
                    throw new UsernameNotFoundException(String.format("Username [%s] not found", email));
                });
        return new User(appUser.getEmail(), appUser.getPassword(), new ArrayList<>());
    }

    public Long saveUser(AuthenticationRequest authenticationRequest) {
        log.info("AuthenticationRequest deatails {}", authenticationRequest);
        String username = authenticationRequest.getUsername();

//        validateIfUserExists(username);

        AppUser appUser = new AppUser();
        appUser.setEmail(username);
        appUser.setPassword(authenticationRequest.getPassword());


        AppUser savedAppUser = userRepository.save(appUser);

        log.info("AppUser saved with id: {}", savedAppUser.getId());
        return savedAppUser.getId();
    }

//    private void validateIfUserExists(String username) {
//        boolean existsByUsername = username.existsByUsername(username);
//        if (existsByUsername) {
//            log.error(String.format("Username [%s] already exists", username));
//            throw new UsernameAlreadyExistsException(String.format("Username [%s] already exists", username));
//        }
//    }
}