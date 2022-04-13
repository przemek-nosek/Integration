package com.envelo.integrationapp.services;

import com.envelo.integrationapp.model.dtos.info.GroupDtoInfo;
import com.envelo.integrationapp.model.entities.AppUser;
import com.envelo.integrationapp.model.entities.Group;
import com.envelo.integrationapp.repositories.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    public List<GroupDtoInfo> getAllGroups() {
        List<Group> groups = groupRepository.findAll();
        List<GroupDtoInfo> groupDtoInfoList = new ArrayList<>();
        for (Group group : groups) {
            GroupDtoInfo groupDtoInfo = new GroupDtoInfo();
            groupDtoInfo.setId(group.getId());
            groupDtoInfo.setName(group.getName());
            groupDtoInfoList.add(groupDtoInfo);
        }
        return groupDtoInfoList;
    }

    public List<AppUser> getUsersFromGroup(long id) {
        return groupRepository.getById(id).getUsers();
    }
}
