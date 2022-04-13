package com.envelo.integrationapp.services;

import com.envelo.integrationapp.model.dtos.EventCreationDto;
import com.envelo.integrationapp.model.dtos.PostCreationDto;
import com.envelo.integrationapp.model.dtos.PostEditionDto;
import com.envelo.integrationapp.model.entities.AppUser;
import com.envelo.integrationapp.model.entities.Event;
import com.envelo.integrationapp.model.entities.EventParticipant;

import com.envelo.integrationapp.model.entities.Post;
import com.envelo.integrationapp.repositories.EventRepository;
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
    private final EventRepository eventRepository;

    @Transactional
    public void addPost(long eventId, long userId, String description) {
        Post post = new Post();
        AppUser appUser = userRepository.getById(userId);
        Event event = eventRepository.getById(eventId);
        post.setAppUser(appUser);
        post.setDescription(description);
        event.getEventPosts().add(post);
        postRepository.save(post);
        eventRepository.save(event);
    }

    public void deletePost(long id) {
        Post post = postRepository.getById(id);
        postRepository.delete(post);
    }

    @Transactional
    public void updatePost(Long id, PostEditionDto eventCreationDto) {
            Post byId = postRepository.getById(id);
            byId.setDescription(eventCreationDto.getDescription());
    }
}

