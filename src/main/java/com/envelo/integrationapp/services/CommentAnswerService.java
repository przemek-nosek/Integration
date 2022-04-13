package com.envelo.integrationapp.services;

import com.envelo.integrationapp.model.dtos.CommentAnswerDto;
import com.envelo.integrationapp.model.entities.CommentAnswer;
import com.envelo.integrationapp.repositories.CommentAnswerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Slf4j
public class CommentAnswerService {

    private final CommentAnswerRepository commentAnswerRepository;

    @Transactional
    public void editCommentAnswer(Long id, CommentAnswerDto commentAnswerDto) {
        CommentAnswer byId = commentAnswerRepository.getById(id);

        byId.setDescription(commentAnswerDto.getDescription());
    }

    public void deleteComment(Long id) {
        commentAnswerRepository.deleteById(id);
    }
}
