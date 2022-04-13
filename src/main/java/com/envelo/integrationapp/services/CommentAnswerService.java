package com.envelo.integrationapp.services;


import com.envelo.integrationapp.model.entities.*;

import com.envelo.integrationapp.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentAnswerService {

    private final CommentAnswerRepository commentAnswerRepository;
    private final PostCommentRepository postCommentRepository;
    private final UserRepository userRepository;

    @Transactional
    public void addComment(long postCommentId, long userId, String description) {
        CommentAnswer answer = new CommentAnswer();
        AppUser appUser = userRepository.getById(userId);
        PostComment postComment = postCommentRepository.getById(postCommentId);
        answer.setAppUser(appUser);
        answer.setDescription(description);
        postComment.getCommentAnswers().add(answer);
    }

}

