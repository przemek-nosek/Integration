package com.envelo.integrationapp.controllers;

import com.envelo.integrationapp.model.dtos.PostCreationDto;
import com.envelo.integrationapp.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/{eventId}/users/{userId}/")
    public void addPost(@PathVariable long eventId, @PathVariable long userId, @RequestParam String description ) {
        postService.addPost(eventId, userId, description);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable long id) {
        postService.deletePost(id);
    }


}
