package com.envelo.integrationapp.services;

import com.envelo.integrationapp.model.dtos.EventCreationDto;
import com.envelo.integrationapp.model.dtos.PostCreationDto;
import com.envelo.integrationapp.model.dtos.PostEditionDto;
import com.envelo.integrationapp.model.entities.AppUser;
import com.envelo.integrationapp.model.entities.Event;
import com.envelo.integrationapp.model.entities.EventParticipant;
import com.envelo.integrationapp.model.entities.Post;
import com.envelo.integrationapp.repositories.PostRepository;
import com.envelo.integrationapp.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Transactional
    public void addPost(PostCreationDto postCreationDto) {
        Post post = new Post();
        AppUser appUser = userRepository.getById(postCreationDto.getAppUserId());
        post.setFile(postCreationDto.getFile());
        post.setDescription(postCreationDto.getDescription());
        post.setData(postCreationDto.getDate());
        post.setAppUser(appUser);
        postRepository.save(post);
    }

    @Transactional
    public void updatePost(Long id, PostEditionDto eventCreationDto) {
            Post byId = postRepository.getById(id);
            byId.setDescription(eventCreationDto.getDescription());
    }
}

