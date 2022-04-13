package com.envelo.integrationapp.controllers;


import com.envelo.integrationapp.model.dtos.info.UserDtoInfo;
import com.envelo.integrationapp.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping
    public List<UserDtoInfo> getUsersWithName(@RequestParam String name) {
        return userService.getUsers(name);
    }
}
