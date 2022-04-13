package com.envelo.integrationapp.controllers;

import com.envelo.integrationapp.model.entities.AppUser;
import com.envelo.integrationapp.services.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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


    @PatchMapping("/{id}")
    public void updateGroup(@PathVariable long groupId, @RequestBody List<AppUser> users, String description) {
        groupService.updateGroup(users, description, groupId);
    }

    @DeleteMapping("/{id}")
    public void deleteGroup(@PathVariable long id) {
        groupService.deleteGroup(id);
    }
}
