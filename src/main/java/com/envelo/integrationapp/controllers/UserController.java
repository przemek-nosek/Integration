package com.envelo.integrationapp.controllers;

import com.envelo.integrationapp.model.dtos.UserDto;
import com.envelo.integrationapp.model.dtos.info.GroupDtoInfo;
import com.envelo.integrationapp.model.entities.AppUser;
import com.envelo.integrationapp.services.GroupService;
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
    public List<UserDto> getUsersWithName(@RequestParam String name) {
        return userService.getUsers(name);
    }
}
