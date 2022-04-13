package com.envelo.integrationapp.controllers;

import com.envelo.integrationapp.model.entities.AppUser;
import com.envelo.integrationapp.services.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/groups")
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    @PostMapping("")
    public void addGroup(@RequestBody List<AppUser> users, String description) {
        groupService.createGroup(users, description);
    }
}
