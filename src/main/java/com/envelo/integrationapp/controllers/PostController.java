package com.envelo.integrationapp.controllers;

import com.envelo.integrationapp.model.dtos.PostCreationDto;
import com.envelo.integrationapp.model.dtos.PostEditionDto;
import com.envelo.integrationapp.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PatchMapping("/{id}")
    public void updatePost(@RequestBody PostEditionDto eventCreationDto, @PathVariable Long id) {
        postService.updatePost(id, eventCreationDto);
    }
    @PostMapping
    public void addPost(@RequestBody PostCreationDto postCreationDto) {
        postService.addPost(postCreationDto);
    }
}
