package com.envelo.integrationapp.services;

import com.envelo.integrationapp.model.entities.*;

import com.envelo.integrationapp.repositories.PostCommentRepository;
import com.envelo.integrationapp.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import com.envelo.integrationapp.model.dtos.CommentAnswerDto;
import com.envelo.integrationapp.model.entities.CommentAnswer;
import com.envelo.integrationapp.repositories.CommentAnswerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommentAnswerService {

    private final CommentAnswerRepository commentAnswerRepository;
    private final PostCommentRepository postCommentRepository;
    private final UserRepository userRepository;

    @Transactional
    public void editCommentAnswer(Long id, CommentAnswerDto commentAnswerDto) {
        CommentAnswer byId = commentAnswerRepository.getById(id);

        byId.setDescription(commentAnswerDto.getDescription());
    }

    public void deleteComment(Long id) {
        commentAnswerRepository.deleteById(id);
    }

    @Transactional
    public void addComment(long postCommentId, long userId, CommentAnswerDto commentAnswerDto) {
        CommentAnswer answer = new CommentAnswer();
        AppUser appUser = userRepository.getById(userId);
        PostComment postComment = postCommentRepository.getById(postCommentId);
        answer.setAppUser(appUser);
        answer.setDescription(commentAnswerDto.getDescription());
        answer.setData(LocalDateTime.now());
        postComment.getCommentAnswers().add(answer);
        commentAnswerRepository.save(answer);
        postCommentRepository.save(postComment);
    }
}
