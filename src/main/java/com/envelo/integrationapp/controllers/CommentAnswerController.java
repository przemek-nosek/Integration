package com.envelo.integrationapp.controllers;


import com.envelo.integrationapp.model.dtos.CommentAnswerDto;
import com.envelo.integrationapp.services.CommentAnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment-answers")
@RequiredArgsConstructor
public class CommentAnswerController {

    private final CommentAnswerService commentAnswerService;

    @PostMapping("/{postCommentId}/users/{userId}")
    public void addComment(@PathVariable long postCommentId, @PathVariable long userId,
                           @RequestBody CommentAnswerDto commentAnswerDto ) {
        commentAnswerService.addComment(postCommentId, userId, commentAnswerDto);
    }

    @PatchMapping("/{id}")
    public void editCommentAnswer(@PathVariable Long id, @RequestBody CommentAnswerDto commentAnswerDto) {
        commentAnswerService.editCommentAnswer(id, commentAnswerDto);
    }

    @DeleteMapping("/{id}")
    public void editCommentAnswer(@PathVariable Long id) {
        commentAnswerService.deleteComment(id);
    }
}
