package com.envelo.integrationapp.controllers;

import com.envelo.integrationapp.services.CommentAnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/answers")
@RequiredArgsConstructor
public class CommentAnswerController {

    private final CommentAnswerService commentAnswerService;

    @PostMapping("/{postCommentId}/users/{userId}/")
    public void addComment(@PathVariable long postCommentId, @PathVariable long userId, @RequestParam String description ) {
        commentAnswerService.addComment(postCommentId, userId, description);
    }

}
