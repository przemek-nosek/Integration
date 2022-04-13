package com.envelo.integrationapp.controllers;

import com.envelo.integrationapp.model.dtos.PostCommentDto;
import com.envelo.integrationapp.services.PostCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class PostCommentController {

    private final PostCommentService postCommentService;

    @PatchMapping("/{id}")
    public void updateComment(@PathVariable Long id, @RequestBody PostCommentDto postCommentDto) {
        postCommentService.updateComment(id, postCommentDto);
    }

    @PostMapping("/{postId}/users/{userId}")
    public void addPostComment(@PathVariable long postId, @PathVariable long userId, @RequestParam String description) {
        postCommentService.addCommentPost(postId, userId, description);
    }
}
