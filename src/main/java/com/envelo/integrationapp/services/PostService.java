package com.envelo.integrationapp.services;

import com.envelo.integrationapp.model.dtos.PostCreationDto;
import com.envelo.integrationapp.model.entities.AppUser;
import com.envelo.integrationapp.model.entities.Post;
import com.envelo.integrationapp.repositories.PostRepository;
import com.envelo.integrationapp.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
