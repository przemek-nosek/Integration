package com.envelo.integrationapp.services;

import com.envelo.integrationapp.model.dtos.info.UserDtoInfo;
import com.envelo.integrationapp.model.entities.AppUser;
import com.envelo.integrationapp.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<UserDtoInfo> getUsers(String name) {
        Pattern pattern = Pattern.compile(name);
        List<UserDtoInfo> usersDto = new ArrayList<>();
        List<AppUser> users = userRepository.findAll();
        for(AppUser user : users){
            Matcher matcher = pattern.matcher(user.getFirstName() + user.getLastName());
            if(matcher.find()){
                UserDtoInfo userDto = new UserDtoInfo();
                userDto.setId(user.getId());
                userDto.setFirstName(user.getFirstName());
                userDto.setLastName(user.getLastName());
                usersDto.add(userDto);
            }
        }
        return usersDto;
    }

}
