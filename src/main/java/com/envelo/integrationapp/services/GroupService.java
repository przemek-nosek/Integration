package com.envelo.integrationapp.services;

import com.envelo.integrationapp.model.entities.AppUser;
import com.envelo.integrationapp.model.entities.Group;
import com.envelo.integrationapp.repositories.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupService {

    private final GroupRepository groupRepository;

    @Transactional
    public void createGroup(List<AppUser> users, String name) {
        Group group = new Group();
        users.forEach(user -> group.getUsers().add(user));
        group.setName(name);
        groupRepository.save(group);
    }

    @Transactional
    public void updateGroup(List<AppUser> users, String name, long groupId) {
        Group group = groupRepository.getById(groupId);
        users.forEach(user -> group.getUsers().add(user));
        group.setName(name);
        groupRepository.save(group);
    }

    public void deleteGroup(long id) {
        groupRepository.deleteById(id);
    }
}
