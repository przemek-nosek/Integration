package com.envelo.integrationapp.controllers;

import com.envelo.integrationapp.model.dtos.PostCreationDto;
import com.envelo.integrationapp.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public void addPost(@RequestBody PostCreationDto postCreationDto) {
        postService.addPost(postCreationDto);
    }


}
